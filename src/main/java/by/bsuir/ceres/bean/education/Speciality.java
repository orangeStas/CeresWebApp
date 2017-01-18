package by.bsuir.ceres.bean.education;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "speciality")
public class Speciality implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "specialities")
    private Set<Faculty> facultySet;

    public Set<Faculty> getFacultySet() {
        return facultySet;
    }

    public void setFacultySet(Set<Faculty> facultySet) {
        this.facultySet = facultySet;
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
}
