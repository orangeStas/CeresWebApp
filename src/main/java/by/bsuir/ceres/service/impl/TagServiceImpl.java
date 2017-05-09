package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Tag;
import by.bsuir.ceres.dao.TagRepository;
import by.bsuir.ceres.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public Tag getById(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteTagById(Long id) {
        tagRepository.delete(id);
    }
}
