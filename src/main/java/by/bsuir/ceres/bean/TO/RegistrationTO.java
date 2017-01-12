package by.bsuir.ceres.bean.TO;

import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.User;

import java.io.Serializable;

/**
 * Created by wowru on 1/12/2017.
 */
public class RegistrationTO implements Serializable{

    private User user;
    private Student student;

    public RegistrationTO() {
        user = new User();
        student = new Student();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
