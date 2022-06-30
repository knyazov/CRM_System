package systema.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import systema.crm.entities.ApplicationRequest;
import systema.crm.entities.Courses;
import systema.crm.repositories.ApplicationRequestRepository;
import systema.crm.repositories.CoursesRepository;
import systema.crm.services.ApplicationRequestService;

@Controller
public class Controllers {

    @Autowired
    private ApplicationRequestService appRequestService;

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @Autowired
    private CoursesRepository coursesRepository;

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
        return "details";
    }

    @GetMapping(value = "/addRequest")
    private String addRequestDoGet(Model model) {
        model.addAttribute("allCourses", appRequestService.getAllCourses());
        return "addRequest";
    }

    @PostMapping(value = "/addRequest")
    private String addRequestDoPost(@RequestParam(name = "userName") String userName,
                                    @RequestParam(name = "courseName_id") Long courseName_id,
                                    @RequestParam(name = "phone") String phone,
                                    @RequestParam(name = "commentary") String commentary) {

        if (coursesRepository.existsById(courseName_id)) {
            Courses courseName = appRequestService.getCourse(courseName_id);

            ApplicationRequest applicationRequest = new ApplicationRequest();
            applicationRequest.setUserName(userName);
            applicationRequest.setCommentary(commentary);
            applicationRequest.setPhone(phone);
            applicationRequest.setCourseName(courseName);
            applicationRequest.setHandled(false);

            appRequestService.saveRequest(applicationRequest);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    private String delete(@PathVariable(name = "id") Long id) {
        if (appRequestService.isExist(id)) {
            appRequestService.deleteRequest(id);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/trueRequest/{id}")
    private String trueRequestDoPost(@PathVariable(name = "id") Long id) {

        if (appRequestService.isExist(id)) {
            ApplicationRequest applicationRequest = appRequestService.getRequestById(id);
            applicationRequest.setHandled(true);

            appRequestService.saveRequest(applicationRequest);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/handled/{handled}")
    private String handledPage(Model model,
                               @PathVariable(name = "handled") Boolean handled) {
        if (handled == false) {
            model.addAttribute("allRequests", applicationRequestRepository.findAllByHandledIsFalse());
            model.addAttribute("allCourses", appRequestService.getAllCourses());
            return "handled";
        } else {
            model.addAttribute("allRequests", applicationRequestRepository.findAllByHandledIsTrue());
            model.addAttribute("allCourses", appRequestService.getAllCourses());
            return "handled";
        }
    }
}