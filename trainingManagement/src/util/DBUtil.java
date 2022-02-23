package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil
{
    private static final String driverclassName="com.mysql.cj.jdbc.Driver";
    private String driverClassName="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://localhost/employeemanagement";
    private String username="root";
    private String password="root";
    private  Connection conn=null;
    private PreparedStatement pstmt=null;

    static{
        try {
            Class c=Class.forName(driverclassName);
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection connect()
    {
        try
        {
            conn= DriverManager.getConnection(url,username,password);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public PreparedStatement preparedStatement(String sql)
    {
        try {
            pstmt = connect().prepareStatement(sql);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return pstmt;
    }

    public void closePrepareStatement()
    {
        try {
            pstmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void closeConnection()
    {
        try {
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
