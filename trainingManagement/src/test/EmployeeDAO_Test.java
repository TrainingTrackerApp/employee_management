package test;

import dao.EmployeeDAO;
import daoimpl.EmployeeDAOImpl;
import modal.Employee;

import java.util.List;

public class EmployeeDAO_Test
{
    public static void main(String[] args)
    {
        EmployeeDAO employeeDAO=new EmployeeDAOImpl();

        Employee employee=new Employee();
        employee.setEmployeenName("Siddhant");
        employee.setEmployeeId(101);

        Employee employee1=new Employee();
        employee1.setEmployeenName("Aman");
        employee1.setEmployeeId(101);


        employeeDAO.saveEmployee(employee);
        employeeDAO.saveEmployee(employee1);

        System.out.println("Success");

        List<Employee> employees=employeeDAO.list();
        System.out.println(employees);

//        employeeDAO.deleteEmployee(employee.getEmployeeId());


        System.out.println(employees);

        employeeDAO.searchEmployee(employee);
    }
}
