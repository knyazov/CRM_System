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
    public ApplicationRequest addRequest(ApplicationRequest applicationRequest, Long id) {
        if (coursesRepository.existsById(id)) {
            Courses courseName = getCourse(id);
            applicationRequest.setCourseName(courseName);
            applicationRequest.setHandled(false);
            saveRequest(applicationRequest);
            return appRepository.save(applicationRequest);
        }
        return null;
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
    public void saveRequest(ApplicationRequest applicationRequest) {
        appRepository.save(applicationRequest);
    }

    @Override
    public void deleteRequest(Long id) {
        appRepository.deleteById(id);
    }

    @Override
    public boolean trueRequest(Long id) {
        if (isExist(id)) {
            ApplicationRequest applicationRequest = getRequestById(id);
            applicationRequest.setHandled(true);
            saveRequest(applicationRequest);
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(Long id) {
        return appRepository.existsById(id);
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
