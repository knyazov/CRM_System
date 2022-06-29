package systema.crm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systema.crm.entities.ApplicationRequest;
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
        return appRepository.getReferenceById(id);
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
    public boolean isExist(Long id) {
        return appRepository.existsById(id);
    }

    @Override
    public boolean isExistCourse(Long id) {
        return coursesRepository.existsById(id);
    }
}
