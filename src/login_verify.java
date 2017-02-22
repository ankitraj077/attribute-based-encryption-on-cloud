


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import javax.servlet.*;

/**
 * Servlet implementation class login_verify
 */
@WebServlet("/login_verify")
public class login_verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
		//##########our code########
		
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        out.print("username::"+uname);
        out.print("password::"+pass);
        
        if(Validate.checkUser(uname, pass))
        {
        	out.println("correct");
        	HttpSession session=request.getSession();  
            session.setAttribute("uname",uname);  
            RequestDispatcher rs = request.getRequestDispatcher("loginpage.jsp");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
   	
	}

}
