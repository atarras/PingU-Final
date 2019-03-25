<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
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

  <%-- <jsp:include page="nav.jsp" /> --%>

  <div class="flex-wrapper">
  
    <div id="main-body" class="container">
    
      <ul class="nav nav-tabs justify-content-end">
        <li class="pull-right">
          <a data-toggle="tab" class="nav-link active" href="#trainee">Trainees</a>
        </li>
        <li class="pull-right"><a data-toggle="tab" class="nav-link" href="#consultant">Consultants</a></li>
        <li class="pull-right"><a data-toggle="tab" class="nav-link" href="#admin">Admins</a></li>
      </ul>
    
      <!-- Tab Contents -->
      <div class="tab-content">
      
        <!-- Trainees Table Section -->
        <div id="trainee" class="tab-pane fade active show">
        
          <!-- Trainees Control Buttons -->
          <button type="button" id="add-trainee-button" class="btn btn-success" data-toggle="modal" data-target="#add-trainee-modal">
            <i class="fas fa-plus"></i>
            Add Trainee
          </button>
          <button type="button" id="trainee-options" class="btn btn-secondary" data-toggle="modal" data-target="#trainee-options-modal">
            <i class="fas fa-cog"></i>
          </button>
          
          <!-- Trainees Table -->
          <table class="table table-responsive">
            <thead>
              <tr>
                <th class="trainee-id">ID</th>
                <th class="trainee-username">Username</th>
                <th class="trainee-password">Password</th>
                <th class="trainee-firstname">First Name</th>
                <th class="trainee-lastname">Last Name</th>
                <th class="trainee-email">Email</th>
                <th class="trainee-phone">Phone</th>
                <th class="trainee-city">City</th>
                <th class="trainee-country">Country</th>
                <th class="trainee-description">Description</th>
                <th class="trainee-stream">Stream</th>
                <th class="trainee-linkedin">LinkedIn</th>
                <th class="trainee-security-answer">Security Answer</th>
                <th class="trainee-status">Status</th>
                <th class="trainee-visibility">Visibility</th>
                <th class="trainee-actions">Actions</th>
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
                  <td class="trainee-status">
                    <p style="display:none;">${user.isStatus()}</p>
                  </td>
                  <td class="trainee-visibility">
                    <p style="display:none;">${user.isVisibility()}</p>
                  </td>
                  <td class="trainee-actions" align="center">
                    <i class="fas fa-ellipsis-v action-button" data-toggle="modal" data-target="#edit-trainee-modal"></i>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        
        <!-- Consultants Table Section -->
        <div id="consultant" class="tab-pane fade">
        
          <!-- Consultants Control Buttons -->
          <button type="button" id="add-consultant-button" class="btn btn-success" data-toggle="modal" data-target="#add-consultant-modal">
            <i class="fas fa-plus"></i>
            Add Consultant
          </button>
          <button type="button" id="consultant-options" class="btn btn-secondary" data-toggle="modal" data-target="#consultant-options-modal">
            <i class="fas fa-cog"></i>
          </button>
          
          <!-- Consultants Table -->
          <table class="table table-responsive">
            <thead>
              <tr>
                <th class="consultant-id">ID</th>
                <th class="consultant-username">Username</th>
                <th class="consultant-password">Password</th>
                <th class="consultant-firstname">First Name</th>
                <th class="consultant-lastname">Last Name</th>
                <th class="consultant-email">Email</th>
                <th class="consultant-phone">Phone</th>
                <th class="consultant-city">City</th>
                <th class="consultant-country">Country</th>
                <th class="consultant-description">Description</th>
                <th class="consultant-title">Title</th>
                <th class="consultant-employer">Employer</th>
                <th class="consultant-pdate">Placement Date</th>
                <th class="consultant-linkedin">LinkedIn</th>
                <th class="consultant-security-answer">Security Answer</th>
                <th class="consultant-status">Status</th>
                <th class="consultant-visibility">Visibility</th>
                <th class="consultant-actions">Actions</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${sessionScope.consultants}" var="user">
                <tr id="${user.getUserId()}">
                  <td class="consultant-id">${user.getUserId()}</td>
                  <td class="consultant-username">${user.getUsername()}</td>
                  <td class="consultant-password">${user.getPassword()}</td>
                  <td class="consultant-firstname">${user.getFirstName()}</td>
                  <td class="consultant-lastname">${user.getLastName()}</td>
                  <td class="consultant-email">${user.getEmail()}</td>
                  <td class="consultant-phone">${user.getPhoneNumber()}</td>
                  <td class="consultant-city">${user.getCity()}</td>
                  <td class="consultant-country">${user.getCountry()}</td>
                  <td class="consultant-description">${user.getDescription()}</td>
                  <td class="consultant-title">${user.getCurrentTitle()}</td>
                  <td class=consultant-employer>${user.getEmployer()}</td>
                  <td class="consultant-pdate">${user.getpDate()}</td>
                  <td class="consultant-linkedin">${user.getLinkedInUrl()}</td>
                  <td class="consultant-security-answer">${user.getSecurityAnswer()}</td>
                  <td class="consultant-status">
                    <p style="display:none;">${user.isStatus()}</p>
                  </td>
                  <td class="consultant-visibility">
                    <p style="display:none;">${user.isVisibility()}</p>
                  </td>
                  <td class="consultant-actions" align="center">
                    <i class="fas fa-ellipsis-v action-button" data-toggle="modal" data-target="#edit-consultant-modal"></i>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        
        <!-- Admins Table Section -->
        <div id="admin" class="tab-pane fade">
          
          <!-- Admins Control Buttons -->
          <button type="button" id="add-admin-button" class="btn btn-success" data-toggle="modal" data-target="#add-admin-modal">
            <i class="fas fa-plus"></i>
            Add Admin
          </button>
          <button type="button" id="admin-options" class="btn btn-secondary" data-toggle="modal" data-target="#admin-options-modal">
            <i class="fas fa-cog"></i>
          </button>
          
          <!-- Admins Table -->
          <table class="table table-responsive">
            <thead>
              <tr>
                <th class="admin-id">ID</th>
                <th class="admin-username">Username</th>
                <th class="admin-password">Password</th>
                <th class="admin-security-answer">Security Answer</th>
                <th class="admin-status">Status</th>
                <th class="admin-actions">Actions</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${sessionScope.admins}" var="user">
                <tr id="${user.getUserId()}">
                  <td class="admin-id">${user.getUserId()}</td>
                  <td class="admin-username">${user.getUsername()}</td>
                  <td class="admin-password">${user.getPassword()}</td>
                  <td class="admin-security-answer">${user.getSecurityAnswer()}</td>
                  <td class="admin-status">
                    <p style="display:none;">${user.isStatus()}</p>
                  </td>
                  <td class="admin-actions" align="center">
                    <i class="fas fa-ellipsis-v action-button" data-toggle="modal" data-target="#edit-admin-modal"></i>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          
        </div>
        
      </div>
      <!-- /END of Tab Contents -->
    
      <!-- Trainee Options Modal -->
      <div class="modal fade" id="trainee-options-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Display Trainee Fields</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div id="trainee-column-toggles" class="modal-body">
              <!-- Body added via JS -->
            </div>
          </div>
        </div>
      </div>
    
      <!-- Add Trainee Modal -->
      <div class="modal fade" id="add-trainee-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Add Trainee</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <sf:form action="trainee" method="post" modelAttribute="newTrainee">
              
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-trainee-firstname" class="form-control" path="firstName" placeholder="First Name" required="required" />
                    </div>
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-trainee-lastname" class="form-control" path="lastName" placeholder="Last Name" required="required" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-trainee-username" class="form-control" path="username" placeholder="Username" required="required" />
                  <div class="error-message"></div>
                </div>
                
                <div class="form-group">
                  <sf:input type="password" id="add-trainee-password" class="form-control" path="password" placeholder="Password" required="required" />  
                </div>
                
                <div class="form-group">
                  <input type="password" id="add-trainee-confirm-password" class="form-control" name="confirm-password" placeholder="Confirm Password" required="required" />  
                  <div class="error-message"></div>
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-trainee-security-answer" class="form-control" path="securityAnswer" placeholder="Security Answer" required="required" />  
                </div>
                <div class="form-group">
                  <sf:input type="text" id="add-trainee-email" class="form-control" path="email" placeholder="Email" required="required" />  
                </div>
                <div class="form-group">
                  <sf:input type="text" id="add-trainee-phone" class="form-control" path="phoneNumber" placeholder="Phone Number" required="required" />  
                </div>
                
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-trainee-city" class="form-control" path="city" placeholder="City" required="required" />  
                    </div>
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-trainee-country" class="form-control" path="country" placeholder="Country" required="required" />  
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-trainee-linkedin" class="form-control" path="linkedInUrl" placeholder="LinkedIn" />  
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-trainee-stream" class="form-control" path="stream" placeholder="Stream" required="required" />  
                </div>
                
                <div class="form-group">
                  <button type="submit" id="confirm-create-trainee" class="btn btn-primary btn-lg btn-block login-btn">Create Trainee</button>
                </div>
              
              </sf:form>
              
            </div>
          </div>
        </div>
      </div>
      <!-- /END Add Trainee Modal -->
    
      <!-- Edit Trainee Modal -->
      <div class="modal fade edit-modal" id="edit-trainee-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">
              Edit Trainee
              <span id="edit-trainee-id"></span>
              </h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <div id="edit-trainee-body">
              <form id="edit-trainee" action="user" method="post">
              
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <input type="text" id="edit-trainee-firstname" class="form-control edittable" name="firstName" placeholder="First Name" />
                    </div>
                    <div class="col col-md-6">
                      <input type="text" id="edit-trainee-lastname" class="form-control edittable" name="lastName" placeholder="Last Name" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <input type="text" id="edit-trainee-username" class="form-control edittable" name="username" placeholder="Username" />
                </div>
                <div class="form-group">
                  <input type="password" id="edit-trainee-password" class="form-control edittable" name="password" placeholder="Password" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-email" class="form-control edittable" name="email" placeholder="Email" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-phone" class="form-control edittable" name="phone" placeholder="Phone Number" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-city" class="form-control edittable" name="city" placeholder="City" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-country" class="form-control edittable" name="country" placeholder="Country" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-description" class="form-control edittable" name="description" placeholder="Description" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-stream" class="form-control edittable" name="stream" placeholder="Stream" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-linkedin" class="form-control edittable" name="linkedin" placeholder="LinkedIn" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-trainee-security-answer" class="form-control edittable" name="security-answer" placeholder="Security Answer" />
                </div>
                
                <!-- Place status and visibility toggles here -->
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <label>Status</label>
                      <button type="button" class="btn status-open edittable"><i class="fas fa-lock-open"></i></button>
                      <button type="button" class="btn status-close edittable"><i class="fas fa-lock"></i></button>
                      <input type="text" id="edit-trainee-status" class="form-control" name="status" style="display:none" />
                    </div>
                    <div class="col col-md-6">
                      <label>Visibility</label>
                      <button type="button" class="btn set-visible edittable"><i class="fas fa-eye"></i></button>
                      <button type="button" class="btn set-invisible edittable"><i class="fas fa-eye-slash"></i></button>
                      <input type="text" id="edit-trainee-visibility" class="form-control" name="visibility" style="display:none" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <button type="submit" id="confirm-edit-trainee" class="btn btn-primary">Confirm Edit</button>
                  <!-- <a id="delete-trainee">Delete Trainee</a> -->
                </div>
              
              </form>
              </div>
              
            </div>
          </div>
        </div>
      </div>
      <!-- /END Trainee Edit Modal -->
      
      
      <!-- Consultant Options Modal -->
      <div class="modal fade" id="consultant-options-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Display Consultant Fields</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div id="consultant-column-toggles" class="modal-body">
              <!-- Body added via JS -->
            </div>
          </div>
        </div>
      </div>
      
      <!-- Add Consultant Modal -->
      <div class="modal fade" id="add-consultant-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Add Consultant</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <sf:form action="consultant" method="post" modelAttribute="newConsultant">
              
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-consultant-firstname" class="form-control" path="firstName" placeholder="First Name" required="required" />
                    </div>
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-consultant-lastname" class="form-control" path="lastName" placeholder="Last Name" required="required" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-username" class="form-control" path="username" placeholder="Username" required="required" />
                </div>
                
                <div class="form-group">
                  <sf:input type="password" id="add-consultant-password" class="form-control" path="password" placeholder="Password" required="required" />  
                </div>
                
                <div class="form-group">
                  <input type="password" id="add-consultant-confirm-password" class="form-control" name="confirm-password" placeholder="Confirm Password" required="required" />  
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-security-answer" class="form-control" path="securityAnswer" placeholder="Security Answer" required="required" />  
                </div>
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-email" class="form-control" path="email" placeholder="Email" required="required" />  
                </div>
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-phone" class="form-control" path="phoneNumber" placeholder="Phone Number" required="required" />  
                </div>
                
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-consultant-city" class="form-control" path="city" placeholder="City" required="required" />  
                    </div>
                    <div class="col col-md-6">
                      <sf:input type="text" id="add-consultant-country" class="form-control" path="country" placeholder="Country" required="required" />  
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-linkedin" class="form-control" path="linkedInUrl" placeholder="LinkedIn" />  
                </div>
                
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-title" class="form-control" path="currentTitle" placeholder="Current Title" required="required" />  
                </div>
                <div class="form-group">
                  <sf:input type="text" id="add-consultant-employer" class="form-control" path="employer" placeholder="Employer" required="required" />  
                </div>
                <div class="form-group">
                  <sf:input type="date" id="add-consultant-pdate" class="form-control" path="pDate" placeholder="Placement Date" required="required" />  
                </div>
                
                <div class="form-group">
                  <button type="submit" id="confirm-create-consultant" class="btn btn-primary btn-lg btn-block login-btn">Create Consultant</button>
                </div>
              
              </sf:form>
              
            </div>
          </div>
        </div>
      </div>
      <!-- /END Add Consultant Modal -->
      
      <!-- Edit Consultant Modal -->
      <div class="modal fade edit-modal" id="edit-consultant-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">
              Edit Consultant
              <span id="edit-consultant-id"></span>
              </h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            
              <div id="edit-consultant-body">
              <form id="edit-consultant" action="user" method="post">
              
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <input type="text" id="edit-consultant-firstname" class="form-control edittable" name="firstName" placeholder="First Name" />
                    </div>
                    <div class="col col-md-6">
                      <input type="text" id="edit-consultant-lastname" class="form-control edittable" name="lastName" placeholder="Last Name" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <input type="text" id="edit-consultant-username" class="form-control edittable" name="username" placeholder="Username" />
                </div>
                <div class="form-group">
                  <input type="password" id="edit-consultant-password" class="form-control edittable" name="password" placeholder="Password" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-email" class="form-control edittable" name="email" placeholder="Email" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-phone" class="form-control edittable" name="phone" placeholder="Phone Number" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-city" class="form-control edittable" name="city" placeholder="City" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-country" class="form-control edittable" name="country" placeholder="Country" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-description" class="form-control edittable" name="description" placeholder="Description" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-title" class="form-control edittable" name="title" placeholder="Title" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-employer" class="form-control edittable" name="employer" placeholder="Employer" />
                </div>
                <div class="form-group">
                  <input type="date" id="edit-consultant-pdate" class="form-control edittable" name="pdate" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-linkedin" class="form-control edittable" name="linkedin" placeholder="LinkedIn" />
                </div>
                <div class="form-group">
                  <input type="text" id="edit-consultant-security-answer" class="form-control edittable" name="security-answer" placeholder="Security Answer" />
                </div>
                
                <!-- Place status and visibility toggles here -->
                <div class="form-group">
                  <div class="row">
                    <div class="col col-md-6">
                      <label>Status</label>
                      <button type="button" class="btn status-open edittable"><i class="fas fa-lock-open"></i></button>
                      <button type="button" class="btn status-close edittable"><i class="fas fa-lock"></i></button>
                      <input type="text" id="edit-consultant-status" class="form-control" name="status" style="display:none" />
                    </div>
                    <div class="col col-md-6">
                      <label>Visibility</label>
                      <button type="button" class="btn set-visible edittable"><i class="fas fa-eye"></i></button>
                      <button type="button" class="btn set-invisible edittable"><i class="fas fa-eye-slash"></i></button>
                      <input type="text" id="edit-consultant-visibility" class="form-control" name="visibility" style="display:none" />
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <button type="submit" id="confirm-edit-consultant" class="btn btn-primary">Confirm Edit</button>
                </div>
              
              </form>
              </div>
              
            </div>
          </div>
        </div>
      </div>
      <!-- /END Consultant Edit Modal -->
      
      <!-- Admin Options Modal -->
      <div class="modal fade" id="admin-options-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Display Admin Fields</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div id="admin-column-toggles" class="modal-body">
              <!-- Body added via JS -->
            </div>
          </div>
        </div>
      </div>
    
    </div>

    <jsp:include page="footer.jsp" />
  </div>

</body>
</html>