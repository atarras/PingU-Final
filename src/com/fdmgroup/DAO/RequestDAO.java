package com.fdmgroup.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

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
	@Autowired
	private DBConnection connection;

	
	/**
	 * 
	 * Create is called when user wants to persist an entity of type Request in the database.
	 * 
	 * @param r: Request that wants to be saved in database. 
	 * @return The Request that was saved.
	 */
	public Request create(Request r){
		EntityManager em = connection.getEntityManager();
		
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
		EntityManager em = connection.getEntityManager();
		TypedQuery<Request> query = em.createNamedQuery("request.findByRequestId", Request.class);
		query.setParameter("rId", id);
		
		List<Request> requests = query.getResultList();
		em.close();
		if(requests != null && !requests.isEmpty()){
			return requests.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * findAllPendingRequests uses the named query to find the request with the specified id.
	 * 
	 * @param id: ID of the request you want to find.
	 * @return Request with the corresponding id.
	 */
	public List<Request> findAllPendingRequests(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<Request> query = em.createNamedQuery("request.findAllPendingRequests", Request.class);
		
		List<Request> requests = query.getResultList();
		em.close();
		if(requests != null && !requests.isEmpty()){
			return requests;
		} else {
			return null;
		}
	}
	
	/**
	 * findAllPendingRequests uses the named query to find the request with the specified id.
	 * 
	 * @param id: ID of the request you want to find.
	 * @return Request with the corresponding id.
	 */
	public List<Request> findAllRequests(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<Request> query = em.createNamedQuery("request.findAllRequests", Request.class);
		
		List<Request> requests = query.getResultList();
		em.close();
		if(requests != null && !requests.isEmpty()){
			return requests;
		} else {
			return null;
		}
	}
	
	/**
	 * findAllPendingRequests uses the named query to find the request with the specified id.
	 * 
	 * @param id: ID of the request you want to find.
	 * @return Request with the corresponding id.
	 */
	public List<Request> findAllApprovedRequests(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<Request> query = em.createNamedQuery("request.findAllApprovedRequests", Request.class);
		
		List<Request> requests = query.getResultList();
		em.close();
		if(requests != null && !requests.isEmpty()){
			return requests;
		} else {
			return null;
		}
	}
	
	/**
	 * findAllPendingRequests uses the named query to find the request with the specified id.
	 * 
	 * @param id: ID of the request you want to find.
	 * @return Request with the corresponding id.
	 */
	public List<Request> findAllDeniedRequests(){
		EntityManager em = connection.getEntityManager();
		TypedQuery<Request> query = em.createNamedQuery("request.findAllDeniedRequests", Request.class);
		
		List<Request> requests = query.getResultList();
		em.close();
		if(requests != null && !requests.isEmpty()){
			return requests;
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
		EntityManager em = connection.getEntityManager();
		Request foundRequest = em.find(Request.class, r.getRequestId());
		
		em.getTransaction().begin();
		foundRequest.setComment(r.getComment());
		foundRequest.setGroupId(r.getGroupId());
		foundRequest.setRequestStatus(r.getRequestStatus());
		foundRequest.setRequestType(r.getRequestType());
		em.getTransaction().commit();
		
		em.close();
	}
	
}
