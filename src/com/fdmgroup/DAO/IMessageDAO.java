package com.fdmgroup.DAO;

import java.util.List;

import com.fdmgroup.model.Messages;

public interface IMessageDAO {

	List<Messages> getSentMessagesForUser(long userId);
	List<Messages> getReceiverMessagesForUser(long userId);
	List<Messages> getAllMessages();
	Messages findById(long msgId);
	Messages sendMessage(Messages message);
	List<Messages> getAllMessagesForUser(Long userId);
	List<Messages> getAllMessagesForGroup(Long groupId);
	
}
