package by.bsuir.ceres.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "topic")
    private String topic;

    @Column(name = "statement")
    private String statement;

    @Column(name = "source")
    private String source;

    @Column(name = "created_at")
    private Timestamp creationDate;

    @Column(name = "updated_at")
    private Timestamp modificationDate;

    public CourseWork() {
        creationDate = new Timestamp(new Date().getTime());
        modificationDate = new Timestamp(new Date().getTime());
        setActive(true);
    }

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String surname) {
        this.studentName = surname;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
