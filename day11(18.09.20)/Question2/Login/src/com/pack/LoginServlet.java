package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String l=request.getParameter("loginid");
		String p=request.getParameter("password");
			
		boolean status=false;  
		
		try{   
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration","root","root");  
		      
		PreparedStatement ps=con.prepareStatement("select * from user where loginId=? and password=?");  
		ps.setString(1,l);  
		ps.setString(2,p);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
         
		}
		catch(Exception e){
			
			System.out.println(e);
			status=false;
			}  
		finally {
		if(status)
		{
			RequestDispatcher rd=request.getRequestDispatcher("./success.html");  
	        rd.forward(request,response);  
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("./error.html");  
	        rd.forward(request,response);  
		}
		}
		
	}

}
