package airline.management.system;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            // Register SQL Driver
            Class.forName("com.mysql.jdbc.Driver");  
            // Connect to database using Connection URL
            c = DriverManager.getConnection("jdbc:mysql:///airline_management_db","root","@Kanha25@");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  