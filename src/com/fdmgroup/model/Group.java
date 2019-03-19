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

import com.fdmgroup.enums.Category;

//TODO: Check if group can get created in oracle.
/**
 * Group is the model class that holds the information of the groups that users can join. 
 *
 */
@Entity
@Table(name="USER_GROUP")
@NamedQueries({
	@NamedQuery(name="group.findByGroupId", query="SELECT g FROM Group g WHERE g.groupId = :gId"),
	@NamedQuery(name="group.findByGroupName", query="SELECT g FROM Group g WHERE g.groupName = :gName")
})
public class Group {
	/**
	 * The unique identifier for Group class. 
	 */
	@Id
	@SequenceGenerator(name="groupSeq", sequenceName="GROUP_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="groupSeq")
	@Column(name="USER_GROUP_ID")
	private long groupId;
	
	/**
	 * The name the group is called in the application.
	 */
	@Column(name="GROUP_NAME")
	private String groupName;
	
	/**
	 * The category the group is part of.
	 */
	@Column(name="GROUP_CATEGORY")
	private Category groupCategory;
	
	/**
	 * The description of the group.
	 */
	@Column(name="GROUP_DESCRIPTION")
	private String groupDescription;
	
	/**
	 * If the group is active or deactive
	 */
	@Column(name="ACTIVE", columnDefinition="Number(1)")
	private boolean isActive;
	
	/**
	 * List of Users currently in the group.
	 */
	//@OneToMany(mappedBy="group")
	//@Column(name=GROUP_MEMBERS)
	//private List<IRUser> groupMembers;
	
	public Group() {
		super();
	}
	
	public Group(String groupName, Category groupCategory, String groupDescription) {
		super();
		this.groupName = groupName;
		this.groupCategory = groupCategory;
		this.groupDescription = groupDescription;
		this.isActive = true;
		// this.groupMembers = new ArrayList<>();
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Category getGroupCategory() {
		return groupCategory;
	}
	
	public void setGroupCategory(Category groupCategory) {
		this.groupCategory = groupCategory;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", groupCategory=" + groupCategory
				+ ", groupDescription=" + groupDescription + ", isActive=" + isActive + "]";
	}
	
	
	
}
