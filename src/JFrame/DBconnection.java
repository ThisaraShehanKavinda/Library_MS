/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFrame;


import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author PC
 */
public class DBconnection {
    static Connection con = null;
   
public static Connection getConnection(){    
    try{
    Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
}
    catch(Exception ex){
        ex.printStackTrace();
    }
    return con;
}
}
