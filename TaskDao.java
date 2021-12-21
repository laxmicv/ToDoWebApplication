/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import java.util.*;  
import java.sql.*;  
public class TaskDao {
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Task e){  
        int status=0;  
        try{  
            Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into todo123(name) values (?)");  
            ps.setString(1,e.getName());  
status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Task e){  
        int status=0;  
        try{  
            Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update todo123 set name=?");  
            ps.setString(1,e.getName());  
             
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int name){  
        int status=0;  
        try{  
            Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from todo123 where name=?");  
            ps.setInt(1,name);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Task getTaskbyname(int name){  
        Task e=new Task();  
          
        try{  
            Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from todo123 where name=?");  
            ps.setInt(1,name);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setName(rs.getString(1));    
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Task> getAllTasks(){  
        List<Task> list=new ArrayList<Task>();  
          
        try{  
            Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from todo123");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Task e=new Task();   
                e.setName(rs.getString(1));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
           