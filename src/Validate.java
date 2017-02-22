import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String uname,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
    	  System.out.println(uname+"  "+password+"   ");
    	  
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/myfdb","root","root");
        
         if (con != null) 
             System.out.println("Connected to the database");
         else
        	 System.out.println("failed connection");
         
         PreparedStatement ps =con.prepareStatement
                             ("select * from userdetails where name=? and password=?");
         ps.setString(1, uname);
         ps.setString(2, password);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}
