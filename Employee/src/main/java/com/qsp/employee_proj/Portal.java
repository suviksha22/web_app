package com.qsp.employee_proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Portal extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{    
	            String  name = req.getParameter("nm");
	            String  E_ID = req.getParameter("id");
	            String  Dept = req.getParameter("Department");
	            String  join = req.getParameter("yj");
	            String  sal = req.getParameter("sal");
	            int salary = Integer.parseInt(sal);
	            String  gender = req.getParameter("g");
	            PrintWriter out = resp.getWriter();
	            out.print("<html><body bgcolor='crimson'><h1>Emplyoee details Registered Succefully!!</h1><br/>"+"Name: "+name+"<br/>"
	            		+"id: "+E_ID+"<br/>"+"Dept: "+Dept+"<br/>"+"joining: "+join+"<br/>"
	            		+"salary: "+sal+"<br/>"+"gender: "+gender+"</body></html>");
	        String qry = "insert into employee_info.emplyoee values(?,?,?,?,?,?)";
	            // jdbc logic
	            try {
					Class.forName("com.mysql.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			           PreparedStatement pstmt = con.prepareStatement(qry);
                       pstmt.setString(1, name);
					   pstmt.setString(2, E_ID);
					   pstmt.setString(3, Dept);
					   pstmt.setString(4,join);
					   pstmt.setInt(5, salary);
					   pstmt.setString(6, gender);
					  
					 pstmt.executeUpdate();
					 System.out.println("information inserted");
					 
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					
					
				}
	         
	}
             
}
