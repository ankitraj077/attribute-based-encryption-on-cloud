package cn.edu.pku.ss.crypto.abe.apiV2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

	   //  Database credentials/
	   static final String USER = "root";
	   static final String PASS = "root";
	public static void main(String[] args) {
		Server server = new Server();
	//	Client PKUClient = new Client(new String[]{"PKU", "Student"});
	//	Client THUClient = new Client(new String[]{"THU", "Student"});
		Client TeacherClient = new Client(new String[]{ "Teacher"});
		
	  	String PKJSONString = server.getPublicKeyInString();
		String MKJSONString = server.getMasterKeyInString();
		//PKUClient.setPK(PKJSONString);
	//	THUClient.setPK(PKJSONString);
		TeacherClient.setPK(PKJSONString);

		
		//String SKJSONString = server.generateSecretKey(PKUClient.getAttrs());
	//	PKUClient.setSK(SKJSONString);
		
	//	SKJSONString = server.generateSecretKey(THUClient.getAttrs());
	//	THUClient.setSK(SKJSONString);
		
		 String SKJSONString = server.generateSecretKey(TeacherClient.getAttrs());
		System.out.println(SKJSONString);
		TeacherClient.setSK(SKJSONString);
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		    //  stmt = conn.createStatement();
		      
		      String sql = "insert into data(masterkey, publickey, secretkey) values (?, ?, ?)";
		      PreparedStatement preparedStatement = conn.prepareStatement(sql);
		      preparedStatement.setString(1, MKJSONString );
		     preparedStatement.setString(2, PKJSONString );
		      preparedStatement.setString(3, SKJSONString );
		      preparedStatement.execute();
		    
		      System.out.println("Inserted records into the table...");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		
		String outputFileName = "demo.txt";
		File in = new File("read.txt");
		String policy = "Teacher";
		TeacherClient.enc(in, policy, outputFileName);
		
		
		in = new File("demo.txt");
//		THUClient.dec(in);
	//TeacherClient.dec(in);
	}
}
