package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Meeting;

import java.util.List;

/**
 * Created by kirilltsivako on 5/18/17.
 */
public interface MeetingService {

    List<Meeting> getAllMeetings();
    Meeting getMeeting(Long id);
    void createMeeting(Meeting meeting);
    void updateMeeting(Meeting meeting);
    void deleteMeetingById(Long id);
}
