package by.bsuir.ceres.bean;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "chat")
public class Chat implements Serializable {

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "project"))
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chat")
    private Set<ChatMessage> chatMessages = new HashSet<>();

    public Set<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(Set<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
