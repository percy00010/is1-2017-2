package portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import portal.service.PortalService;

@Controller
@RequestMapping("/portal")
public class PortalController {
	@Autowired
	  PortalService portalService;
	  @RequestMapping
	  public String menu(ModelMap model,
	      @RequestParam(value = "message", required = false) String message) {
	    model.addAttribute("message", message);
	    return "portal/menu";
	  }
}
