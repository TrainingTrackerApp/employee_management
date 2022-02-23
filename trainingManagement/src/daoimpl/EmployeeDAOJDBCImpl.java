package daoimpl;

import dao.EmployeeDAO;
import exception.EmployeeNotFoundException;
import modal.Employee;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJDBCImpl extends DBUtil implements EmployeeDAO {
    @Override
    public void saveEmployee(Employee employee) {
        String sql="insert into employees (employeenName, employeeEmail) values(?,?)";
        PreparedStatement pstmt=preparedStatement(sql);
        try {
            pstmt.setString(1, employee.getEmployeenName());
            pstmt.setString(2, employee.getEmployeeEmail());
            pstmt.execute();
        }catch(SQLException ex)
        {
            System.out.println("Problem "+ex.getMessage());
        }
        finally {
            closePrepareStatement();
            closeConnection();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Integer id) throws EmployeeNotFoundException
    {
        String sql="delete from employees where employeeId=?";
        PreparedStatement pstmt=preparedStatement(sql);
        try {
            pstmt.setInt(1, id);
            pstmt.execute();
        }catch(SQLException ex)
        {
            System.out.println("Problem "+ex.getMessage());
        }
        finally {
            closePrepareStatement();
            closeConnection();
        }
    }

    @Override
    public void searchEmployee(Employee employee) {

    }

    @Override
    public List<Employee> list() {
        String sql = "Select * from employees";
        PreparedStatement pstmt = preparedStatement(sql);
        Employee employee;
        List<Employee> employees=new ArrayList<>();
        try {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                employee=new Employee();
                employee.setEmployeenName(rs.getString("employeenName"));
                employee.setEmployeeEmail(rs.getString("employeeEmail"));



                employees.add(employee);
            }
        } catch (SQLException ex){
            System.out.println("Problem "+ex.getMessage());
        }
        finally {
            closeConnection();
            closePrepareStatement();
        }

        return employees;
    }
}
