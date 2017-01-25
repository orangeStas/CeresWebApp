package by.bsuir.ceres.bean.TO;

import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.bean.education.Speciality;

import java.io.Serializable;

public class RegistrationTO implements Serializable{

    private User user;

    private Student student;

    /*private String email;

    private String password;

    private String passwordConfirm;*/

    public RegistrationTO() {
        user = new User();
        student = new Student();
        student.setSpeciality(new Speciality());
    }


    /*public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

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

    /*public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/
}
