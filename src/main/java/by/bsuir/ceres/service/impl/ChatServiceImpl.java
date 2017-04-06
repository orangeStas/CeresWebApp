package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Chat;
import by.bsuir.ceres.dao.ChatRepository;
import by.bsuir.ceres.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Chat> getAllChats() {
        return null;
    }

    @Override
    public Chat getChatById(Long id) {
        return chatRepository.findOne(id);
    }

    @Override
    public void createChat(Chat chat) {

    }

    @Override
    public void updateChat(Chat chat) {

    }

    @Override
    public void deleteChatById(Long id) {

    }
}
