package com.fdmgroup.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PINGU_MESSAGES")
@NamedQueries({
		@NamedQuery(name = "messages.findBySenderId", query = "select m FROM Messages m where m.senderId = :senderId"),
		@NamedQuery(name = "messages.findByReceiverId", query = "select m FROM Messages m where m.receiverId = :receiverId"),
		@NamedQuery(name = "messages.findAllMessages", query = "select m FROM Messages m"),
		@NamedQuery(name = "messages.findByUserId", query = "select m FROM Messages m where m.receiverId = :userId OR m.senderId = :userId"),
		@NamedQuery(name = "messages.findByGroupId", query = "select m FROM Messages m where m.groupId = :groupId") })
public class Messages {

	@Id
	@Column(name = "msgId")
	@SequenceGenerator(name = "msgSequence", sequenceName = "MSG_ID_SEQ", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msgSequence")
	private long msgId;

	@Column(name = "senderId", nullable = false)
	private long senderId;

	@Column(name = "receiverId")
	private long receiverId;

	@Column(name = "groupId")
	private long groupId;

	@Column(name = "Message")
	private String msgBody;

	@Column(name = "sentTime")
	private Date sentTime;
	
	@Column(name="senderName")
	private String senderName;

	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Messages(long senderId, long receiverId, String msgBody) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.msgBody = msgBody;
	}

	public Messages(long senderId, long receiverId, String msgBody, Date sentTime) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.msgBody = msgBody;
		this.sentTime = sentTime;
	}

	public Messages(long senderId, String msgBody, long groupId) {
		super();
		this.senderId = senderId;
		this.groupId = groupId;
		this.msgBody = msgBody;
	}

	
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Messages [msgId=" + msgId + ", senderId=" + senderId + ", receiverId=" + receiverId + ", groupId="
				+ groupId + ", msgBody=" + msgBody + ", sentTime=" + sentTime + ", senderName=" + senderName + "]";
	}

}
