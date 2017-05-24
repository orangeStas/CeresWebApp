package by.bsuir.ceres.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView("errorTemplate");
        String errorCode;
        String messageFirstPart;
        String messageSecondPart;
        if (e.getClass().equals(NullPointerException.class)) {
            errorCode = "404";
            messageFirstPart = "СТРАНИЦА";
            messageSecondPart = "НЕ НАЙДЕНА";
        } else {
            errorCode = "500";
            messageFirstPart = "ОШИБКА";
            messageSecondPart = "СЕРВЕРА";
        }
        modelAndView.addObject("errorCode", errorCode);
        modelAndView.addObject("messageFirstPart", messageFirstPart);
        modelAndView.addObject("messageSecondPart", messageSecondPart);
        return modelAndView;
    }
}
