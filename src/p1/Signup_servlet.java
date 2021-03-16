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

public class Signup_servlet extends HttpServlet
{
  
//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter(); 
    String name=request.getParameter("name");
    String gender=request.getParameter("gender");
    String job=request.getParameter("job");
    String birthday=request.getParameter("birthday");
    String email=request.getParameter("emailid");
    String phoneno=request.getParameter("mobile");
    String password=request.getParameter("password1");
    
    System.out.println(name);
    System.out.println(gender);
    System.out.println(job);
    System.out.println(birthday);
    System.out.println(email);
    System.out.println(phoneno);
    System.out.println(password);
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        
        
          PreparedStatement pstmt=con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
          
          pstmt.setString(1,name);
          pstmt.setString(2,gender);
          pstmt.setString(3,job);
          pstmt.setString(4,birthday);
          pstmt.setString(5,email);
          pstmt.setString(6,phoneno);
          pstmt.setString(7,password);
          
          int n=pstmt.executeUpdate();
          if(n>0)
            out.println("Successfully stored in the Database");
          else
            out.println("Failed.....!!");
    }
    catch(Exception e)
    {    
      System.out.println(e);  
      System.out.println("hirdgreh....................");  
    }
    out.close();
  }
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    
//    doGet(request, response);
//  }

}