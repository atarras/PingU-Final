package com.fdmgroup.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * DBConnection is a Singleton class that creates one connection for the running of the application
 * 
 */

public class DBConnection {
	/**
	 * The only DBConnection instance
	 */
	private String persistenceName;
	
	/**
	 * The EntityManagerFactory that creates EntityManager
	 */
	private EntityManagerFactory emf;
	
	private DBConnection(){
		init();
	}
	
	
	/**
	 * 
	 * Initialises the Entity Manager Factory when DBConnection is first created.
	 * 
	 */
	private EntityManagerFactory init() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(persistenceName);
		}
		return emf;
	}
	
	/**
	 * 
	 * The method used to get an Entity Manager to manage the entities in the database.
	 * 
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		init();
		return emf.createEntityManager();
	}

	
	public String getPersistenceName() {
		return persistenceName;
	}

	public void setPersistenceName(String persistenceName) {
		this.persistenceName = persistenceName;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	/**
	 * Closes the Entity Manager Factory when application closes.
	 */
	public void close(){
		emf.close();
	}
}
