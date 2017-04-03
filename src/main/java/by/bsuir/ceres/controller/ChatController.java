package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.*;
import by.bsuir.ceres.dao.ChatMessageRepository;
import by.bsuir.ceres.service.ChatService;
import by.bsuir.ceres.service.ProjectService;
import by.bsuir.ceres.service.StudentService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChat(chatService.getChatById(Long.valueOf(message.getChatId())));
        Student student = studentService.getStudentById(Long.valueOf(message.getStudentId()));

        chatMessage.setStudent(student);
        chatMessage.setMessage(message.getText());
        chatMessage.setTime(new Timestamp(new Date().getTime()));

        chatMessageRepository.save(chatMessage);

        return new OutputMessage(message.getFrom(), message.getText(), time, student.getId());
    }

    @RequestMapping("/openChat/{projectId}")
    public ModelAndView openChat(@PathVariable("projectId") Long projectId,
                                 @ModelAttribute("messages")ArrayList<ChatMessage> messageHashSet) {
        ModelAndView modelAndView = new ModelAndView("chatTemplate");

        Project project = projectService.loadById(projectId);

        if (project != null) {
            List<ChatMessage> list = new ArrayList<>(project.getChat().getChatMessages());
            Collections.sort(list, (m1, m2) -> m1.getId().compareTo(m2.getId()));

            modelAndView.addObject("messages", list);
            modelAndView.addObject("projectName", project.getTitle());
            modelAndView.addObject("chatId", project.getChat().getId());
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
        Student student = user1.getStudent();

        modelAndView.addObject("student", student);

        return modelAndView;
    }
}
