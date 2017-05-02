package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.ContactPerson;
import by.bsuir.ceres.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anton Shulha on 03.05.2017.
 */
public class ContactPersonPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private ContactPersonService contactPersonService;

    public ContactPersonPropertyEditor(Object source) {
        contactPersonService = (ContactPersonService) source;
    }

    @Override
    public String getAsText() {
        return Long.toString(((ContactPerson)getValue()).getId());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ContactPerson contactPerson = contactPersonService.getContactPersonById(Long.valueOf(text));
        setValue(contactPerson);
    }
}
