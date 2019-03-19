<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
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
      <ul class="nav nav-tabs">
        <li class="pull-right"><a data-toggle="tab" href="#signup">Sign Up</a></li>
        <li class="active pull-right"><a data-toggle="tab" href="#login">Login</a></li>
      </ul>
    
      <div class="tab-content">
      
        <div id="login" class="tab-pane fade in active">
          <h3>LOGIN</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        
        <div id="signup" class="tab-pane fade">
          <h3>SIGN UP</h3>
          <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        
      </div>      
      
    </div>
      
    <jsp:include page="footer.jsp" />
  </div>

</body>
</html>