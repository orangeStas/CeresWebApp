package by.bsuir.ceres.bean.education;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_speciality",
            joinColumns = @JoinColumn(name = "idFaculty"),
            inverseJoinColumns = @JoinColumn(name = "idSpeciality")
    )
    private Set<Speciality> specialities = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "faculties")
    private Set<University> universities = new HashSet<>(0);

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
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

    public Set<University> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<University> universities) {
        this.universities = universities;
    }
}
