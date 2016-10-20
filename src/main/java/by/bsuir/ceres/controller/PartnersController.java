package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Participant;
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

    @RequestMapping("/participants/")
    public ModelAndView getAllPartners(@ModelAttribute("participantsList")ArrayList<Participant> participants) {

        ModelAndView modelAndView = new ModelAndView("participantsTemplate");
        participants = (ArrayList<Participant>) participantService.getAllParticipants();

        modelAndView.addObject("participantsList", participants);

        return modelAndView;
    }
}
