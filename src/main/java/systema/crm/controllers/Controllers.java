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
import systema.crm.repositories.CoursesRepository;
import systema.crm.services.ApplicationRequestService;

@Controller
public class Controllers {

    @Autowired
    private ApplicationRequestService appRequestService;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping(value = "/")
    private String indexPage(Model model) {
        model.addAttribute("allRequests", appRequestService.getAllRequests());
        model.addAttribute("allCourses", coursesRepository.findAll());
        return "index";
    }

    @GetMapping(value = "/details/{id}")
    private String details(Model model,
                           @PathVariable(name = "id") Long id) {
        return "details";
    }

    @GetMapping(value = "/addRequest")
    private String addRequestDoGet(Model model) {
        model.addAttribute("allCourses", coursesRepository.findAll());
        return "addRequest";
    }

    @PostMapping(value = "/addRequest")
    private String addRequestDoPost(@RequestParam(name = "userName") String userName,
                                    @RequestParam(name = "courseName_id") Long courseName_id,
                                    @RequestParam(name = "phone") String phone,
                                    @RequestParam(name = "commentary") String commentary) {
        if (appRequestService.isExistCourse(courseName_id)) {
            Courses courseName = coursesRepository.getReferenceById(courseName_id);

            ApplicationRequest applicationRequest = new ApplicationRequest();
            applicationRequest.setUserName(userName);
            applicationRequest.setCommentary(commentary);
            applicationRequest.setPhone(phone);
            applicationRequest.setCourseName(courseName);

            appRequestService.saveRequest(applicationRequest);
        }

        return "redirect:/";
    }
}
