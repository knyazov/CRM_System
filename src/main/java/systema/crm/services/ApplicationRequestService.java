package systema.crm.services;

import systema.crm.entities.ApplicationRequest;

import java.util.List;

public interface ApplicationRequestService {
    ApplicationRequest addRequest(ApplicationRequest applicationRequest);
    List<ApplicationRequest> getAllRequests();
    ApplicationRequest getRequestById(Long id);
    ApplicationRequest saveRequest(ApplicationRequest applicationRequest);
    void deleteRequest(Long id);

    boolean isExist(Long id);

    boolean isExistCourse(Long id);
}
