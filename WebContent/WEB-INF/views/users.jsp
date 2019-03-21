<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Users | PingU</title>
  <!-- Include in every page -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
  <link rel="stylesheet" href="<c:url value="resources/css/main.css" />" />
  <script src="<c:url value="resources/js/main.js" />"></script>
  
  <!-- Users management page specific -->
  <link rel="stylesheet" href="<c:url value="resources/css/users.css" />" />
  <script src="<c:url value="resources/js/users.js" />"></script>
</head>
<body>

  <div id="action-buttons-template" style="display:none">
    <div class="default-actions">
      <button type="button" class="btn btn-primary edit-exam-button">
        <i class="fas fa-edit"></i>
      </button>
      <button type="button" class="btn btn-danger delete-exam-button">
        <i class="fas fa-trash-alt"></i>
      </button>
    </div>
    <div class="edit-actions" style="display: none">
      <button type='button' class='btn btn-success confirm-edit-exam-button'>
        <span class="glyphicon glyphicon-edit"></span>
        Confirm
      </button>
      <button type='button' class='btn btn-info undo-edit-exam-button'>
        <span class="glyphicon glyphicon-share-alt"></span>
        Undo
      </button>
    </div>
  </div>

  <%-- <jsp:include page="nav.jsp" /> --%>

  <div class="flex-wrapper">
    <div id="main-body" class="container">
    <div id="login-signup">
    
      <ul class="nav nav-tabs justify-content-end">
        <li class="pull-right">
          <a data-toggle="tab" class="nav-link active" href="#trainee">Trainees</a>
        </li>
        <li class="pull-right"><a data-toggle="tab" class="nav-link" href="#consultant">Consultants</a></li>
        <li class="pull-right"><a data-toggle="tab" class="nav-link" href="#admin">Admins</a></li>
      </ul>
    
      <div class="tab-content">
      
        <div id="trainee" class="tab-pane fade active show">
        
          <button type="button" id="add-trainee-button" class="btn btn-success">
            <i class="fas fa-plus"></i>
            Add Trainee
          </button>
          <button type="button" id="trainee-options" class="btn btn-secondary" data-toggle="modal" data-target="#trainee-options-modal">
            <i class="fas fa-cog"></i>
          </button>
          
        
          <table id="users" class="table">
            <thead>
              <tr>
                <th class="trainee-id">ID</th>
                <th>Username</th>
                <th class="trainee-firstname">First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>City</th>
                <th>Country</th>
                <th>Stream</th>
                <th>LinkedIn</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.trainees}" var="user">
              <tr id="${user.getUserId()}">
                <td class="trainee-id">${user.getUserId()}</td>
                <td class="trainee-username">${user.getUsername()}</td>
                <td class="trainee-password">${user.getPassword()}</td>
                <td class="trainee-firstname">${user.getFirstName()}</td>
                <td class="trainee-lastname">${user.getLastName()}</td>
                <td class="trainee-email">${user.getEmail()}</td>
                <td class="trainee-phone">${user.getPhoneNumber()}</td>
                <td class="trainee-city">${user.getCity()}</td>
                <td class="trainee-country">${user.getCountry()}</td>
                <td class="trainee-description">${user.getDescription()}</td>
                <td class="trainee-stream">${user.getStream()}</td>
                <td class="trainee-linkedin">${user.getLinkedInUrl()}</td>
                <td class="trainee-security-answer">${user.getSecurityAnswer()}</td>
                <td class="trainee-status">${user.isStatus()}</td>
                <td class="trainee-visibility">${user.isVisibility()}</td>
                <td id="actions-${user.getUserId()}" class="" align="center">
                  <i class="fas fa-ellipsis-v action-button" data-toggle="modal" data-target="#edit-trainee-modal"></i>
                  <!-- <script>
                  $(document).ready(function() {
                	  $("#actions-${user.getUserId()}").append($("#action-buttons-template").html());
                  })
                  </script> -->
                </td>
              </tr>
              </c:forEach>

            </tbody>
          </table>
        </div>
        <div id="consultant" class="panel panel-default tab-pane fade">
          <div class="panel-body">
            <table>
            <thead>
            
            </thead>
            <tbody>
            
            </tbody>
            </table>
          </div>
        </div>
        <div id="admin" class="panel panel-default tab-pane fade">
          <div class="panel-body">
            <table>
            <thead>
            
            </thead>
            <tbody>
            
            </tbody>
            </table>
          </div>
        </div>
      </div>
    
    </div>
    
    <!-- Trainee Options Modal -->
    <div class="modal fade" id="trainee-options-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">Edit Trainee</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div id="edit-trainee-body" class="modal-body">
          
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-id" checked>
              <label class="form-check-label" for="show-trainee-id">
                ID
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-firstname" checked>
              <label class="form-check-label" for="show-trainee-firstname">
                First Name
              </label>
            </div>
            
          </div>
        </div>
      </div>
    </div>
    
    <!-- Edit Trainee Modal -->
    <div class="modal fade" id="edit-trainee-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">Edit Trainee</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div id="edit-trainee-body" class="modal-body">
          
            <form action="user" method="post">
            
              <div class="form-group">
                <div class="row">
                  <div class="col col-md-6">
                    <input type="text" id="edit-firstname-field" class="form-control" name="firstName" />
                  </div>
                  <div class="col col-md-6">
                    <input type="text" id="edit-lastname-field" class="form-control" name="lastName" />
                  </div>
                </div>
              </div>
            
            </form>
            
          </div>
        </div>
      </div>
    </div>
    
    </div>
    <jsp:include page="footer.jsp" />
  </div>

</body>
</html>