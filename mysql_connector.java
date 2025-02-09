
package Meal_management;
import com.mysql.cj.protocol.Resultset;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.applet.AppletViewer;
import sun.security.rsa.RSACore;



/**
 *
 *
 */
public class mysql_connector {
            String url="jdbc:mysql://localhost/users_db";
            String db_uname="root";
            String db_Password="";
    
        

    public mysql_connector()
    {
    
    }
 
    public int login_checker(String username,String password)
    {
        int count=0;
        
        
        try {
             
            String query="Select *from users";
            Connection con = DriverManager.getConnection(url,db_uname,db_Password);
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            
            
      
               while(rs.next())
        {
          
            String user_db=rs.getString("username");
            String pass_db=rs.getString("password");
            if(user_db.equals(username) && pass_db.equals(password))
            {
                
                count=count+1;
            }
        
            
        }
            
       
        } catch (SQLException ex) {
            Logger.getLogger(mysql_connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count;
     
    }
    
  
    
    public int signup_checker(String query,String username)
    {   int count=0;
       try {
            
           
            Connection con = DriverManager.getConnection(url,db_uname,db_Password);
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            
            
            
               while(rs.next())
        {
           
            String user_db=rs.getString("username");
            
            if(user_db.equals(username))
            {
                
                count=count+1;
                //JOptionPane.showMessageDialog(null, "Usename has been taken already");
            }
            
            
           
        }
               
        } catch (SQLException ex) {
            Logger.getLogger(mysql_connector.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       return count; 
    }
    
    public void insert_user_data(String uname,String pass,String fname,String lname,String mobile_no,String room_no)
    {
        
            try {
                Connection con;
                
        
                con = DriverManager.getConnection(url,db_uname,db_Password);
                
                String insertData ="INSERT INTO users(username,password, first_name, last_name, mobile, room) VALUES (?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(insertData);
         
                       
         
         stmt.setString(1,uname);
         stmt.setString(2,pass);
         stmt.setString(3,fname);
         stmt.setString(4,lname);
         stmt.setString(5,mobile_no);
         stmt.setString(6,room_no);



           stmt.executeUpdate();
            } catch (SQLException ex) {
              
                System.out.println(ex);  
            }
            
        
    }
    
    public void insert(String query,String[] array)
    {
        
            try {
                Connection con;
                
        
                con = DriverManager.getConnection(url,db_uname,db_Password);
                
                //String insertData ="INSERT INTO users(username,password, first_name, last_name, mobile, room) VALUES (?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(query);
         
                       
         for(int i =0;i<array.length;i++ )
         {
            stmt.setString(i+1,array[i]); 
            
         }
        
           stmt.executeUpdate();
            } catch (SQLException ex) {
              
                System.out.println(ex);  
            }
             
    }
    
    //retrieving data from database
    
    
    
    
    
    
    

    public static void main(String[] args) throws SQLException{
        
 
         mysql_connector obj=new mysql_connector();
         //obj.login_checker(null, null);
        // obj.signup_checker(null);
         
        
 
    }
    
}
