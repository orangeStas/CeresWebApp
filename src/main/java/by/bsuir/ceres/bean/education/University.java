package by.bsuir.ceres.bean.education;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "university")
public class University implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private Set<Faculty> faculties;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "university_faculty",
            joinColumns = @JoinColumn(name = "idUniversity"),
            inverseJoinColumns = @JoinColumn(name = "idFaculty")
        )
    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
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
