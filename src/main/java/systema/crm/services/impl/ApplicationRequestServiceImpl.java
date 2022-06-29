package systema.crm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systema.crm.entities.ApplicationRequest;
import systema.crm.entities.Courses;
import systema.crm.repositories.ApplicationRequestRepository;
import systema.crm.repositories.CoursesRepository;
import systema.crm.services.ApplicationRequestService;

import java.util.List;

@Service
public class ApplicationRequestServiceImpl implements ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository appRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public ApplicationRequest addRequest(ApplicationRequest applicationRequest) {
        return appRepository.save(applicationRequest);
    }

    @Override
    public List<ApplicationRequest> getAllRequests() {
        return appRepository.findAll();
    }

    @Override
    public ApplicationRequest getRequestById(Long id) {
        return appRepository.findById(id).orElse(null);
    }

    @Override
    public ApplicationRequest saveRequest(ApplicationRequest applicationRequest) {
        return appRepository.save(applicationRequest);
    }

    @Override
    public void deleteRequest(Long id) {
        appRepository.deleteById(id);
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses addCourses(Courses course) {
        return coursesRepository.save(course);
    }

    @Override
    public Courses saveCourses(Courses course) {
        return coursesRepository.save(course);
    }

    @Override
    public Courses getCourse(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }
}
