<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Login | PingU</title>
  <!-- Include in every page -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value="resources/css/main.css" />" />
  <script src="<c:url value="resources/js/main.js" />"></script>

  <!-- Login page specific -->
  <link rel="stylesheet" href="<c:url value="resources/css/login.css" />" />
  <script src="<c:url value="resources/js/login.js" />"></script>
</head>
<body>

  <div class="flex-wrapper">

    <div id="main-body" class="container">
    <div id="login-signup">
    
      <ul class="nav nav-tabs">
        <li class="pull-right"><a data-toggle="tab" href="#signup">Sign Up</a></li>
        <li class="active pull-right"><a data-toggle="tab" href="#login">Login</a></li>
      </ul>
    
      <div class="tab-content">
      
        <div id="login" class="panel panel-default tab-pane fade in active">
          <div class="panel-body">
            <form action="login" method="post">
              <h2 id="login-title">Login</h2>
              
              <div class="form-group">
                <input type="text" id="login-username-field" class="form-control login-form-field" title="Enter your username" name="username" placeholder="Username" required="required">
                <c:if test="${sessionScope.usernameIncorrect}">
                    <div class="error-message">Username incorrect</div>
                </c:if>
              </div>
              
              <div class="form-group">
                <input type="password" class="form-control login-form-field" title="Enter your password" name="password" placeholder="Password" required="required">  
                <c:if test="${sessionScope.passwordIncorrect}">
                    <div class="error-message">Password incorrect</div>
                </c:if>
              </div>
              
              <div class="form-group">
                <button type="submit" id="login-button" class="btn btn-primary btn-lg btn-block login-btn">Login</button>
              </div>
              
            </form>
          </div>
          <div class="panel-footer">
            <p><a href="#">Forgot Password?</a></p>
          </div>
        </div>
        
        <div id="signup" class="panel panel-default tab-pane fade">
          <div class="panel-body">
            <sf:form id="signup-form" action="signup-t" method="post" modelAttribute="newUser">
              <h2 id="sign-up-title">Sign Up</h2>
              
              <div class="form-group">
                <div class="row">
                  <div class="col col-md-6">
                    <sf:input type="text" id="signup-firstname-field" class="form-control signup-form-field" path="firstName" placeholder="First Name" required="required" />
                  </div>
                  <div class="col col-md-6">
                    <sf:input type="text" id="signup-lastname-field" class="form-control signup-form-field" path="lastName" placeholder="Last Name" required="required" />
                  </div>
                </div>
              </div>
                  
              <div class="form-group">
                <sf:input type="text" id="signup-username-field" class="form-control signup-form-field" path="username" placeholder="Username" required="required" />
                <div id="username-exists-section" class="error-message"></div>
              </div>
              
              <div class="form-group">
                <sf:input type="password" id="signup-password-field" class="form-control signup-form-field" path="password" placeholder="Password" required="required" />  
              </div>
              
              <div class="form-group">
                <input type="password" id="signup-confirm-password-field" class="form-control signup-form-field" name="confirm-password" placeholder="Confirm Password" required="required" />  
                <div id="password-does-not-match-section" class="error-message"></div>
              </div>
                  
              <div class="form-group">
                <sf:input type="text" id="signup-email-field" class="form-control signup-form-field" path="email" placeholder="Email" required="required" />  
                <div id="malformed-email" class="error-message"></div>
              </div>
              
              <div class="form-group">
                <div class="row">
                  <div class="col col-md-6">
                    <sf:input type="text" id="signup-city-field" class="form-control signup-form-field" path="city" placeholder="City" required="required" />
                  </div>
                  <div class="col col-md-6">
                    <sf:input type="text" id="signup-country-field" class="form-control signup-form-field" path="country" placeholder="Country" required="required" />
                  </div>
                </div>
              </div>
                  
              <div class="form-group">
                <sf:input type="text" id="signup-linkedin-field" class="form-control signup-form-field" path="linkedInUrl" placeholder="Linkedin" />  
              </div>
              
              <!-- This field is only for front-end control, we won't need to access this in the backend -->
              <div class="form-group">
                <label>User Type</label>
                <select id="sign-up-usertype-field" class="form-control" name="usertype">
                  <option>Trainee</option>
                  <option>Consultant</option>
                </select>
              </div>
                  
              <div id="trainee-additional-fields">
                <div class="form-group">
                  <input type="text" id="signup-stream-field" class="form-control signup-form-field" name="stream" placeholder="Stream" required="required" />
                </div>
              </div>
    
              <div id="consultant-additional-fields" style="display:none;">
                <div class="form-group">
                  <input type="text" id="signup-title-field" class="form-control signup-form-field" name="title" placeholder="Job Title" />
                </div>
                <div class="form-group">
                  <input type="text" id="signup-employer-field" class="form-control signup-form-field" name="employer" placeholder="Employer" />
                </div>
              </div>
                  
              <div class="form-group">
                <button type="submit" id="sign-up-button" class="btn btn-primary btn-lg btn-block login-btn">Sign Up</button>
              </div>
                  
            </sf:form>
          </div>
        </div>
      </div>
    </div>
    </div>
      
    <jsp:include page="footer.jsp" />
  </div>

</body>
</html>