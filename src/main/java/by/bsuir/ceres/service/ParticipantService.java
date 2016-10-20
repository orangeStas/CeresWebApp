package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> getAllParticipants();
    Participant getParticipantsById(Long id);
    void createParticipant(Participant participant);
    void updateParticipantById(Participant participant);
    void deleteParticipantById(Long id);
}
