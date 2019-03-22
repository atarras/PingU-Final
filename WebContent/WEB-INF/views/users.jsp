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
        
          <button type="button" id="add-trainee-button" class="btn btn-success" data-toggle="modal" data-target="#add-trainee-modal">
            <i class="fas fa-plus"></i>
            Add Trainee
          </button>
          <button type="button" id="trainee-options" class="btn btn-secondary" data-toggle="modal" data-target="#trainee-options-modal">
            <i class="fas fa-cog"></i>
          </button>
          
        
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
        <div id="consultant" class="tab-pane fade">
          <button type="button" id="add-consultant-button" class="btn btn-success" data-toggle="modal" data-target="#add-consultant-modal">
            <i class="fas fa-plus"></i>
            Add Consultant
          </button>
          <button type="button" id="consultant-options" class="btn btn-secondary" data-toggle="modal" data-target="#consultant-options-modal">
            <i class="fas fa-cog"></i>
          </button>
          
        
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
            <h5 class="modal-title" id="exampleModalLongTitle">Display Trainee Fields</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div id="trainee-column-toggles" class="modal-body">
          
            <!-- <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-id" checked>
              <label class="form-check-label" for="show-trainee-id">
                ID
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-username" checked>
              <label class="form-check-label" for="show-trainee-username">
                Username
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-password">
              <label class="form-check-label" for="show-trainee-password">
                Password
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-firstname" checked>
              <label class="form-check-label" for="show-trainee-firstname">
                First Name
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-lastname" checked>
              <label class="form-check-label" for="show-trainee-lastname">
                Last Name
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-email">
              <label class="form-check-label" for="show-trainee-email">
                Email
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-phone">
              <label class="form-check-label" for="show-trainee-phone">
                Phone
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-city" checked>
              <label class="form-check-label" for="show-trainee-city">
                City
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-country" checked>
              <label class="form-check-label" for="show-trainee-country">
                Country
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-description">
              <label class="form-check-label" for="show-trainee-description">
                Description
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-stream" checked>
              <label class="form-check-label" for="show-trainee-stream">
                Stream
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-linkedin">
              <label class="form-check-label" for="show-trainee-linkedin">
                LinkedIn
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-security-answer">
              <label class="form-check-label" for="show-trainee-security-answer">
                Security Answer
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-status" checked>
              <label class="form-check-label" for="show-trainee-status">
                Status
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-visibility" checked>
              <label class="form-check-label" for="show-trainee-visibility">
                Visibility
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input column-toggle" type="checkbox" id="show-trainee-actions" checked>
              <label class="form-check-label" for="show-trainee-actions">
                Actions
              </label>
            </div> -->
            
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
                    <sf:input type="text" id="signup-firstname-field" class="form-control" path="firstName" placeholder="First Name" required="required" />
                  </div>
                  <div class="col col-md-6">
                    <sf:input type="text" id="signup-lastname-field" class="form-control" path="lastName" placeholder="Last Name" required="required" />
                  </div>
                </div>
              </div>
              
              <div class="form-group">
                <sf:input type="text" id="signup-username-field" class="form-control" path="username" placeholder="Username" required="required" />
                <div id="username-exists-section" class="error-message"></div>
              </div>
              
              <div class="form-group">
                <sf:input type="password" id="signup-password-field" class="form-control" path="password" placeholder="Password" required="required" />  
              </div>
              
              <div class="form-group">
                <input type="password" id="signup-confirm-password-field" class="form-control" name="confirm-password" placeholder="Confirm Password" required="required" />  
                <div id="password-does-not-match-section" class="error-message"></div>
              </div>
              
              <div class="form-group">
                <sf:input type="text" class="form-control" path="securityAnswer" placeholder="Security Answer" required="required" />  
              </div>
              <div class="form-group">
                <sf:input type="text" class="form-control" path="email" placeholder="Email" required="required" />  
              </div>
              <div class="form-group">
                <sf:input type="text" class="form-control" path="phoneNumber" placeholder="Phone Number" required="required" />  
              </div>
              
              <div class="form-group">
                <div class="row">
                  <div class="col col-md-6">
                    <sf:input type="text" class="form-control" path="city" placeholder="City" required="required" />  
                  </div>
                  <div class="col col-md-6">
                    <sf:input type="text" class="form-control" path="country" placeholder="Country" required="required" />  
                  </div>
                </div>
              </div>
              
              <div class="form-group">
                <sf:input type="text" class="form-control" path="linkedInUrl" placeholder="LinkedIn" />  
              </div>
              
              <div class="form-group">
                <sf:input type="text" class="form-control" path="stream" placeholder="Stream" required="required" />  
              </div>
              
              <div class="form-group">
                <button type="submit" id="confirm-create-trainee" class="btn btn-primary btn-lg btn-block login-btn">Create Trainee</button>
              </div>
            
            </sf:form>
            
          </div>
        </div>
      </div>
    </div>
    
    <!-- Edit Trainee Modal -->
    <div class="modal fade" id="edit-trainee-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
                    <button type="button" id="trainee-status-open" class="btn edittable"><i class="fas fa-lock-open"></i></button>
                    <button type="button" id="trainee-status-close" class="btn edittable"><i class="fas fa-lock"></i></button>
                    <input type="text" id="edit-trainee-status" class="form-control" name="status" style="display:none" />
                  </div>
                  <div class="col col-md-6">
                    <label>Visibility</label>
                    <button type="button" id="trainee-set-visible" class="btn edittable"><i class="fas fa-eye"></i></button>
                    <button type="button" id="trainee-set-invisible" class="btn edittable"><i class="fas fa-eye-slash"></i></button>
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
            
            <!-- <div id="delete-trainee-body" style="display:none">
              <h5>Delete trainee?</h5>
              <div class="form-group">
                <button type="button" id="confirm-delete-trainee" class="btn btn-danger">Delete Trainee</button>
                <button type="button" id="cancel-delete-trainee" class="btn btn-secondary">Undo</button>
              </div>
            </div> -->
            
          </div>
        </div>
      </div>
    </div>
    </div>

    <jsp:include page="footer.jsp" />
  </div>

</body>
</html>