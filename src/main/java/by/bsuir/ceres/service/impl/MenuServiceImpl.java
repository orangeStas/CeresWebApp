package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.dao.MenuRepository;
import by.bsuir.ceres.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenu() {

        return (List<Menu>) menuRepository.findAll();
    }

    @Override
    public Menu getMenuById(Long id) {

        return menuRepository.findOne(id);
    }

    @Override
    public void createMenu(Menu menu) {

        menuRepository.save(menu);
    }

    @Override
    public void updateMenuById(Menu menu) {

        menuRepository.save(menu);
    }

    @Override
    public void deleteMenuById(Long id) {

        menuRepository.delete(id);
    }
}
