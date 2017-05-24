package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.Meeting;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kirilltsivako on 5/18/17.
 */
public interface MeetingsRepository extends CrudRepository<Meeting, Long> {
}
