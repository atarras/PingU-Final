package com.fdmgroup.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.model.IUser;

public class UserDAO implements IUserDAO {

	private DBConnection connection = null;

	public UserDAO() {
		super();
		this.connection = DBConnection.getInstance();
	}

	@Override
	public IUser create(IUser user) {
		EntityManager em = connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public void delete(IUser user) {
		EntityManager em = connection.getEntityManager();
		IUser foundUser = em.find(IUser.class, user.getUserId());
		em.getTransaction().begin();
		foundUser.setStatus(false);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<IUser> getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IUser> getAllConsultants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IUser> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
