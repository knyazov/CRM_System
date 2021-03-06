package systema.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import systema.crm.entities.ApplicationRequest;
import systema.crm.entities.Courses;
import systema.crm.entities.Operators;
import systema.crm.repositories.ApplicationRequestRepository;
import systema.crm.repositories.CoursesRepository;
import systema.crm.repositories.OperatorsRepository;
import systema.crm.services.ApplicationRequestService;

import java.util.List;

@Controller
public class Controllers {

    @Autowired
    private ApplicationRequestService appRequestService;

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @Autowired
    private OperatorsRepository operatorsRepository;

    @GetMapping(value = "/")
    private String indexPage(Model model) {
        model.addAttribute("allRequests", applicationRequestRepository.getAll());
        model.addAttribute("allCourses", appRequestService.getAllCourses());
        return "index";
    }

    @GetMapping(value = "/details/{id}")
    private String details(Model model,
                           @PathVariable(name = "id") Long id) {
        model.addAttribute("allCourses", appRequestService.getAllCourses());
        model.addAttribute("request", appRequestService.getRequestById(id));
        model.addAttribute("operatorsByReq", appRequestService.getOperatorsByRequest(id));
        model.addAttribute("operators", operatorsRepository.findAll());
        return "details";
    }

    @GetMapping(value = "/addRequest")
    private String addRequestDoGet(Model model) {
        model.addAttribute("allCourses", appRequestService.getAllCourses());
        return "addRequest";
    }

    @PostMapping(value = "/addRequest")
    private String addRequestDoPost(@ModelAttribute("requestObj") ApplicationRequest requestObj,
                                    @RequestParam(name = "courseName_id") Long courseName_id) {
        appRequestService.addRequest(requestObj, courseName_id);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    private String delete(@PathVariable(name = "id") Long id) {
        appRequestService.deleteRequest(id);
        return "redirect:/";
    }

    @PostMapping(value = "/trueRequest/{id}")
    private String trueRequestDoPost(@PathVariable(name = "id") Long id,
                                     @RequestParam(name = "operatorId[]") Long[] operatorId) {
        appRequestService.assignOperator(operatorId, id);
        return "redirect:/details/" + id;
    }

    @GetMapping(value = "/handled/{handled}")
    private String handledPage(Model model,
                               @PathVariable(name = "handled") Boolean handled) {
        if (!handled) {
            model.addAttribute("allRequests", applicationRequestRepository.findAllByHandledIsFalse());
        } else {
            model.addAttribute("allRequests", applicationRequestRepository.findAllByHandledIsTrue());
        }
        model.addAttribute("allCourses", appRequestService.getAllCourses());
        return "handled";
    }

    @PostMapping(value = "/unAssignOperators/{id}")
    private String unAssignOperators(@PathVariable(name = "id") Long requestId,
                                     @RequestParam(name = "operatorId") Long operatorId) {
        appRequestService.unAssignOperator(operatorId, requestId);
        return "redirect:/details/" + requestId;
    }
}