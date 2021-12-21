/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Tasks</a>");  
        out.println("<h1>Task List</h1>");  
          
        List<Task> list=TaskDao.getAllTasks();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Name</th><th>Edit</th><th>Delete</th></tr>");  
        for(Task e:list){  
         out.print("<tr<td>"+e.getName()+"</td><td><a href='EditServlet?id="+e.getName()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getName()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  
