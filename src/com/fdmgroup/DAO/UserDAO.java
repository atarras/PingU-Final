
package com.fdmgroup.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.Group;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;

public class UserDAO implements IUserDAO {

	@Autowired
	private DBConnection connection;

	
	
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
	public IRUser delete(Long userId) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setStatus(false);
		em.getTransaction().commit();
		em.close();
		return foundUser;
	}

	@Override
	public List<IUser> getAllUsers() {
		EntityManager em = connection.getEntityManager();
		System.out.println("done");
		TypedQuery<IUser> query = em.createNamedQuery("iuser.findAllUser", IUser.class);
		List<IUser> resultList = query.getResultList();
		em.close();
		return resultList;

	}

	@Override
	public List<IUser> getAllRegularUsers() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<IUser> query = em.createNamedQuery("iuser.findAllRegularUsers", IUser.class);
		query.setParameter("traineeType", "trainee");
		query.setParameter("consultantType", "consultant");
		List<IUser> resultList = query.getResultList();
		em.close();
		if (resultList != null && resultList.size() >= 1)
			return resultList;
		return null;
	}

	@Override
	public List<IUser> getUserByType(Class type) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<IUser> query = em.createNamedQuery("iuser.findAllByType", IUser.class);
		query.setParameter("type", type);
		List<IUser> resultList = query.getResultList();
		em.close();
		if (resultList != null && resultList.size() >= 1)
			return resultList;
		return null;
	}

	@Override
	public IUser findUserById(Long userId) {
		EntityManager em = connection.getEntityManager();
		IUser foundUser = em.find(IUser.class, userId);
		em.close();
		if (foundUser != null)
			return foundUser;
		return null;
	}

	@Override
	public IRUser changeVissibility(Long userId, Boolean newVissibility) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setVisibility(newVissibility);
		em.getTransaction().commit();
		em.close();
		return foundUser;
	}

	@Override
	public IRUser updatePhoneNumber(Long userId, String newPhone) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setPhoneNumber(newPhone);
		em.getTransaction().commit();
		em.close();
		return foundUser;

	}

	@Override
	public IUser updatePassword(Long userId, String newPassword) {
		EntityManager em = connection.getEntityManager();
		IUser foundUser = em.find(IUser.class, userId);
		em.getTransaction().begin();
		foundUser.setPassword(newPassword);
		em.getTransaction().commit();
		em.close();
		return foundUser;

	}

	@Override
	public IUser loginUser(String username, String password) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<IUser> query = em.createNamedQuery("iuser.findByUsername", IUser.class);
		query.setParameter("username", username);
		List<IUser> resultList = query.getResultList();
		em.close();
		if (resultList != null && resultList.size() >= 1)
			if (resultList.get(0).isStatus())
				return resultList.get(0);
		return null;

	}

	@Override
	public IRUser updateGroup(Long userId, Group group) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setGroup(group);
		em.getTransaction().commit();
		em.close();
		return foundUser;

	}

	@Override
	public IUser activateUser(Long userId) {
		EntityManager em = connection.getEntityManager();
		IUser foundUser = em.find(IUser.class, userId);
		if (foundUser != null) {
			em.getTransaction().begin();
			foundUser.setStatus(true);
			em.getTransaction().commit();
			em.close();
			return foundUser;
		}
		return null;
	}

	@Override
	public Consultant updateEmployer(Long userId, String newEmployer) {
		EntityManager em = connection.getEntityManager();
		Consultant foundUser = em.find(Consultant.class, userId);
		em.getTransaction().begin();
		foundUser.setEmployer(newEmployer);
		em.getTransaction().commit();
		em.close();
		return foundUser;

	}

	@Override
	public Consultant updateJobTitle(Long userId, String newTitle) {
		EntityManager em = connection.getEntityManager();
		Consultant foundUser = em.find(Consultant.class, userId);
		em.getTransaction().begin();
		foundUser.setCurrentTitle(newTitle);
		em.getTransaction().commit();
		em.close();
		return foundUser;

	}

	@Override
	public Consultant updateDescription(Long userId, String newDesc) {
		EntityManager em = connection.getEntityManager();
		Consultant foundUser = em.find(Consultant.class, userId);
		em.getTransaction().begin();
		foundUser.setDescription(newDesc);
		em.getTransaction().commit();
		em.close();
		return foundUser;

	}

	@Override
	public String recoverPassword(String username, String answer) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<IUser> query = em.createNamedQuery("iuser.findByUsername", IUser.class);
		query.setParameter("username", username);
		List<IUser> resultList = query.getResultList();
		em.close();
		if (resultList != null && resultList.size() >= 1)
			if (resultList.get(0).isStatus() && resultList.get(0).getSecurityAnswer().equals(answer))
				return resultList.get(0).getPassword();
		return null;

	}

	@Override
	public IRUser removeFromGroup(Long userId) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setGroup(null);
		em.getTransaction().commit();
		em.close();
		return foundUser;
		
	}

	@Override
	public IRUser changeCity(Long userId, String newCity) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setCity(newCity);
		em.getTransaction().commit();
		em.close();
		return foundUser;
	}

	@Override
	public IRUser changeCountry(Long userId, String newCountry) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, userId);
		em.getTransaction().begin();
		foundUser.setCountry(newCountry);
		em.getTransaction().commit();
		em.close();
		return foundUser;
	}

	@Override
	public List<IRUser> findUsersByFullName(String fname, String lname)
	{
		EntityManager em = connection.getEntityManager();
		TypedQuery<IRUser> query = em.createNamedQuery("user.findByFullName", IRUser.class);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		
		List<IRUser> users = query.getResultList();
		
		if(users != null)
		{
			System.out.println("Users in DAO " + users.size());
			return users;
			
		}
		System.out.println("No Users in DAO");
		em.close();
		return null;
	}
	
	public List<Consultant> findUsersByFuzzyName(String fname, String lname)
	{
		EntityManager em = connection.getEntityManager();
		TypedQuery<Consultant> query = em.createNamedQuery("consultant.findByFullName", Consultant.class);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		
		List<Consultant> users = query.getResultList();
		
		
		if(users != null)
		{
			System.out.println("Users in DAO " + users.size());
			return users;
			
		}
		System.out.println("No Users in DAO");
		em.close();
		return null;
	}

	@Override
	public IRUser updateToConsultant(Long traineeId, String jobTitle, String employer) {
		EntityManager em = connection.getEntityManager();
		IRUser foundUser = em.find(IRUser.class, traineeId);
		
		if(foundUser==null){
			return null;
		}
		
		Consultant newConsultant = (Consultant)foundUser;
		newConsultant.setCurrentTitle(jobTitle);
		newConsultant.setEmployer(jobTitle);
		newConsultant.setStatus(true);
		IUser createdConsultant = create(newConsultant);
		if(createdConsultant == null)
			return null;
		return (IRUser)createdConsultant;
		
	}

	

}


