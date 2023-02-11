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

import in.co.airline.ticket.airlineticket.dto.ManageFlightDTO;
import in.co.airline.ticket.airlineticket.form.ManageFlightForm;
import in.co.airline.ticket.airlineticket.service.ManageFlightServiceInt;

@Controller
public class WelcomeCtl extends BaseCtl {

	@Autowired
	private ManageFlightServiceInt manageFlightService;
	
	 @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	    public String welcome(Model model) {
	        return "welcome";
	    }
	 
	 @RequestMapping(value = {"/home" }, method = {RequestMethod.GET,RequestMethod.POST})
	    public String home(HttpSession session,@ModelAttribute("form") ManageFlightForm form,
				@RequestParam(required = false) String operation, Model model) {
		 
		 if (OP_RESET.equalsIgnoreCase(operation)) {
				return "redirect:/home";
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

			
			ManageFlightDTO dto=(ManageFlightDTO)form.getDTO();
			

			List<ManageFlightDTO> list = manageFlightService.search(dto, pageNo, pageSize);
			
			List<ManageFlightDTO> totallist= manageFlightService.search(dto);
			
			
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
		 
	        return "home";
	    }
	 
	 
}
