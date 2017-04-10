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

import javax.servlet.http.HttpServlet;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/myfdb";

	   //  Database credentials/
	   static final String USER = "root";
	   static final String PASS = "root";
	//public static void main(String[] args) 
	   public void AbeEnc(String s1, String outFile, String fl,String pol)
	   {
		  System.out.println("712");
		  
		  System.out.println("s1::"+s1);
		  
		  System.out.println("outfile::"+outFile);
		  
		  System.out.println("fl=>"+fl);
		  
		Server server = new Server();
		
		  System.out.println("765");
	//	Client PKUClient = new Client(new String[]{"PKU", "Student"});
	//	Client THUClient = new Client(new String[]{"THU", "Student"});
	//	Client TeacherClient = new Client(new String[]{ "Teacher"});  // Ankit changes
		
		Client TeacherClient = new Client(new String[]{s1}); //s1 is passed instead of Teacher (ankit)
		
		System.out.println("705");
		
		
	  	String PKJSONString = server.getPublicKeyInString();
		String MKJSONString = server.getMasterKeyInString();
		//PKUClient.setPK(PKJSONString);
	//	THUClient.setPK(PKJSONString);
		TeacherClient.setPK(PKJSONString);

		
		System.out.println("706");
		
		//String SKJSONString = server.generateSecretKey(PKUClient.getAttrs());
	//	PKUClient.setSK(SKJSONString);
		
	//	SKJSONString = server.generateSecretKey(THUClient.getAttrs());
	//	THUClient.setSK(SKJSONString);
		
		 String SKJSONString = server.generateSecretKey(TeacherClient.getAttrs());
		System.out.println(SKJSONString);
		TeacherClient.setSK(SKJSONString);
		 Connection conn = null;
		   Statement stmt = null;
		   
		   
		   System.out.println("707");
		   
		   
		   //ANKIT CHANGES
		   String outputFileName = outFile;
			File in = new File(fl);
			String policy = pol;
		   
		   
		   
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
		      
		      String sql = "insert into data(fname,encname,masterkey, publickey, secretkey) values (?, ?, ?, ?, ?)";
		      PreparedStatement preparedStatement = conn.prepareStatement(sql);
		      preparedStatement.setString(1, fl);
		      preparedStatement.setString(2, outputFileName );
		      preparedStatement.setString(3, MKJSONString );
		     preparedStatement.setString(4, PKJSONString );
		      preparedStatement.setString(5, SKJSONString );
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
		
		/* String outputFileName = "demo.txt";
		File in = new File("read.txt");
		String policy = "Teacher";
		
		*/
		TeacherClient.enc(in, policy, outputFileName);
		
		in=new File(outFile); /// ankit changes
		
		
		//in = new File("demo.txt");    Ankit changes
		
		
		
		   
		   
//		THUClient.dec(in);
	//TeacherClient.dec(in);
	}
}
