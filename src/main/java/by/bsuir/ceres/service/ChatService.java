package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> getAllChats();
    Chat getChatById(Long id);
    void createChat(Chat chat);
    void updateChat(Chat chat);
    void deleteChatById(Long id);


}
