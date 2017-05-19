package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Meeting;
import by.bsuir.ceres.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by kirilltsivako on 5/18/17.
 */
@Controller
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/meetings")
    public ModelAndView getAllMeetings(@ModelAttribute("meetingsList")ArrayList<Meeting> meetingsList) {
        ModelAndView modelAndView = new ModelAndView("meetingsTemplate");

        ArrayList<Meeting> meetings = (ArrayList<Meeting>) meetingService.getAllMeetings();
        modelAndView.addObject("meetingsList", meetings);

        return modelAndView;
    }
}
