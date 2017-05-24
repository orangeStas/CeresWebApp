package by.bsuir.ceres.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kirilltsivako on 5/18/17.
 */
@Entity
@Table(name = "meetings")
public class Meeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "place")
    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Student author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "meeting_student", joinColumns = {
            @JoinColumn(name = "meeting_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "student_id")
    })
    private Set<Student> participants = new HashSet<>();

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Student getAuthor() {
        return author;
    }

    public void setAuthor(Student author) {
        this.author = author;
    }

    public Set<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Student> participants) {
        this.participants = participants;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
