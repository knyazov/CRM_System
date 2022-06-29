package systema.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import systema.crm.services.ApplicationRequestService;

@Controller
public class Controllers {

    @Autowired
    private ApplicationRequestService appRequestService;

    @GetMapping(value = "/")
    private String indexPage(Model model) {
        model.addAttribute("allRequests", appRequestService.getAllRequests());
        return "index";
    }


}
