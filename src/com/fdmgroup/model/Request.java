package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Entity
@Table(name="PINGU_USER_REQUESTS")
@NamedQueries({
	@NamedQuery(name="request.findByRequestId", query="SELECT r FROM Request r WHERE r.requestId = :rId")
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
	@Column(name="REQUEST_USER_ID")
	private long userId;
	
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
	 * @param userId
	 * @param requestType
	 * @param comment
	 */
	public Request(long userId, RequestType requestType, String comment) {
		super();
		this.userId = userId;
		this.requestType = requestType;
		this.comment = comment;
		this.requestStatus = RequestStatus.PENDING;
	}

	/**
	 * Constructor used for RequestType JOIN_GROUP
	 * @param userId
	 * @param groupId
	 * @param requestType
	 * @param comment
	 */

	public Request(long userId, long groupId, RequestType requestType, String comment) {
		super();
		this.userId = userId;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", userId=" + userId + ", groupId=" + groupId + ", requestType="
				+ requestType + ", comment=" + comment + ", requestStatus=" + requestStatus + "]";
	}
	
	
	
}
