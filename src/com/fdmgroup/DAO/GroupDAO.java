package com.fdmgroup.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Group;


/**
 * 
 * GroupDAO class used to access and modify the table for Group.
 */
public class GroupDAO {
	
	/**
	 * Single instance of the DBConnection class
	 */
	private DBConnection conn;

	public GroupDAO() {
		super();
		conn = DBConnection.getInstance();
	}
	
	/**
	 * 
	 * Create is called when user wants to persist an entity of type group in the database.
	 * 
	 * @param g: Group that wants to be saved in database
	 * @return Group that was saved.
	 */
	public Group create(Group g){
		EntityManager em = conn.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
		return g;
	}
	
	/**
	 * 
	 * findByGroupId uses the named query to find the group with the given group id.
	 * 
	 * @param id: Id of the group you would like to find.
	 * @return Group with the corresponding id.
	 */
	public Group findByGroupId(long id){
		EntityManager em = conn.getEntityManager();
		TypedQuery<Group> query = em.createNamedQuery("group.findByGroupId", Group.class);
		query.setParameter("gId", id);
		
		List<Group> groups = query.getResultList();
		if(groups != null && !groups.isEmpty()){
			return groups.get(0);
		} else {
			return null;
		}
	}
	/**
	 * 
	 * findByGroupName uses the named query to find the group with the given group name.
	 * 
	 * @param name: Name of the group you would like to find.
	 * @return Group with the corresponding name.
	 */
	public Group findByGroupName(String name){
		EntityManager em = conn.getEntityManager();
		TypedQuery<Group> query = em.createNamedQuery("group.findByGroupName", Group.class);
		query.setParameter("gName", name);
		
		List<Group> groups = query.getResultList();
		if(groups != null && !groups.isEmpty()){
			return groups.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * update finds the group you want to update in the database and updates the group to the fields in given group.
	 * 
	 * @param group: The group with updates to it.
	 */
	public void update(Group group){
		EntityManager em = conn.getEntityManager();
		Group foundGroup = em.find(Group.class, group.getGroupId());
		
		em.getTransaction().begin();
		foundGroup.setActive(group.isActive());
		foundGroup.setGroupCategory(group.getGroupCategory());
		foundGroup.setGroupDescription(group.getGroupDescription());
		foundGroup.setGroupName(group.getGroupName());
		em.getTransaction().commit();
		
		em.close();
	}
	
	
	
	
	
}
