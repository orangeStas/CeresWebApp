package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Participant;
import by.bsuir.ceres.dao.ParticipantRepository;
import by.bsuir.ceres.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAllParticipants() {

        return (List<Participant>) participantRepository.findAll();
    }

    @Override
    public Participant getParticipantsById(Long id) {

        return participantRepository.findOne(id);
    }

    @Override
    public void createParticipant(Participant participant) {

        participantRepository.save(participant);
    }

    @Override
    public void updateParticipantById(Participant participant) {

        participantRepository.save(participant);
    }

    @Override
    public void deleteParticipantById(Long id) {

        participantRepository.delete(id);
    }
}
