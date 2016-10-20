package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.ContactPerson;
import by.bsuir.ceres.dao.ContactPersonRepository;
import by.bsuir.ceres.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactPersonServiceImpl implements ContactPersonService{

    @Autowired
    ContactPersonRepository contactPersonRepository;

    @Override
    public List<ContactPerson> getAllContactPersons() {

        return (List<ContactPerson>) contactPersonRepository.findAll();
    }

    @Override
    public ContactPerson getContactPersonById(Long id) {

        return contactPersonRepository.findOne(id);
    }

    @Override
    public void createContactPerson(ContactPerson contactPerson) {

        contactPersonRepository.save(contactPerson);
    }

    @Override
    public void updateContactPersonById(ContactPerson contactPerson) {

        contactPersonRepository.save(contactPerson);
    }

    @Override
    public void deleteContactPersonById(Long id) {

        contactPersonRepository.delete(id);
    }
}
