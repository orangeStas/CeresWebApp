package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.education.University;
import by.bsuir.ceres.service.UniversityService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anton Shulha on 07.05.2017.
 */
public class UniversityPropertyEditor extends PropertyEditorSupport {
    private UniversityService universityService;

    public UniversityPropertyEditor(Object source) {
        universityService = (UniversityService) source;
    }

    @Override
    public String getAsText() {  String result = null;
        if(getValue() != null) {
            result = Long.toString(((University) getValue()).getId());
        }
        return  result;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        University university = universityService.getUniversityById(Long.valueOf(text));
        setValue(university);
    }
}
