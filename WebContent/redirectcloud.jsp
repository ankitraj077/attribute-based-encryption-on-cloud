<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Redirection</title>
</head>
<body>
<h1>Redirecting to Cloud Portal</h1>
<h2>redirect</h2>
<%
   // New location to be redirected
   String site = new String("https://script.google.com/macros/s/AKfycbxor4406VnvNsMiVQWpU_OKb4yLcE6XtlJWBFPUGpHu_9x_W5hC/exec");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>
</body>
</html>