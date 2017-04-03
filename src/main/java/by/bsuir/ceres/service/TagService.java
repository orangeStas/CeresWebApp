package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();

    Tag getById(Long id);
}
