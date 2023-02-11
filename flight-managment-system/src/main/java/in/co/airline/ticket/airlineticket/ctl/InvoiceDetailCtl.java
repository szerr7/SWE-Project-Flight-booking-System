package in.co.airline.ticket.airlineticket.ctl;

import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.GetOptions.GetNulls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.airline.ticket.airlineticket.dto.InvoiceDTO;
import in.co.airline.ticket.airlineticket.dto.InvoiceDetailDTO;
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.dto.UserDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;
import in.co.airline.ticket.airlineticket.form.InvoiceDetailForm;
import in.co.airline.ticket.airlineticket.form.InvoiceForm;
import in.co.airline.ticket.airlineticket.form.ManageFlightForm;
import in.co.airline.ticket.airlineticket.service.InvoiceDetailServiceInt;
import in.co.airline.ticket.airlineticket.service.InvoiceServiceInt;
import in.co.airline.ticket.airlineticket.service.ManageFlightServiceInt;
import in.co.airline.ticket.airlineticket.util.DataUtility;

@Controller
public class InvoiceDetailCtl extends BaseCtl {

	private Logger log = Logger.getLogger(InvoiceDetailCtl.class.getName());

	@Autowired
	private InvoiceServiceInt invoiceService;

	@Autowired
	private InvoiceDetailServiceInt invoiceDetailService;

	@RequestMapping(value = { "/ctl/invoiceDetail" }, method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, HttpSession session,
			@ModelAttribute("form") InvoiceDetailForm form, Model model) {
		log.info("InvoiceDetailCtl Flight welcome method start");
		int nop = (int) session.getAttribute("nop");
		if (nop > 0) {
			request.setAttribute("nop", nop);
		}
		log.info("InvoiceDetailCtl Flight welcome method end");
		return "invoiceDetail";
	}

	@RequestMapping(value = { "/ctl/invoiceDetail" }, method = RequestMethod.POST)
	public String submit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("form") InvoiceDetailForm form, Model model) {
		log.info("InvoiceDetailCtl Flight submit method start");
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/invoiceDetail";
		}
		if (OP_SUBMIT.equalsIgnoreCase(form.getOperation())) {
			session.setAttribute("invoiceDetail", form);
		}
		log.info("InvoiceDetailCtl Flight submit method end");
		return "payment";
	}

	@RequestMapping(value = { "/ctl/payment" }, method = RequestMethod.POST)
	public String payemnt(HttpServletRequest request, HttpSession session,
			@ModelAttribute("form") InvoiceDetailForm form, Model model) {
		log.info("InvoiceDetailCtl Flight submit payemnt start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/invoice";
		}

		if (OP_CONFIRM_PAYMENT.equalsIgnoreCase(form.getOperation())) {
			try {
				InvoiceDTO dto = (InvoiceDTO) session.getAttribute("invoice");
				InvoiceDetailForm inform = (InvoiceDetailForm) session.getAttribute("invoiceDetail");
				dto.setInvoiceNo(DataUtility.getRandom());
				long pk = invoiceService.add(dto);
				InvoiceDetailDTO indto = null;
				String name[] = new String[DataUtility.getInt(dto.getNop()) + 1];
				String gender[] = new String[DataUtility.getInt(dto.getNop()) + 1];
				String dob[] = new String[DataUtility.getInt(dto.getNop()) + 1];

				if (inform.getName() != null) {
					int i = 0;
					for (String n : inform.getName()) {
						name[i++] = n;
					}
				}
				System.out.println("Name---" + name.toString());
				if (inform.getGender() != null) {
					int i = 0;
					for (String n : inform.getGender()) {
						gender[i++] = n;
					}
				}
				System.out.println("Gender---" + gender.toString());
				if (inform.getDob() != null) {
					int i = 0;
					for (String n : inform.getDob()) {
						dob[i++] = n;
					}
				}
				System.out.println("Dob---" + dob.toString());
				System.out.println(dto.getNop());
				for (int i = 0; i < DataUtility.getInt(dto.getNop()); i++) {
					indto = new InvoiceDetailDTO();
					indto.setInvoiceNo(invoiceService.findBypk(pk).getInvoiceNo());
					indto.setFlightNo(dto.getFlightNo());
					indto.setFlightName(dto.getFlightName());
					indto.setArrivalCity(dto.getArrivalCity());
					indto.setDate(new Date());
					indto.setDepartureCity(dto.getDepartureCity());
					indto.setPrice(dto.getPrice());
					indto.setName(name[i]);
					indto.setGender(gender[i]);
					indto.setDob(DataUtility.getDate(dob[i]));
					indto.setUserId(dto.getUserId());
					System.out.println(indto.toString());
					invoiceDetailService.add(indto);
				}
				return "redirect:/success?iNo=" + dto.getInvoiceNo();

			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("InvoiceDetailCtl Flight submit payemnt end");
		return "payment";
	}

	@RequestMapping(value = "/ctl/invoiceDetail/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") InvoiceDetailForm form,
			@RequestParam(required = false) String operation,Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/invoiceDetail/search";
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
					InvoiceDetailDTO dto = new InvoiceDetailDTO();
					dto.setId(id);
					invoiceDetailService.delete(dto);
				}

				Integer[] lengths = { form.getIds().length };
				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		InvoiceDetailDTO dto = (InvoiceDetailDTO) form.getDTO();
		
		
		UserDTO uDto=(UserDTO)session.getAttribute("user");
		
		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}
		
		List<InvoiceDetailDTO> list = invoiceDetailService.search(dto, pageNo, pageSize);

		List<InvoiceDetailDTO> totallist = invoiceDetailService.search(dto);

		model.addAttribute("list", list);

		if (list.size() == 0) {
			model.addAttribute("error", "Record Not found");
		}
		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);

		model.addAttribute("total", total);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "invoiceDetailList";

	}

}
