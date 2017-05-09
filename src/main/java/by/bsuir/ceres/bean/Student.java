package by.bsuir.ceres.bean;

import by.bsuir.ceres.bean.education.Speciality;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "imageName")
    private String imageName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @OrderBy("id DESC")
    private Set<CourseWork> courseWorks;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    @ManyToOne
    @JoinColumn(name = "idSpeciality")
    private Speciality speciality;


    public Set<CourseWork> getCourseWorks() {
        return courseWorks;
    }

    public void setCourseWorks(Set<CourseWork> courseWorks) {
        this.courseWorks = courseWorks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(user, student.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
