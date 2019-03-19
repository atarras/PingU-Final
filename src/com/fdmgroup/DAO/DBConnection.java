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
	private static DBConnection conn;
	/**
	 * The EntityManagerFactory that creates EntityManager
	 */
	private EntityManagerFactory emf;
	
	private DBConnection(){
		init();
	}
	
	/**
	 * 
	 * The method used to obtain an instance of the DBConnection.
	 * If it does not exist, creates the only instance of DBConnection.
	 * 
	 * @return DBConnection
	 */
	public static DBConnection getInstance(){
		if(conn == null){
			conn = new DBConnection();
		} 
		return conn;
	}
	
	/**
	 * 
	 * Initialises the Entity Manager Factory when DBConnection is first created.
	 * 
	 */
	private void init(){
		if(emf == null || !emf.isOpen()){
			emf = Persistence.createEntityManagerFactory("PingU");
		}
	}
	
	/**
	 * 
	 * The method used to get an Entity Manager to manage the entities in the database.
	 * 
	 * @return EntityManager
	 */
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	/**
	 * Closes the Entity Manager Factory when application closes.
	 */
	public void close(){
		emf.close();
	}
}
