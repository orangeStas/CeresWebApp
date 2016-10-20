package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.ContactPerson;

import java.util.List;

public interface ContactPersonService {

    List<ContactPerson> getAllContactPersons();
    ContactPerson getContactPersonById(Long id);
    void createContactPerson(ContactPerson contactPerson);
    void updateContactPersonById(ContactPerson contactPerson);
    void deleteContactPersonById(Long id);
}
