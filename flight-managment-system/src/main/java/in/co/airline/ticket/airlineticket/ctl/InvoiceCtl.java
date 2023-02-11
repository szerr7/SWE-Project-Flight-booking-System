package in.co.airline.ticket.airlineticket.ctl;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.airline.ticket.airlineticket.dto.AirportDTO;
import in.co.airline.ticket.airlineticket.dto.FlightDTO;
import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.dto.UserDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;
import in.co.airline.ticket.airlineticket.form.AirportForm;
import in.co.airline.ticket.airlineticket.form.FlightForm;
import in.co.airline.ticket.airlineticket.form.InvoiceForm;
import in.co.airline.ticket.airlineticket.service.InvoiceServiceInt;
import in.co.airline.ticket.airlineticket.service.ManageFlightServiceInt;
import in.co.airline.ticket.airlineticket.util.DataUtility;

@Controller
public class InvoiceCtl extends BaseCtl {

	private Logger log = Logger.getLogger(InvoiceCtl.class.getName());

	@Autowired
	private ManageFlightServiceInt manageFlihgtService;
	
	@Autowired
	private InvoiceServiceInt service;

	@GetMapping("/ctl/invoice")
	public String display(@RequestParam(required = false) Long fid, @ModelAttribute("form") InvoiceForm form,
			Model model) {
		log.info("InvoiceCtl Flight display method start");
		if (fid > 0) {
			ManageFlightDTO dto = manageFlihgtService.findBypk(fid);
			form.setFlightNo(dto.getFlightNo());
			form.setFlightName(dto.getFlightName());
			form.setArrivalDate(DataUtility.getDateString(dto.getArrivalDate()));
			form.setDepartureDate(DataUtility.getDateString(dto.getDepartureDate()));
			form.setArrivalCity(dto.getArrivalCity());
			form.setDepartureCity(dto.getDepartureCity());
			form.setPrice(dto.getPrice());
			model.addAttribute("dto", form);
		}
		log.info("InvoiceCtl Flight display method end");
		return "invoice";
	}

	@PostMapping("/ctl/invoice")
	public String submit(@RequestParam String operation,HttpServletRequest request,HttpSession session ,@Valid @ModelAttribute("form") InvoiceForm form,
			BindingResult bindingResult, Model model) {
		log.info("InvoiceCtl Flight submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/invoice";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "invoice";
		}

		if (OP_SUBMIT.equalsIgnoreCase(form.getOperation())) {
			InvoiceDTO dto = (InvoiceDTO) form.getDTO();
			UserDTO udto=(UserDTO)session.getAttribute("user");
			dto.setUserName(udto.getFirstName()+" "+udto.getLastName());
			dto.setUserId(udto.getId());
			dto.setTotalAmount(String.valueOf(DataUtility.getLong(dto.getPrice())*DataUtility.getLong(dto.getNop())));
			session.setAttribute("invoice",dto);
			session.setAttribute("nop",DataUtility.getInt(dto.getNop()));
			return "redirect:/ctl/invoiceDetail";
		}

		log.info("InvoiceCtl Flight submit method end");
		return "invoice";
	}
	
	@RequestMapping(value = "/ctl/invoice/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session,@ModelAttribute("form") InvoiceForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/invoice/search";
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

		if (OP_DELETE.equalsIgnoreCase(operation)) {
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					InvoiceDTO dto = new InvoiceDTO();
					dto.setId(id);
					service.delete(dto);
				}

				Integer[] lengths = { form.getIds().length };
				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		InvoiceDTO dto=(InvoiceDTO)form.getDTO();
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		
		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}

		List<InvoiceDTO> list = service.search(dto, pageNo, pageSize);
		
		List<InvoiceDTO> totallist= service.search(dto);
		
		
		model.addAttribute("list", list);
		
		if (list.size() == 0) {
			model.addAttribute("error", "Record Not found");
		}
		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize=pageNo*pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		
		model.addAttribute("total", total);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "invoiceList";

	}

}
