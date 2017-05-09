package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Anton Shulha on 09.05.2017.
 */
public class UserPropertyEditor extends PropertyEditorSupport {
    private UserService userService;

    public UserPropertyEditor(Object source) {
        userService = (UserService) source;
    }

    @Override
    public String getAsText() {  String result = null;
        if(getValue() != null) {
            result = Long.toString(((User) getValue()).getId());
        }
        return  result;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = userService.getUserById(Long.valueOf(text));
        setValue(user);
    }
}
