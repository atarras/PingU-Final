<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
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

  <jsp:include page="nav.jsp" />
  
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
        <form action="signup" method="post">
              <h2 id="sign-up-title">Sign Up</h2>
              
              <div class="form-group">
                <div class="row">
                  <div class="col col-md-6">
                    <input type="text" id="signup-firstname-field" class="form-control login-form-field" name="firstname" placeholder="First Name" required="required">
                  </div>
                  <div class="col col-md-6">
                    <input type="text" id="signup-lastname-field" class="form-control login-form-field" name="lastname" placeholder="Last Name" required="required">
                  </div>
                </div>
              </div>
              
              <div class="form-group">
                <input type="text" id="signup-username-field" class="form-control login-form-field" name="username" placeholder="Username" required="required">
                <div id="username-exists-section" class="error-message"></div>
              </div>
              
              <div class="form-group">
                <input type="password" id="signup-password-field" class="form-control login-form-field" name="password" placeholder="Password" required="required">  
              </div>
              
              <div class="form-group">
                <input type="password" id="signup-confirm-password-field" class="form-control login-form-field" name="confirm-password" placeholder="Confirm Password" required="required">  
                <div id="password-does-not-match-section" class="error-message"></div>
              </div>
              
              <div class="form-group">
                <button type="submit" id="sign-up-button" class="btn btn-primary btn-lg btn-block login-btn">Sign Up</button>
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