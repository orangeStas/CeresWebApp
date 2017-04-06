package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.Tag;
import by.bsuir.ceres.service.TagService;
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

    @InitBinder
    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.registerCustomEditor(Tag.class, new TagPropertyEditor(tagService));
    }
}
