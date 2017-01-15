package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.CourseWork;
import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.bean.statement.CourseWorkStatement;
import by.bsuir.ceres.service.CourseWorkService;
import by.bsuir.ceres.service.DocumentGeneratorService;
import by.bsuir.ceres.service.MenuService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by wowru on 11/20/2016.
 */
@Controller
@RequestMapping("/education")
public class AddCourseWorkController {

    private static final String PATH = "files/";

    @Autowired
    private CourseWorkService courseWorkService;

    @Autowired
    private DocumentGeneratorService documentGeneratorService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/addCourseWork")
    public ModelAndView getAddCourseWorkPage(@ModelAttribute("courseWork")CourseWork courseWork,
                                             @ModelAttribute("topMenu")ArrayList<Menu> topMenu){

        ModelAndView modelAndView = new ModelAndView("addCourseWorkTemplate");

        courseWork = new CourseWork();

        topMenu = (ArrayList<Menu>) menuService.getTopMenu();
        modelAndView.addObject("courseWork", courseWork);
        modelAndView.addObject("topMenu", topMenu);

        return modelAndView;
    }

    @RequestMapping(value = "/addWork", method = RequestMethod.POST)
    public String addWork(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam("sourceFile")MultipartFile multipartFile) {

        String sourcesFileName = UUID.randomUUID() + "." + multipartFile.getOriginalFilename().split("\\.")[1];
        String statementFileName = UUID.randomUUID() + ".pdf";
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(PATH + sourcesFileName);
            if (!Files.exists(Paths.get(PATH))) {
                Files.createDirectory(Paths.get(PATH));
            }
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CourseWorkStatement courseWorkStatement = new CourseWorkStatement();
        CourseWork courseWork = new CourseWork();
        courseWork.setStudentName(request.getParameter("name"));
        courseWork.setTopic(request.getParameter("topic"));
        courseWork.setSource(sourcesFileName);
        courseWork.setStatement(statementFileName);
        String endDate = request.getParameter("dateEnding");
        String inputData = request.getParameter("start");
        String content = request.getParameter("content");
        String assistant = request.getParameter("assistant");
        String gettingDate = request.getParameter("dateGetting");
        String graphic = request.getParameter("graphic");
        String schedule = request.getParameter("schedule");

        courseWorkStatement.setTopic(courseWork.getTopic());
        courseWorkStatement.setAssistant(assistant);
        courseWorkStatement.setContent(content);
        courseWorkStatement.setEndDate(endDate);
        courseWorkStatement.setGettingDate(gettingDate);
        courseWorkStatement.setGraphic(graphic);
        courseWorkStatement.setInputDataForWork(inputData);
        courseWorkStatement.setName(courseWork.getStudentName());
        courseWorkStatement.setSchedule(schedule);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + statementFileName);
        try {
            documentGeneratorService.generateCourseWorkStatement(courseWorkStatement, response.getOutputStream());
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        courseWorkService.createCourseWork(courseWork);

        return "redirect:../index";
    }
}
