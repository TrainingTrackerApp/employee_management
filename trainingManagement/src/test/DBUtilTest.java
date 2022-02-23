package test;

import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtilTest
{

    public static void main(String[] args)
    {
        DBUtil dbUtil=new DBUtil();
        String sql="insert into employees (employeenName, employeeEmail) values(?,?)";
        PreparedStatement pstmt=dbUtil.preparedStatement(sql);
        try {
            pstmt.setString(1, "Siddhant");
            pstmt.setString(2, "siddhant.xyz@hotmail.com");
            pstmt.execute();
            System.out.println("Success! SQL Created");
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            dbUtil.closePrepareStatement();
            dbUtil.closeConnection();
        }

    }
}
