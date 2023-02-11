package in.co.airline.ticket.airlineticket.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.form.InvoiceForm;
import in.co.airline.ticket.airlineticket.form.ManageFlightForm;
import in.co.airline.ticket.airlineticket.service.InvoiceDetailServiceInt;
import in.co.airline.ticket.airlineticket.util.DataUtility;

@Controller
public class SuccessCtl  extends BaseCtl{
	
	@Autowired
	private InvoiceDetailServiceInt inService;
	
	@RequestMapping(value = {"/success" }, method = { RequestMethod.GET,RequestMethod.POST})
    public String dispaly(HttpSession session,@ModelAttribute("form") InvoiceForm form,
			@RequestParam(required = false) String operation,Long iNo, Model model) {
	 
	 if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/success";
		}

		
		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		
		InvoiceDetailDTO dto=new InvoiceDetailDTO();
		if (DataUtility.getLong(String.valueOf(iNo)) > 0) {
			dto.setInvoiceNo(DataUtility.getLong(String.valueOf(iNo)));
		}

		List<InvoiceDetailDTO> list = inService.search(dto, pageNo, pageSize);
		
		List<InvoiceDetailDTO> totallist= inService.search(dto);
		
		
		model.addAttribute("list", list);
		
		if (list.size() == 0) {
			model.addAttribute("error", "Record Not found");
		}
	
		model.addAttribute("success","Ticeket Booked Successfully");
		
		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
        return "success";
    }
}
