package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
