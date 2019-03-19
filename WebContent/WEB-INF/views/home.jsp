<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Home | PingU</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value="resources/css/main.css" />" />
  <script src="<c:url value="resources/js/main.js" />"></script>
  
  <link rel="stylesheet" href="<c:url value="resources/css/home.css" />" />
  <script src="<c:url value="resources/js/home.js" />"></script>
</head>
<body>
  <jsp:include page="nav.jsp" />
  
  <div class="flex-wrapper">

    <div id="main-body" class="container">
      <h1>Hello World</h1>
    </div>
      
      
    <jsp:include page="footer.jsp" />
  </div>
  
</body>
</html>