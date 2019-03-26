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
<body>

  <%-- <jsp:include page="nav.jsp" /> --%>

  <div class="flex-wrapper">
  
    <div id="main-body" class="container">
    
      <!-- Groups Control Buttons -->
      <button type="button" id="add-group-button" class="btn btn-success" data-toggle="modal" data-target="#add-group-modal">
        <i class="fas fa-plus"></i>
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
          <c:forEach items="${groups}" var="group">
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
                <i class="fas fa-ellipsis-v action-button" data-toggle="modal" data-target="#edit-group-modal"></i>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    
      <!-- Add Group Modal -->
      <div class="modal fade" id="add-group-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Add Group</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <sf:form action="group" method="post" modelAttribute="newGroup">
                <%-- <div class="form-group">
                  <sf:input type="text" id="add-group-name" class="form-control" path="groupName" placeholder="Group Name" required="required" />
                </div> --%>
                <sf:select path="groupName" required="required">
                    <sf:option value="" label="*** Select Option ***" />
                    <sf:options items="${employers}" />
                </sf:select>
                <sf:select path="groupCategory" required="required" >
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
              <h5 class="modal-title" id="exampleModalLongTitle">
              Edit Group
              <span id="edit-group-id"></span>
              </h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <div id="edit-group-body">
              <form id="edit-group" action="user" method="post">
              
                
                <div class="form-group">
                  <input type="text" id="edit-admin-username" class="form-control edittable" name="username" placeholder="Username" />
                </div>
                <div class="form-group">
                  <input type="password" id="edit-admin-password" class="form-control edittable" name="password" placeholder="Password" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-admin-security-answer" class="form-control edittable" name="security-answer" placeholder="Security Answer" />
                </div>
                
                <!-- Place status and visibility toggles here -->
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <label>Status</label>
                      <button type="button" class="btn status-open edittable"><i class="fas fa-lock-open"></i></button>
                      <button type="button" class="btn status-close edittable"><i class="fas fa-lock"></i></button>
                      <input type="text" id="edit-admin-status" class="form-control" name="status" style="display:none" />
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
    <jsp:include page="footer.jsp" />
  </div>
  

</body>
</html>