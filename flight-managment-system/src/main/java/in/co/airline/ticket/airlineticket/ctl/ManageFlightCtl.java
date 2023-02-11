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
import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.exception.DuplicateRecordException;
import in.co.airline.ticket.airlineticket.form.ManageFlightForm;
import in.co.airline.ticket.airlineticket.service.AirportServiceInt;
import in.co.airline.ticket.airlineticket.service.FlightServiceInt;
import in.co.airline.ticket.airlineticket.service.ManageFlightServiceInt;



@Controller
public class ManageFlightCtl extends BaseCtl {

	private Logger log = Logger.getLogger(ManageFlightCtl.class.getName());
	
	@Autowired
	private ManageFlightServiceInt service;
	
	@Autowired
	private AirportServiceInt airportService;
	
	@Autowired
	private FlightServiceInt flightService;
	
	@ModelAttribute
	public void preload(Model model) {		
		model.addAttribute("airportList",airportService.search(null));
		model.addAttribute("flightList",flightService.search(null));
	}
	
	@GetMapping("/ctl/manage")
	public String display(@ModelAttribute("form") ManageFlightForm form, Model model) {
		log.info("ManageFlightCtl ManageFlight display method start");
		if(form.getId()>0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("ManageFlightCtl ManageFlight display method end");
		return "manage";
	}
	
	@PostMapping("/ctl/manage")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") ManageFlightForm form,
			BindingResult bindingResult, Model model) {

		log.info("ManageFlightCtl ManageFlight submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/manage";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "manage";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("in Save");
				ManageFlightDTO dto = (ManageFlightDTO) form.getDTO();
				dto.setArrivalAirportName(airportService.findBypk(dto.getArrivalAirportId()).getName());
				dto.setDepartureAirportName(airportService.findBypk(dto.getDepartureAirportId()).getName());
				dto.setFlightName(flightService.findBypk(dto.getFlightId()).getName());
				dto.setFlightNo(flightService.findBypk(dto.getFlightId()).getFlightNo());
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "manage";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "manage";
		}

		log.info("ManageFlightCtl ManageFlight submit method end");
		return "manage";
	}
	
	
	@RequestMapping(value = "/ctl/manage/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session,@ModelAttribute("form") ManageFlightForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/manage/search";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/manage";
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
					ManageFlightDTO dto = new ManageFlightDTO();
					dto.setId(id);
					service.delete(dto);
				}

				Integer[] lengths = { form.getIds().length };
				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error","Select at least one record");
			}
		}
		ManageFlightDTO dto=(ManageFlightDTO)form.getDTO();
		

		List<ManageFlightDTO> list = service.search(dto, pageNo, pageSize);
		
		List<ManageFlightDTO> totallist= service.search(dto);
		
		
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

		return "manageList";

	}
	
}
