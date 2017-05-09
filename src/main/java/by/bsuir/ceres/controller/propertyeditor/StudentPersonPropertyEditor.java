package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anton Shulha on 04.05.2017.
 */
public class StudentPersonPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private StudentService studentService;

    public StudentPersonPropertyEditor(Object source) {
        studentService = (StudentService) source;
    }

    @Override
    public String getAsText() {
        String result = null;
        if(getValue() != null) {
            result = Long.toString(((Student) getValue()).getId());
        }
        return  result;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Student student = studentService.getStudentById(Long.valueOf(text));
        setValue(student);
    }
}
