package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Meeting;
import by.bsuir.ceres.dao.MeetingsRepository;
import by.bsuir.ceres.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kirilltsivako on 5/18/17.
 */
@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingsRepository meetingsRepository;

    @Override
    public List<Meeting> getAllMeetings() {
        return (List<Meeting>) meetingsRepository.findAll();
    }

    @Override
    public Meeting getMeeting(Long id) {
        return meetingsRepository.findOne(id);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetingsRepository.save(meeting);
    }

    @Override
    public void updateMeeting(Meeting meeting) {
        meetingsRepository.save(meeting);
    }

    @Override
    public void deleteMeetingById(Long id) {
        meetingsRepository.delete(id);
    }
}
