package systema.crm.services;

import systema.crm.entities.ApplicationRequest;
import systema.crm.entities.Courses;
import systema.crm.entities.Operators;

import java.util.List;

public interface ApplicationRequestService {
    void addRequest(ApplicationRequest applicationRequest, Long id);

    List<ApplicationRequest> getAllRequests();

    ApplicationRequest getRequestById(Long id);

    void saveRequest(ApplicationRequest applicationRequest);

    void deleteRequest(Long id);

    boolean trueRequest(Long id);

    boolean isExist(Long id);

    List<Courses> getAllCourses();

    Courses addCourses(Courses course);

    Courses saveCourses(Courses course);

    Courses getCourse(Long id);

    void assignOperator(Long[] operatorId, Long requestId);
    void unAssignOperator(Long operatorId, Long requestId);

    List<Operators> getOperatorsByRequest(Long requestId);

}