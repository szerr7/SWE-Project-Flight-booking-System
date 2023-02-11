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

import in.co.airline.ticket.airlineticket.dto.AirportDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;
import in.co.airline.ticket.airlineticket.form.AirportForm;
import in.co.airline.ticket.airlineticket.service.AirportServiceInt;



@Controller
public class AirportCtl extends BaseCtl {

	private Logger log = Logger.getLogger(AirportCtl.class.getName());
	
	@Autowired
	private AirportServiceInt service;
	
	@GetMapping("/ctl/airport")
	public String display(@ModelAttribute("form") AirportForm form, Model model) {
		log.info("AirportCtl airport display method start");
		if(form.getId()>0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("AirportCtl airport display method end");
		return "airport";
	}
	
	@PostMapping("/ctl/airport")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") AirportForm form,
			BindingResult bindingResult, Model model) {

		log.info("AirportCtl airport submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/airport";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "airport";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("in Save");
				AirportDTO dto = (AirportDTO) form.getDTO();
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "airport";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "airport";
		}

		log.info("AirportCtl airort submit method end");
		return "airport";
	}
	
	
	@RequestMapping(value = "/ctl/airport/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session,@ModelAttribute("form") AirportForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/airport/search";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/airport";
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
					AirportDTO dto = new AirportDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		AirportDTO dto=(AirportDTO)form.getDTO();
		

		List<AirportDTO> list = service.search(dto, pageNo, pageSize);
		
		List<AirportDTO> totallist= service.search(dto);
		
		
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

		return "airportList";

	}
	
}
