package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/PRFServlet")
public class PRFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PRFServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String a=request.getParameter("address");
		
		String email=request.getParameter("email");
		
		String city=request.getParameter("city");
		
		String state=request.getParameter("state");
		
		String pname=request.getParameter("pname");
		
		long phone=Long.parseLong(request.getParameter("phone"));
        
        String ptype=request.getParameter("ptype");
	
		int page=Integer.parseInt(request.getParameter("page"));
       
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/prf", "root","root");
            PreparedStatement ps=con.prepareStatement("insert into regtab(FirstName, LastName, Address, EmailID, City, State, PetName, PhoneNumber, PetType, PetAge) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, a);
            ps.setString(4, email);
            ps.setString(5, city);
            ps.setString(6, state);
            ps.setString(7, pname);
            ps.setLong(8, phone);
            ps.setString(9, ptype);
            ps.setInt(10,page);
            
            int i = ps.executeUpdate();
            if(i==1){
           // RequestDispatcher rd=request.getRequestDispatcher("./sucess.html");
            //rd.forward(request, response);
            	pw.println("Fisrt Name: "+fname+"<br/>");
        		pw.println("Last Name: "+lname+"<br/>");
        		pw.println("Address: "+a+"<br/>");
        		pw.println("E-mail ID: "+email+"<br/>");
        		pw.println("City: "+city+"<br/>");
        		pw.println("State: "+state+"<br/>");
        		pw.println("Pet Name: "+pname+"<br/>");
                pw.println("Phone: "+phone+"<br/>");
        		pw.println("Pet Type: "+ptype+"<br/>");
                pw.println("Pet Age: "+page+"<br/>");
            
    }
 }
catch(Exception e){
            System.out.println(e);
}
	}

}
