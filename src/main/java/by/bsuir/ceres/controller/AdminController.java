package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Anton Shulha on 01.05.2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectStatusService projectStatusService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public ModelAndView home() {
        return new ModelAndView("adminHomeTemplate");
    }

    @RequestMapping(value = "/users/all")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("adminUsersTemplate");
        List<User>  userList = userService.getAllUsers();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping(value = "/universities/all")
    public ModelAndView allUniversities(){
        return new ModelAndView("adminUniversitiesTemplate");
    }

    @RequestMapping(value = "/faculties/all")
    public ModelAndView allFaculties(){
        return new ModelAndView("adminFacultiesTemplate");
    }

    @RequestMapping(value = "/specialties/all")
    public ModelAndView allSpecialties(){
        return new ModelAndView("adminSpecialtiesTemplate");
    }


    @RequestMapping(value = "/events/all")
    public ModelAndView allEvents(){
        return new ModelAndView("adminEventsTemplate");
    }

    @RequestMapping(value = "/news/all")
    public ModelAndView allNews(){
        return new ModelAndView("adminNewsTemplate");
    }

    @RequestMapping(value = "/menus/all")
    public ModelAndView allMenus(ModelAndView modelAndView ){
        modelAndView.setViewName("adminMenusTemplate");
        List<Menu> menuList = menuService.getAllMenu();
        modelAndView.addObject("menuList", menuList);
        return modelAndView;
    }

    @RequestMapping(value = "/menus/save", method = RequestMethod.POST)
    public String  createMenu (@ModelAttribute("menuItem") Menu menu) {
        if(menu != null){
            if(menu.getId() == null){
                menuService.createMenu(menu);
            }else {
                menuService.updateMenuById(menu);
            }
        }
        return "redirect:/admin/menus/all";
    }

    @RequestMapping(value = "/menus/new")
    public ModelAndView newMenu(ModelAndView modelAndView){
        modelAndView.setViewName("adminEditMenuTemplate");
        modelAndView.addObject("menuItem", new Menu());
        return modelAndView;
    }

    @RequestMapping(value = "/menus/delete/{id}")
    public String deleteMenu(@PathVariable(value = "id") Long id){
        menuService.deleteMenuById(id);
        return "redirect:/admin/menus/all";
    }

    @RequestMapping(value = "/menus/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editMenu(@PathVariable(value = "id") Long id) {
        Menu menu = menuService.getMenuById(id);
        ModelAndView model = new ModelAndView("adminEditMenuTemplate");
        model.addObject("menuItem", menu);
        return model;
    }

    @RequestMapping(value = "/partners/all")
    public ModelAndView allPartners(){
        return new ModelAndView("adminPartnersTemplate");
    }

    @RequestMapping(value = "/contactpersons/all")
    public ModelAndView allContactPersons(){
        return new ModelAndView("adminContactPersonsTemplate");
    }

    @RequestMapping(value = "/projects/all")
    public ModelAndView allProjects(){
        return new ModelAndView("adminProjectsTemplate");
    }

    @RequestMapping(value = "/tags/all")
    public ModelAndView allTags(){
        return new ModelAndView("adminTagsTemplate");
    }


}
