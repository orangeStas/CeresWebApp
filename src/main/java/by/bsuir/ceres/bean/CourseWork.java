package by.bsuir.ceres.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by wowru on 11/20/2016.
 */

@Entity
@Table(name = "course_works")
public class CourseWork implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "topic")
    private String topick;

    @Column(name = "statement")
    private String statement;

    @Column(name = "source")
    private String source;

    @Column(name = "created_at")
    private Timestamp creationDate;

    @Column(name = "updated_at")
    private Timestamp modificationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopick() {
        return topick;
    }

    public void setTopick(String topick) {
        this.topick = topick;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }
}
