package by.bsuir.ceres.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participants")
public class Participant implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "site")
    private String site;

    @Column(name = "phone")
    private String phone;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactPerson contactPerson;

    @Column(name = "image")
    private String imageFileName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
