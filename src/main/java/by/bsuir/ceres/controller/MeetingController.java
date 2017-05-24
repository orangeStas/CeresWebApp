package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Meeting;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.service.MeetingService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.userdetails.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kirilltsivako on 5/18/17.
 */
@Controller
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinToMeeting(@RequestParam(name = "meetingId") Long meetingId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
        Student student = user1.getStudent();

        Meeting meeting = meetingService.getMeeting(meetingId);
        meeting.getParticipants().add(student);

        meetingService.createMeeting(meeting);

        return "redirect:/meetings";
    }

    @RequestMapping(value = "/leave", method = RequestMethod.POST)
    public String leaveFromMeeting(@RequestParam(name = "meetingId") Long meetingId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
        Student student = user1.getStudent();

        Meeting meeting = meetingService.getMeeting(meetingId);
        meeting.getParticipants().remove(student);

        meetingService.createMeeting(meeting);

        return "redirect:/meetings";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getAllMeetings() {
        ModelAndView modelAndView = new ModelAndView("meetingsTemplate");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Meeting> meetings = meetingService.getAllMeetings();
        meetings.sort((m1, m2) -> m2.getCreated_at().compareTo(m1.getCreated_at()));

        if (principal != "anonymousUser") {
            User user = (User) principal;
            by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
            List<Boolean> userInMeetingList = meetings.stream().map(meeting -> isUserInMeeting(meeting)).collect(Collectors.toList());
            modelAndView.addObject("userInMeetingList", userInMeetingList);
            modelAndView.addObject("currentUserId", user1.getId());
        }

        modelAndView.addObject("meetingsList", meetings);

        return modelAndView;
    }

    @RequestMapping(value = "/addmeeting", method = RequestMethod.GET)
    public ModelAndView getAddMeetingPage(@ModelAttribute("meeting")Meeting meeting) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != "anonymousUser") {
            ModelAndView modelAndView = new ModelAndView("addMeetingsTemplate");
            meeting = new Meeting();
            modelAndView.addObject("meeting", meeting);
            return modelAndView;
        } else {
            return getAllMeetings();
        }
    }

    @RequestMapping(value = "addMeeting/add", method = RequestMethod.POST)
    public String addMeeting(HttpServletRequest request) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());

        Meeting meeting = new Meeting();

        String title = request.getParameter("title");
        String place = request.getParameter("place");
        String info = request.getParameter("info");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        meeting.setActive(true);
        meeting.setTitle(title);
        meeting.setPlace(place);
        meeting.setContent(info);
        meeting.setAuthor(user1.getStudent());

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy hh:mm");
            Date parseDate = dateFormat.parse(date + " " + time);
            Timestamp timestamp = new Timestamp(parseDate.getTime());
            meeting.setCreated_at(timestamp);
            meeting.setUpdated_at(timestamp);
        } catch (Exception e) {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            meeting.setCreated_at(timestamp);
            meeting.setUpdated_at(timestamp);
        }

        meetingService.createMeeting(meeting);

        return "redirect:..";
    }

    private boolean isUserInMeeting(Meeting meeting) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
        Student student = user1.getStudent();

        for (Student prSt : meeting.getParticipants()) {
            if (prSt.getId().equals(student.getId())) {
                return true;
            }
        }

        return student.getId().equals(meeting.getAuthor().getId());
    }
}
