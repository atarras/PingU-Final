package com.fdmgroup.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fdmgroup.DAO.GroupDAO;
import com.fdmgroup.DAO.RequestDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.enums.Employer;
import com.fdmgroup.enums.RequestStatus;
import com.fdmgroup.enums.RequestType;
import com.fdmgroup.model.Consultant;
import com.fdmgroup.model.Group;
import com.fdmgroup.model.IRUser;
import com.fdmgroup.model.IUser;
import com.fdmgroup.model.Request;

@Controller
public class RequestController {
	/**
	 * Data Access Object to interact with the Group table.
	 */
	@Autowired
	private GroupDAO groupDao;
	/**
	 * Data Access Object to interact with the User table.
	 */
	@Autowired
	private UserDAO userDao;
	/**
	 * Data Access Object to interact with the Request table.
	 */
	@Autowired
	private RequestDAO requestDao;
	
	/**
	 * 
	 * Creates the sign up request to be approved by the admin.
	 * 
	 * @param request
	 * @return the .jsp file to redirect to
	 */
	@RequestMapping(value="/signUpRequest", method=RequestMethod.GET)
	public String createSignUpRequest(HttpServletRequest request, Model model, @ModelAttribute("newUser")IRUser user) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		long userId = (Long) flashMap.get("userId");

		Request signUpRequest = new Request(userId, RequestType.CREATE_USER, "Create the user");
		requestDao.create(signUpRequest);
		return "login";
	}
	
	/**
	 * 
	 * Creates the join group request to be approved by the admin.
	 * Sent to RequestController after button was pressed on group page.
	 * Send through URL parameter.
	 * 
	 * @param userId: long sent from the front end jsp to represent the user.
	 * @param groupId: long sent from the front end jsp to represent the group to join.
	 * @return the .jsp file to redirect to
	 */
	@RequestMapping(value="/joinGroupRequest")
	public String createJoinGroupRequest(@RequestParam(value="userID")long userId, @RequestParam(value="groupID")long groupId){
		Request joinGroupRequest = new Request(userId, groupId, RequestType.JOIN_GROUP, "Join the group");
		requestDao.create(joinGroupRequest);
		return null; // Return to the necessary jsp
	}
	
	/**
	 * 
	 * Creates the change employer request to be approved by the admin.
	 * 
	 * @param userId: long sent from the front end jsp to represent the user.
	 * @param employerName: string send from the front end jsp to represent the employer (the exact enum string)
	 * @return the .jsp file to redirect to
	 */
	@RequestMapping(value="/changeEmployerRequest")
	public String createChangeCompanyRequest(@RequestParam(value="userID")long userId, @RequestParam(value="newEmployer") String employerName){
		Request changeCompanyRequest = new Request(userId, RequestType.CHANGE_EMPLOYER, employerName);
		requestDao.create(changeCompanyRequest);
		return null; // Return to the necessary jsp
	}
//	
//	/**
//	 * 
//	 * Creates the change job title request to be approved by the admin.
//	 * 
//	 * @param request
//	 * @param jobTitle
//	 * @return the .jsp file to redirect to
//	 */
//	@RequestMapping(value="/changeJobTitleRequest")
//	public String createChangeJobTitleRequest(@RequestParam(value="userID")long userId, @RequestParam(value="newJobTitle")String jobTitle){
//		Request changeJobTitleRequest = new Request(userId, RequestType.CHANGE_JOB_TITLE, jobTitle);
//		requestDao.create(changeJobTitleRequest);
//		return null; // Return to the necessary jsp
//	}
//	
//	
//	/**
//	 * 
//	 * If admin approves a request, make the necessary changes to the database to fulfil the request.
//	 * Update the request status to approve and the necessary comment.
//	 * 
//	 * @param requestId
//	 * @param approveComment
//	 * @return
//	 */
//	public String approveRequest(@RequestParam(value="requestID") long requestId, @RequestParam(value="comment") String approveComment){
//		Request currRequest = requestDao.findByRequestId(requestId);
//		boolean failedRequest = false;
//		switch(currRequest.getRequestType()){
//			case CREATE_USER: 
//				userDao.activateUser(currRequest.getUserId());
//				break;
//			case JOIN_GROUP:
//				Group currGroup = groupDao.findByGroupId(currRequest.getGroupId());
//				IUser user = userDao.findUserById(currRequest.getUserId());
//				
//				if(user instanceof Consultant){
//					Consultant currConsultant = (Consultant) user;
//					// If the consultant's employer matches the name of the group, it can join the group.
//					if(currConsultant.getEmployer().equals(currGroup.getGroupName())){
//						failedRequest = false;
//					} else {
//						failedRequest = true;
//					}
//				} else {
//					// If the user is a trainee, they can only join FDM_GROUP
//					if(currGroup.getGroupName().equals(Employer.FDM_GROUP)){
//						failedRequest =  false;
//					} else {
//						failedRequest = true;
//					}
//				}
//				
//				break;
//			case CHANGE_EMPLOYER:
//				Employer newEmployer = Employer.valueOf(Employer.class, currRequest.getComment());
//				//userDao.updateEmployer(currRequest.getUserId(), newEmployer);
//				break;
//			case CHANGE_JOB_TITLE:
//				userDao.updateJobTitle(currRequest.getUserId(), currRequest.getComment());
//				break;
//		}
//		if(!failedRequest){
//			currRequest.setRequestStatus(RequestStatus.APPROVE);
//			currRequest.setComment(approveComment);
//			requestDao.update(currRequest);
//		} 
//		
//		
//		return null; // Return to the necessary jsp
//	}
}