package in.co.airline.ticket.airlineticket.ctl;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import in.co.airline.ticket.airlineticket.dto.FlightDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;
import in.co.airline.ticket.airlineticket.form.FlightForm;
import in.co.airline.ticket.airlineticket.service.FlightServiceInt;



@Controller
public class FlightCtl extends BaseCtl {

	private Logger log = Logger.getLogger(FlightCtl.class.getName());
	
	@Autowired
	private FlightServiceInt service;
	
	@GetMapping("/ctl/flight")
	public String display(@ModelAttribute("form") FlightForm form, Model model) {
		log.info("FlightCtl Flight display method start");
		if(form.getId()>0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("FlightCtl Flight display method end");
		return "flight";
	}
	
	@PostMapping("/ctl/flight")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") FlightForm form,
			BindingResult bindingResult, Model model) {

		log.info("FlightCtl Flight submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/flight";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "flight";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				FlightDTO dto = (FlightDTO) form.getDTO();
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "flight";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "flight";
		}

		log.info("FlightCtl Flight submit method end");
		return "Flight";
	}
	
	
	@RequestMapping(value = "/ctl/flight/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session,@ModelAttribute("form") FlightForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/flight/search";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/flight";
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
					FlightDTO dto = new FlightDTO();
					dto.setId(id);
					service.delete(dto);
				}

				Integer[] lengths = { form.getIds().length };
				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		FlightDTO dto=(FlightDTO)form.getDTO();
		

		List<FlightDTO> list = service.search(dto, pageNo, pageSize);
		
		List<FlightDTO> totallist= service.search(dto);
		
		
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
		return "flightList";
	}
}
