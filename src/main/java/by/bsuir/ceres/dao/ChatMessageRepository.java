package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
}
