package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.ContactPerson;
import org.springframework.data.repository.CrudRepository;

public interface ContactPersonRepository extends CrudRepository<ContactPerson, Long> {
}
