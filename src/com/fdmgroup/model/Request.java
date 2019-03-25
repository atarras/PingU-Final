package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fdmgroup.enums.RequestStatus;
import com.fdmgroup.enums.RequestType;

/**
 *
 * Request is the model class that holds the information about requests users make that need to be reviewed by Admin
 *
 */
// TODO FIGURE OUT REQUEST THING
@Entity
@Table(name="PINGU_USER_REQUESTS")
@NamedQueries({
	@NamedQuery(name="request.findByRequestId", 
		query="SELECT r "
			+ "FROM Request r "
			+ "JOIN fetch r.requestUser "
			+ "WHERE r.requestId = :rId"),
	@NamedQuery(name="request.findAllPendingRequests", 
		query="SELECT r "
			+ "FROM Request r "
			+ "JOIN fetch r.requestUser "
			+ "WHERE r.requestStatus = com.fdmgroup.enums.RequestStatus.PENDING"),
	@NamedQuery(name="request.findAllRequests", 
		query="SELECT r "
			+ "FROM Request r "
			+ "JOIN fetch r.requestUser"),
	@NamedQuery(name="request.findAllApprovedRequests", 
		query="SELECT r "
			+ "FROM Request r "
			+ "JOIN fetch r.requestUser "
			+ "WHERE r.requestStatus = com.fdmgroup.enums.RequestStatus.APPROVE"),
	@NamedQuery(name="request.findAllDeniedRequests", 
		query="SELECT r "
			+ "FROM Request r "
			+ "JOIN fetch r.requestUser "
			+ "WHERE r.requestStatus = com.fdmgroup.enums.RequestStatus.DENY")
})

public class Request {
	
	/**
	 * The unique identifier for Request class.
	 */
	@Id
	@SequenceGenerator(name="requestSeq", sequenceName="REQUEST_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="requestSeq")
	@Column(name="REQUEST_ID")
	private long requestId;
		
	/**
	 * The id of the user that created the request.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REQUEST_USER")
	private IRUser requestUser;
	
	/**
	 * The id of the group that the user may request access to.
	 */
	@Column(name="REQUEST_GROUP_ID")
	private long groupId;
	
	/**
	 * The type of request
	 */
	@Column(name="REQUEST_TYPE")
	private RequestType requestType;
	
	/**
	 * Comment about the request.
	 * Holds information tha we would like to update
	 * Reason request was approved or denied.
	 */
	@Column(name="REQUEST_COMMENT")
	private String comment;
	
	/**
	 * Status of the request. 
	 * If request was approved, denied, or pending.
	 */
	@Column(name="REQUEST_STATUS")
	private RequestStatus requestStatus;

	public Request() {
		super();
	}
	
	/**
	 *  Constructor used for all RequestType except for JOIN_GROUP
	 * @param user
	 * @param requestType
	 * @param comment
	 */
	public Request(IRUser user, RequestType requestType, String comment) {
		super();
		this.requestUser = user;
		this.requestType = requestType;
		this.comment = comment;
		this.requestStatus = RequestStatus.PENDING;
	}

	/**
	 * Constructor used for RequestType JOIN_GROUP
	 * @param user
	 * @param groupId
	 * @param requestType
	 * @param comment
	 */

	public Request(IRUser user, long groupId, RequestType requestType, String comment) {
		super();
		this.requestUser = user;
		this.groupId = groupId;
		this.requestType = requestType;
		this.comment = comment;
		this.requestStatus = RequestStatus.PENDING;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public IRUser getRequestUser() {
		return requestUser;
	}

	public void setRequestUser(IRUser requestUser) {
		this.requestUser = requestUser;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestUserType(){
		if(requestUser instanceof Trainee){
			return "Trainee";
		} else {
			return "Consultant";
		}
	}
	
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestUser=" + requestUser + ", groupId=" + groupId
				+ ", requestType=" + requestType + ", comment=" + comment + ", requestStatus=" + requestStatus + "]";
	}	
}
