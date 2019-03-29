<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Groups | PingU</title>
  <!-- Include in every page -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
  <link rel="stylesheet" href="<c:url value="resources/css/main.css" />" />
  <script src="<c:url value="resources/js/main.js" />"></script>
  
  <!-- Groups management page specific -->
  <link rel="stylesheet" href="<c:url value="resources/css/groups.css" />" />
  <script src="<c:url value="resources/js/groups.js" />"></script>
</head>
<jsp:include page="navAdmin.jsp" />
<body>
	<div class="container main-body">
		<div class="container content">
  <%-- <jsp:include page="nav.jsp" /> --%>

  <div class="flex-wrapper">
  
    <div id="main-body" class="container">
      <div id="group">
        <!-- Groups Control Buttons -->
        <button type="button" id="add-group-button" class="btn btn-success" data-toggle="modal" data-target="#add-group-modal">
          <svg xmlns="http://www.w3.org/2000/svg" width="12" height="16" viewBox="0 0 12 16">
            	<path fill-rule="evenodd" d="M12 9H7v5H5V9H0V7h5V2h2v5h5v2z"/>
            </svg>
          Add Group
        </button>
        <!-- Groups Table -->
        <table class="table table-responsive">
          <thead>
            <tr>
              <th class="group-id">ID</th>
              <th class="group-name">Name</th>
              <th class="group-category">Category</th>
              <th class="group-description">Description</th>
              <th class="group-num-members"># Members</th>
              <th class="group-status">Status</th>
              <th class="group-actions">Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${sessionScope.groups}" var="group">
              <tr id="${group.getGroupId()}">
                <td class="group-id">${group.getGroupId()}</td>
                <td class="group-name">${group.getGroupName()}</td>
                <td class="group-category">${group.getGroupCategory()}</td>
                <td class="group-description">${group.getGroupDescription()}</td>
                <td class="group-num-members">${group.getGroupMembers().size()}</td>
                <td class="group-status">
                  <p style="display:none;">${group.isActive()}</p>
                </td>
                <td class="group-actions">
                  <svg class="action-button" data-toggle="modal" data-target="#edit-group-modal" xmlns="http://www.w3.org/2000/svg" width="6" height="16" viewBox="0 0 3 16">
                    	<path fill-rule="evenodd" d="M0 2.5a1.5 1.5 0 1 0 3 0 1.5 1.5 0 0 0-3 0zm0 5a1.5 1.5 0 1 0 3 0 1.5 1.5 0 0 0-3 0zM1.5 14a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z"/>
                    </svg>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- Add Group Modal -->
      <div class="modal fade" id="add-group-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Add Group</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <sf:form action="group" method="post" modelAttribute="newGroup">
                <sf:select id="add-group-name" path="groupName" required="required">
                    <sf:option value="" label="*** Select Option ***" />
                    <sf:options items="${employers}" />
                </sf:select>
                <sf:select id="add-group-category" path="groupCategory" required="required" >
                    <sf:option value="" label="*** Select Option ***" />
                    <sf:options items="${categories}" />
                </sf:select>
                <div class="form-group">
                  <sf:input type="text" id="add-group-description" class="form-control" path="groupDescription" placeholder="Group Description" />  
                </div>
                <div class="form-group">
                  <button type="submit" id="confirm-create-group" class="btn btn-primary btn-lg btn-block login-btn">Create Group</button>
                </div>
              </sf:form>
              
            </div>
          </div>
        </div>
      </div>
      <!-- /END Add Group Modal -->
    
      <!-- Edit Group Modal -->
      <div class="modal fade edit-modal" id="edit-group-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">
              Edit Group
              <span id="edit-group-id"></span>
              </h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <div id="edit-group-body">
              <form id="edit-group" action="editGroupA" method="post">
              
                <!-- <div class="form-group" style="display:none">
                  <input type="text" id="edit-group-id" class="form-control edittable" name="id" />
                </div> -->
                
                <div class="form-group">
                  <input type="text" id="edit-group-description" class="form-control edittable" name="description" placeholder="Group Description" />
                </div>
                
                <!-- Place status toggle here -->
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <label>Status</label>
                      <button type="button" class="btn status-open edittable">
                      	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 12 16">
	                      	<path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/>
	                      </svg>
                      </button>
                      <button type="button" class="btn status-close edittable">
                      	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 12 16">
                      		<path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/>
                      	</svg>
                      </button>
                      <input type="text" id="edit-group-status" class="form-control" name="status" style="display:none" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <button type="submit" id="confirm-edit-group" class="btn btn-primary">Confirm Edit</button>
                </div>
              
              </form>
              </div>
              
            </div>
          </div>
        </div>
      </div>
      <!-- /END Edit Group Modal -->
    
    </div>
  </div>
  </div>
</div>
</body>
</html>