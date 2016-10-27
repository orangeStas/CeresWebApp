package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAllMenu();
    Menu getMenuById(Long id);
    void createMenu(Menu menu);
    void updateMenuById(Menu menu);
    void deleteMenuById(Long id);
    List<Menu> getTopMenu();
    List<Menu> getRightMenu();
}
