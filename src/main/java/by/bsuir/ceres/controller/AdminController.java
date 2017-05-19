package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.*;
import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.bean.education.Speciality;
import by.bsuir.ceres.bean.education.University;
import by.bsuir.ceres.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * Created by Anton Shulha on 01.05.2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final String PATH = "files/";
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
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/home")
    public ModelAndView home() {
        return new ModelAndView("adminHomeTemplate");
    }

    @RequestMapping(value = "/users/all")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        modelAndView.setViewName("adminUsersTemplate");
        List<Student> userList = studentService.getAllStudents();
        modelAndView.addObject("studentList", userList);
        return modelAndView;
    }


    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("student") Student student) {
        if (student != null) {
            if (student.getId() == null) {
                studentService.createStudent(student);
            } else {
                studentService.updateStudentById(student);
            }
        }
        return "redirect:/admin/users/all";
    }

    @RequestMapping(value = "/users/new")
    public ModelAndView newUser(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditUsersTemplate");
        List<User> userList = userService.getAllUsers();
        List<Speciality> specialityList = specialityService.getAllSpecialities();
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("specialtyList", specialityList);
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @RequestMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/admin/users/all";
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable(value = "id") Long id) {
        Student student = studentService.getStudentById(id);
        ModelAndView model = new ModelAndView("adminEditUsersTemplate");
        List<User> userList = userService.getAllUsers();
        List<Speciality> specialityList = specialityService.getAllSpecialities();
        model.addObject("userList", userList);
        model.addObject("specialtyList", specialityList);
        model.addObject("student", student);
        return model;
    }

    @RequestMapping(value = "/universities/all")
    public ModelAndView allUniversities(ModelAndView modelAndView) {
        List<University> universityList = universityService.getAllUniversities();
        modelAndView.addObject("universityList", universityList);
        modelAndView.setViewName("adminUniversitiesTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/universities/save", method = RequestMethod.POST)
    public String createUniversity(@ModelAttribute("university") University university) {
        if (university != null) {
            if (university.getId() == null) {
                universityService.createUniversity(university);
            } else {
                universityService.updateUniversityById(university);
            }
        }
        return "redirect:/admin/universities/all";
    }

    @RequestMapping(value = "/universities/new")
    public ModelAndView newUniversity(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditUniversitiesTemplate");
        List<Faculty> facultyList = facultyService.getAllFaculties();
        modelAndView.addObject("facultyList", facultyList);
        modelAndView.addObject("university", new University());
        return modelAndView;
    }

    @RequestMapping(value = "/universities/delete/{id}")
    public String deleteUniversity(@PathVariable(value = "id") Long id) {
        universityService.deleteUniversityById(id);
        return "redirect:/admin/universities/all";
    }

    @RequestMapping(value = "/universities/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUniversity(@PathVariable(value = "id") Long id) {
        University university = universityService.getUniversityById(id);
        List<Faculty> facultyList = facultyService.getAllFaculties();
        ModelAndView model = new ModelAndView("adminEditUniversitiesTemplate");
        model.addObject("university", university);
        model.addObject("facultyList", facultyList);
        return model;
    }

    @RequestMapping(value = "/faculties/all")
    public ModelAndView allFaculties(ModelAndView modelAndView) {
        List<Faculty> facultyList = facultyService.getAllFaculties();
        modelAndView.addObject("facultyList", facultyList);
        modelAndView.setViewName("adminFacultiesTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/specialties/all")
    public ModelAndView allSpecialties(ModelAndView modelAndView) {
        modelAndView.setViewName("adminSpecialtiesTemplate");
        List<Speciality> specialityList = specialityService.getAllSpecialities();
        modelAndView.addObject("specialtyList", specialityList);
        return modelAndView;
    }


    @RequestMapping(value = "/specialties/save", method = RequestMethod.POST)
    public String createSpecialty(@ModelAttribute("specialty") Speciality speciality) {
        if (speciality != null) {
            if (speciality.getId() == null) {
                specialityService.createSpeciality(speciality);
            } else {
                specialityService.updateSpecialityById(speciality);
            }
        }
        return "redirect:/admin/specialties/all";
    }

    @RequestMapping(value = "/specialties/new")
    public ModelAndView newSpecialty(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditSpecialtiesTemplate");
        List<Faculty> facultyList = facultyService.getAllFaculties();
        modelAndView.addObject("facultyList", facultyList);
        modelAndView.addObject("specialty", new Speciality());
        return modelAndView;
    }

    @RequestMapping(value = "/specialties/delete/{id}")
    public String deleteSpecialty(@PathVariable(value = "id") Long id) {
        specialityService.deleteSpecialityById(id);
        return "redirect:/admin/specialties/all";
    }

    @RequestMapping(value = "/specialties/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSpecialty(@PathVariable(value = "id") Long id) {
        Speciality speciality = specialityService.getSpecialityById(id);
        List<Faculty> facultyList = facultyService.getAllFaculties();
        ModelAndView model = new ModelAndView("adminEditSpecialtiesTemplate");
        model.addObject("specialty", speciality);
        model.addObject("facultyList", facultyList);
        return model;
    }


    @RequestMapping(value = "/faculties/save", method = RequestMethod.POST)
    public String createFaculty(@ModelAttribute("faculty") Faculty faculty) {
        if (faculty != null) {
            if (faculty.getId() == null) {
                facultyService.createFaculty(faculty);
            } else {
                facultyService.updateFacultyById(faculty);
            }
        }
        return "redirect:/admin/faculties/all";
    }

    @RequestMapping(value = "/faculties/new")
    public ModelAndView newFaculty(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditFacultiesTemplate");
        List<University> universityList = universityService.getAllUniversities();
        modelAndView.addObject("universityList", universityList);
        modelAndView.addObject("faculty", new Faculty());
        return modelAndView;
    }

    @RequestMapping(value = "/faculties/delete/{id}")
    public String deleteFaculty(@PathVariable(value = "id") Long id) {
        facultyService.deleteFacultyById(id);
        return "redirect:/admin/faculties/all";
    }

    @RequestMapping(value = "/faculties/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editFaculty(@PathVariable(value = "id") Long id) {
        Faculty faculty = facultyService.getFacultyById(id);
        List<University> universityList = universityService.getAllUniversities();
        ModelAndView model = new ModelAndView("adminEditFacultiesTemplate");
        model.addObject("faculty", faculty);
        model.addObject("universityList", universityList);
        return model;
    }

    @RequestMapping(value = "/events/all")
    public ModelAndView allEvents() {
        return new ModelAndView("adminEventsTemplate");
    }

    @RequestMapping(value = "/news/all")
    public ModelAndView allNews() {
        return new ModelAndView("adminNewsTemplate");
    }

    @RequestMapping(value = "/menus/all")
    public ModelAndView allMenus(ModelAndView modelAndView) {
        modelAndView.setViewName("adminMenusTemplate");
        List<Menu> menuList = menuService.getAllMenu();
        modelAndView.addObject("menuList", menuList);
        return modelAndView;
    }

    @RequestMapping(value = "/menus/save", method = RequestMethod.POST)
    public String createMenu(@ModelAttribute("menuItem") Menu menu) {
        if (menu != null) {
            if (menu.getId() == null) {
                menuService.createMenu(menu);
            } else {
                menuService.updateMenuById(menu);
            }
        }
        return "redirect:/admin/menus/all";
    }

    @RequestMapping(value = "/menus/new")
    public ModelAndView newMenu(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditMenuTemplate");
        modelAndView.addObject("menuItem", new Menu());
        return modelAndView;
    }

    @RequestMapping(value = "/menus/delete/{id}")
    public String deleteMenu(@PathVariable(value = "id") Long id) {
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
    public ModelAndView allPartners(ModelAndView modelAndView) {
        List<Participant> participantList = participantService.getAllParticipants();
        modelAndView.addObject("partnerList", participantList);
        modelAndView.setViewName("adminPartnersTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/partners/save", method = RequestMethod.POST)
    public String createPartner(@ModelAttribute("partner") Participant participant, @RequestParam(name = "imageName") String imageName, @RequestParam("sourceFile") MultipartFile multipartFile) {
        if (!multipartFile.getOriginalFilename().isEmpty()) {
            String imageFileName = UUID.randomUUID() + ".jpg";
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(PATH + imageFileName);
                if (!Files.exists(Paths.get(PATH))) {
                    Files.createDirectory(Paths.get(PATH));
                }
                Files.write(path, bytes);
                participant.setImageFileName(imageFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            participant.setImageFileName(imageName);
        }
        if (participant != null) {

            if (participant.getId() == null) {
                participantService.createParticipant(participant);
            } else {
                participantService.updateParticipantById(participant);
            }
        }
        return "redirect:/admin/partners/all";
    }

    @RequestMapping(value = "/partners/new")
    public ModelAndView newPartner(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditPartnersTemplate");
        modelAndView.addObject("partner", new Participant());
        List<ContactPerson> personList = contactPersonService.getAllContactPersons();
        modelAndView.addObject("personList", personList);
        return modelAndView;
    }

    @RequestMapping(value = "/partners/delete/{id}")
    public String deletePartner(@PathVariable(value = "id") Long id) {
        participantService.deleteParticipantById(id);
        return "redirect:/admin/partners/all";
    }

    @RequestMapping(value = "/partners/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPartner(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        Participant participant = participantService.getParticipantsById(id);
        ModelAndView modelAndView = new ModelAndView("adminEditPartnersTemplate");
        modelAndView.addObject("partner", participant);
        request.setAttribute("imageName", participant.getImageFileName());
        List<ContactPerson> personList = contactPersonService.getAllContactPersons();
        modelAndView.addObject("personList", personList);
        return modelAndView;
    }

    @RequestMapping(value = "/projects/all")
    public ModelAndView allProjects(ModelAndView modelAndView) {
        List<Project> projectList = projectService.getAll();
        modelAndView.addObject("projectList", projectList);
        modelAndView.setViewName("adminProjectsTemplate");
        return modelAndView;
    }


    @RequestMapping(value = "/projects/save", method = RequestMethod.POST)
    public String createProject(@ModelAttribute("project") Project project) {
        if (project != null) {
            if (project.getId() == null) {
                projectService.createProject(project);
            } else {
                projectService.updateProject(project);
            }
        }
        return "redirect:/admin/projects/all";
    }

    @RequestMapping(value = "/projects/new")
    public ModelAndView newProject(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditProjectsTemplate");
        List<Tag> tagList = tagService.getAll();
        List<Student> studentList = studentService.getAllStudents();
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("tagList", tagList);
        modelAndView.addObject("project", new Project());
        return modelAndView;
    }

    @RequestMapping(value = "/projects/delete/{id}")
    public String deleteProject(@PathVariable(value = "id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/admin/projects/all";
    }

    @RequestMapping(value = "/projects/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editProject(@PathVariable(value = "id") Long id) {
        ModelAndView model = new ModelAndView("adminEditProjectsTemplate");
        Project project = projectService.getById(id);
        List<Tag> tagList = tagService.getAll();
        List<Student> studentList = studentService.getAllStudents();
        model.addObject("studentList", studentList);
        model.addObject("tagList", tagList);
        model.addObject("project", project);

        return model;
    }

    @RequestMapping(value = "/contactpersons/all")
    public ModelAndView allContactPersons(ModelAndView modelAndView) {
        List<ContactPerson> personList = contactPersonService.getAllContactPersons();
        modelAndView.addObject("personList", personList);
        modelAndView.setViewName("adminContactPersonsTemplate");
        return modelAndView;

    }

    @RequestMapping(value = "/contactpersons/save", method = RequestMethod.POST)
    public String createContactPerson(@ModelAttribute("person") ContactPerson person,@RequestParam(name = "imageName") String imageName, @RequestParam("sourceFile") MultipartFile multipartFile) {
        if (!multipartFile.getOriginalFilename().isEmpty()) {
            String imageFileName = UUID.randomUUID() + ".jpg";
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(PATH + imageFileName);
                if (!Files.exists(Paths.get(PATH))) {
                    Files.createDirectory(Paths.get(PATH));
                }
                Files.write(path, bytes);
                person.setImageFileName(imageFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            person.setImageFileName(imageName);
        }
        if (person != null) {
            if (person.getId() == null) {
                contactPersonService.createContactPerson(person);
            } else {
                contactPersonService.updateContactPersonById(person);
            }
        }
        return "redirect:/admin/contactpersons/all";
    }

    @RequestMapping(value = "/contactpersons/new")
    public ModelAndView newContactPerson(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditContactPersonsTemplate");
        modelAndView.addObject("person", new ContactPerson());
        return modelAndView;
    }

    @RequestMapping(value = "/contactpersons/delete/{id}")
    public String deleteContactPerson(@PathVariable(value = "id") Long id) {
        contactPersonService.deleteContactPersonById(id);
        return "redirect:/admin/contactpersons/all";
    }

    @RequestMapping(value = "/contactpersons/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editContactPerson(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        ContactPerson contactPerson = contactPersonService.getContactPersonById(id);
        request.setAttribute("imageName", contactPerson.getImageFileName());
        ModelAndView model = new ModelAndView("adminEditContactPersonsTemplate");
        model.addObject("person", contactPerson);
        return model;
    }


    @RequestMapping(value = "/tags/all")
    public ModelAndView allTags(ModelAndView modelAndView) {
        List<Tag> tagList = tagService.getAll();
        modelAndView.setViewName("adminTagsTemplate");
        modelAndView.addObject("tagList", tagList);
        return modelAndView;
    }

    @RequestMapping(value = "/tags/save", method = RequestMethod.POST)
    public String createMenu(@ModelAttribute("tag") Tag tag) {
        if (tag != null) {
            if (tag.getId() == null) {
                tagService.createTag(tag);
            } else {
                tagService.updateTag(tag);
            }
        }
        return "redirect:/admin/tags/all";
    }

    @RequestMapping(value = "/tags/new")
    public ModelAndView newTag(ModelAndView modelAndView) {
        modelAndView.setViewName("adminEditTagTemplate");
        modelAndView.addObject("tag", new Tag());
        return modelAndView;
    }

    @RequestMapping(value = "/tags/delete/{id}")
    public String deleteTag(@PathVariable(value = "id") Long id) {
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
