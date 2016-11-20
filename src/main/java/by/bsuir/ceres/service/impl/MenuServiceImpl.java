package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.dao.MenuRepository;
import by.bsuir.ceres.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Menu> getTopMenu() {

        List<Menu> menus = (List<Menu>) menuRepository.findAll();
        List<Menu> menus1 = new ArrayList<>();

        menus.forEach(m -> {

            if (m.getPosition().equals("top") && m.isActive()) {

                menus1.add(m);
            }
        });

        return menus1;
    }

    @Override
    public List<Menu> getRightMenu() {

        List<Menu> menus = (List<Menu>) menuRepository.findAll();
        List<Menu> menus1 = new ArrayList<>();

        menus.forEach(m -> {

            if (m.getPosition().equals("right") && m.isActive()) {

                menus1.add(m);
            }
        });

        return menus1;
    }
}
