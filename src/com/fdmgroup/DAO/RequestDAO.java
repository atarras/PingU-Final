package com.fdmgroup.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Request;

//TODO: Finish the methods of RequestDAO
/**
 * 
 * RequestDAO class used to access and modify the table for Request.
 *
 */
public class RequestDAO {
	/**
	 * Single instance of the DBConnection class
	 */
	private DBConnection conn;

	public RequestDAO() {
		super();
		conn = DBConnection.getInstance();
	}
	
	/**
	 * 
	 * Create is called when user wants to persist an entity of type Request in the database.
	 * 
	 * @param r: Request that wants to be saved in database. 
	 * @return The Request that was saved.
	 */
	public Request create(Request r){
		EntityManager em = conn.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
		
		return r;
		
	}
	
	/**
	 * findByRequestId uses the named query to find the request with the specified id.
	 * 
	 * @param id: ID of the request you want to find.
	 * @return Request with the corresponding id.
	 */
	public Request findByRequestId(long id){
		EntityManager em = conn.getEntityManager();
		TypedQuery<Request> query = em.createNamedQuery("request.findByRequestId", Request.class);
		query.setParameter("rId", id);
		
		List<Request> requests = query.getResultList();
		if(requests != null && !requests.isEmpty()){
			return requests.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * Update is called when user wants to update a request comment, type or status.
	 * 
	 * @param r: The Request with updated information
	 */
	
	public void update(Request r){
		EntityManager em = conn.getEntityManager();
		Request foundRequest = em.find(Request.class, r.getRequestId());
		
		em.getTransaction().begin();
		foundRequest.setComment(r.getComment());
		foundRequest.setGroupId(r.getGroupId());
		foundRequest.setUserId(r.getUserId());
		foundRequest.setRequestStatus(r.getRequestStatus());
		foundRequest.setRequestType(r.getRequestType());
		em.getTransaction().commit();
		
		em.close();
	}
	
}
