package p1;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_servlet extends HttpServlet {
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","admin");
        PreparedStatement pstmt=con.prepareStatement("select * from register where name=? and password=?");
        pstmt.setString(1,name);
        pstmt.setString(2,password);
          
        int n=pstmt.executeUpdate();
        if(n>0){
//          response.sendRedirect('Homepage.html');
          out.println("Successfully logged in....!!");
          out.println("Hello This is online student Mentoring System !! Welcome to our website");
      }
      else {
        out.println("Login Failed");
//        response.sendRedirect('Signup.html');
      }        
    }
    catch(Exception e)
    {    
      System.out.println(e);  
    }
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    doGet(request, response);
  }

}