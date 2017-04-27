package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.ContactPerson;
import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.bean.Participant;
import by.bsuir.ceres.service.ContactPersonService;
import by.bsuir.ceres.service.MenuService;
import by.bsuir.ceres.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class PartnersController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ContactPersonService contactPersonService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/participants")
    public ModelAndView getAllPartners(@ModelAttribute("participantsList")ArrayList<Participant> participants,
                                       @ModelAttribute("contactPersonsList")ArrayList<ContactPerson> contactPersons,
                                       @ModelAttribute("topMenu")ArrayList<Menu> topMenu) {

        ModelAndView modelAndView = new ModelAndView("participantsTemplate");

        participants = (ArrayList<Participant>) participantService.getAllParticipants();
        contactPersons = (ArrayList<ContactPerson>) contactPersonService.getAllContactPersons();
        modelAndView.addObject("participantsList", participants);
        modelAndView.addObject("contactPersonsList", contactPersons);

        return modelAndView;
    }
}
