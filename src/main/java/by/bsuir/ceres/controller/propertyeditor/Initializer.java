package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.ContactPerson;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.Tag;
import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.bean.education.University;
import by.bsuir.ceres.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class Initializer implements WebBindingInitializer {

    @Autowired
    private TagService tagService;
    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private  StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private UniversityService universityService;


    @InitBinder
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(Tag.class, new TagPropertyEditor(tagService));
        webDataBinder.registerCustomEditor(ContactPerson.class, new ContactPersonPropertyEditor(contactPersonService));
        webDataBinder.registerCustomEditor(Student.class, new StudentPersonPropertyEditor(studentService));
        webDataBinder.registerCustomEditor(Faculty.class, new FacultyPropertyEditor(facultyService));
        webDataBinder.registerCustomEditor(University.class, new UniversityPropertyEditor(universityService));
    }
}
