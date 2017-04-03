package by.bsuir.ceres.controller.propertyeditor;

import by.bsuir.ceres.bean.Tag;
import by.bsuir.ceres.service.TagService;

import java.beans.PropertyEditorSupport;

public class TagPropertyEditor extends PropertyEditorSupport {
    private TagService tagService;

    public TagPropertyEditor(Object source) {
        tagService = (TagService) source;
    }

    @Override
    public String getAsText() {
        return Long.toString(((Tag)getValue()).getId());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Tag tag = tagService.getById(Long.valueOf(text));
        setValue(tag);
    }
}
