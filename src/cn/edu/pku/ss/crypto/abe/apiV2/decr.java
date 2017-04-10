package cn.edu.pku.ss.crypto.abe.apiV2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.pku.ss.crypto.abe.Parser;
import cn.edu.pku.ss.crypto.abe.Policy;
public class decr {
	 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  String DB_URL = "jdbc:mysql://localhost:3306/myfdb";

	   //  Database credentials
	   String USER = "root";
	   String PASS = "root";
	//public static void main(String[] args) 
	   //public static void main(String[] a)
	   public void decryp(String pol, String file)
	   {
		   System.out.println(file+" this is here "+pol);
		String PKStin= null;
		String SKStin=null;
		Connection conn = null;
		   Statement stmt = null;
		   int i=file.lastIndexOf("\\");
		   //int k=file.length();
		   
		   String flname=file.substring(i+1);
		   System.out.println(flname);
		   
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		     // System.out.println("Inserting records into the table...");
		    //  stmt = conn.createStatement();
		      
		      String sql = "select masterkey,publickey,secretkey from data where encname=\""+flname+"\"";
		      PreparedStatement preparedStatement = conn.prepareStatement(sql);
		      ResultSet rs = preparedStatement.executeQuery(sql );
		      while (rs.next()) {
		    	  String MKStin = rs.getString("masterkey");
		      	 PKStin = rs.getString("publickey");
		      	 SKStin = rs.getString("secretkey");
		      	System.out.println(MKStin);
		      	System.out.println(PKStin);
		      	System.out.println(SKStin);
		      }
		    
		      //System.out.println("Inserted records into the table...");

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
		   
		   System.out.println("Goodbye!");
		
		   Server server = new Server();
		Client TeacherClient = new Client(new String[]{pol});
		
		
	//	Server server = new Server();
		//	Client PKUClient = new Client(new String[]{"PKU", "Student"});
		//	Client THUClient = new Client(new String[]{"THU", "Student"});
		//	Client TeacherClient = new Client(new String[]{ "Teacher"});
			
		  String PKJSONString = server.getPublicKeyInString();
		  String MKJSONString = server.getMasterKeyInString();
			//PKUClient.setPK(PKJSONString);
		//	THUClient.setPK(PKJSONString);
			
			//String PKJSONString=PKStin;
			TeacherClient.setPK(PKJSONString);

			
			//String SKJSONString = server.generateSecretKey(PKUClient.getAttrs());
		//	PKUClient.setSK(SKJSONString);
			
		//	SKJSONString = server.generateSecretKey(THUClient.getAttrs());
		//	THUClient.setSK(SKJSONString);
			
		    String SKJSONString = server.generateSecretKey(TeacherClient.getAttrs());
		//	String SKJSONString=SKStin;
			System.out.println(SKJSONString);
			TeacherClient.setSK(SKJSONString);
		
		//ankit	File	in = new File(file);
			File	in = new File(file);
//			THUClient.dec(in);
		
		int x=TeacherClient.dec(in);
		if(x==1)
		{
			TeacherClient.setPK(PKStin);
			TeacherClient.setSK(SKStin);
			int z =TeacherClient.dec(in);
		}
		//TeacherClient.dec(in);
		   }
	}
	}