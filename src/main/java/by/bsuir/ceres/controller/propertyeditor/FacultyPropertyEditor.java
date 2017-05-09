package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anton Shulha on 07.05.2017.
 */
public class FacultyPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private FacultyService facultyService;

    public FacultyPropertyEditor(Object source) {
        facultyService = (FacultyService) source;
    }

    @Override
    public String getAsText() {
        String result = null;
        if(getValue() != null) {
            result = Long.toString(((Faculty) getValue()).getId());
        }
        return  result;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Faculty faculty = facultyService.getFacultyById(Long.valueOf(text));
        setValue(faculty);
    }
}
