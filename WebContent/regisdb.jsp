
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
<%@ page import ="java.sql.PreparedStatement" %>

<%
    String uname=request.getParameter("uname");
    String pass=request.getParameter("password");
    String profile=request.getParameter("profile");
    String locat=request.getParameter("locat");
    String skey=null;
   //out.println(locat);
  
    
   try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myfdb","root","root");
         
         //ankit
         if (con != null) 
             System.out.println("Connected to the database");
         
 
    

		 Statement st=con.createStatement();
		
		 // PreparedStatement pstmt = null;
		 
		 /*		 
			         String query = "insert into userdetails(name,profile,location,secretkey,password) values(?, ?, ? , ? , ? )";
                     pstmt = con.prepareStatement(query); // create a statement
			         pstmt.setString(1, uname); // set input parameter 1
			         pstmt.setString(2, profile); // set input parameter 2
			         pstmt.setString(3, location);
			         pstmt.setString(4, null);// set input parameter 3
			         pstmt.setString(5, pass);
			        
			         pstmt.executeUpdate();
			         int i = pstmt.executeUpdate();
		 */
         int i=st.executeUpdate( "INSERT INTO userdetails(name,profile,location,secretkey,password)VALUES('"+uname+"','"+profile+"','"+locat+"','"+skey+"','"+pass+"')");
         
         con.close();
         if(i!=0){
       out.println("<script>alert('registered')</script>");
      //"ankit" response.sendRedirect("aa.jsp?msg=registered sucess..!");
            }
   }
 
  
  catch(Exception e){
      out.println(e.getMessage());
  }
   
%>