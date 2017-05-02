package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.*;
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
    public ModelAndView allPartners(ModelAndView modelAndView){
        List<Participant> participantList = participantService.getAllParticipants();
        modelAndView.addObject("partnerList", participantList);
        modelAndView.setViewName("adminPartnersTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/partners/save", method = RequestMethod.POST)
    public String  createPartner (@ModelAttribute("partner") Participant participant) {
        if(participant != null){
            if(participant.getId() == null){
                participantService.createParticipant(participant);
            }else {
                participantService.updateParticipantById(participant);
            }
        }
        return "redirect:/admin/partners/all";
    }

    @RequestMapping(value = "/partners/new")
    public ModelAndView newPartner(ModelAndView modelAndView){
        modelAndView.setViewName("adminEditPartnersTemplate");
        modelAndView.addObject("partner", new Participant());
        List<ContactPerson> personList = contactPersonService.getAllContactPersons();
        modelAndView.addObject("personList", personList);
        return modelAndView;
    }

    @RequestMapping(value = "/partners/delete/{id}")
    public String deletePartner(@PathVariable(value = "id") Long id){
        participantService.deleteParticipantById(id);
        return "redirect:/admin/partners/all";
    }

    @RequestMapping(value = "/partners/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPartner(@PathVariable(value = "id") Long id) {
        Participant participant = participantService.getParticipantsById(id);
        ModelAndView modelAndView = new ModelAndView("adminEditPartnersTemplate");
        modelAndView.addObject("partner", participant);
        List<ContactPerson> personList = contactPersonService.getAllContactPersons();
        modelAndView.addObject("personList", personList);
        return modelAndView;
    }
    @RequestMapping(value = "/contactpersons/all")
    public ModelAndView allContactPersons(ModelAndView modelAndView){
        List<ContactPerson> personList = contactPersonService.getAllContactPersons();
        modelAndView.addObject("personList", personList);
        modelAndView.setViewName("adminContactPersonsTemplate");
        return modelAndView;

    }

    @RequestMapping(value = "/contactpersons/save", method = RequestMethod.POST)
    public String  createContactPerson (@ModelAttribute("person") ContactPerson person) {
        if(person != null){
            if(person.getId() == null){
                contactPersonService.createContactPerson(person);
            }else {
                contactPersonService.updateContactPersonById(person);
            }
        }
        return "redirect:/admin/contactpersons/all";
    }

    @RequestMapping(value = "/contactpersons/new")
    public ModelAndView newContactPerson(ModelAndView modelAndView){
        modelAndView.setViewName("adminEditContactPersonsTemplate");
        modelAndView.addObject("person", new ContactPerson());
        return modelAndView;
    }

    @RequestMapping(value = "/contactpersons/delete/{id}")
    public String deleteContactPerson(@PathVariable(value = "id") Long id){
        contactPersonService.deleteContactPersonById(id);
        return "redirect:/admin/contactpersons/all";
    }

    @RequestMapping(value = "/contactpersons/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editContactPerson(@PathVariable(value = "id") Long id) {
        ContactPerson contactPerson = contactPersonService.getContactPersonById(id);
        ModelAndView model = new ModelAndView("adminEditContactPersonsTemplate");
        model.addObject("person", contactPerson);
        return model;
    }

    @RequestMapping(value = "/projects/all")
    public ModelAndView allProjects(){
        return new ModelAndView("adminProjectsTemplate");
    }

    @RequestMapping(value = "/tags/all")
    public ModelAndView allTags(ModelAndView modelAndView){
        List<Tag> tagList = tagService.getAll();
        modelAndView.setViewName("adminTagsTemplate");
        modelAndView.addObject("tagList", tagList);
        return modelAndView;
    }

    @RequestMapping(value = "/tags/save", method = RequestMethod.POST)
    public String  createMenu (@ModelAttribute("tag") Tag tag) {
        if(tag != null){
            if(tag.getId() == null){
                tagService.createTag(tag);
            }else {
                tagService.updateTag(tag);
            }
        }
        return "redirect:/admin/tags/all";
    }

    @RequestMapping(value = "/tags/new")
    public ModelAndView newTag(ModelAndView modelAndView){
        modelAndView.setViewName("adminEditTagTemplate");
        modelAndView.addObject("tag", new Tag());
        return modelAndView;
    }

    @RequestMapping(value = "/tags/delete/{id}")
    public String deleteTag(@PathVariable(value = "id") Long id){
        tagService.deleteTagById(id);
        return "redirect:/admin/tags/all";
    }

    @RequestMapping(value = "/tags/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editTag(@PathVariable(value = "id") Long id) {
        Tag tag = tagService.getById(id);
        ModelAndView model = new ModelAndView("adminEditTagTemplate");
        model.addObject("tag", tag);
        return model;
    }


}
