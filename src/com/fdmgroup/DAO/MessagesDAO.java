package com.fdmgroup.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Messages;

public class MessagesDAO implements IMessageDAO {

	@Autowired
	private DBConnection connection;
	
	@Override
	public List<Messages> getSentMessagesForUser(long userId) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Messages> query = em.createNamedQuery("messages.findBySenderId", Messages.class);
		query.setParameter("senderId", userId);
		List<Messages> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<Messages> getReceiverMessagesForUser(long userId) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Messages> query = em.createNamedQuery("messages.findByReceiverId", Messages.class);
		query.setParameter("receiverId", userId);
		List<Messages> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<Messages> getAllMessages() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Messages> query = em.createNamedQuery("messages.findAllMessages", Messages.class);
		List<Messages> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public Messages findById(long msgId) {
		EntityManager em = connection.getEntityManager();
		Messages foundMsg = em.find(Messages.class, msgId);
		em.close();
		return foundMsg;
	}

	@Override
	public Messages sendMessage(Messages message) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(message);
		em.getTransaction().commit();
		em.close();
		return message;
	}

}
