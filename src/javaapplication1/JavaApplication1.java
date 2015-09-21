/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MASTER
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Connection con= null;
        con = getConnection();
        getRecord(con);
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        String databasename = "test";
        String driver ="org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost/"+databasename;
        String username = "root";
        String password ="";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,username, password);
        return con; 
    }
    public static void getRecord(Connection conn) throws SQLException
    {
        String tablename  = "user_info";
        Statement stmt = null;
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM "+tablename);
        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
        }        
    }
    
}
