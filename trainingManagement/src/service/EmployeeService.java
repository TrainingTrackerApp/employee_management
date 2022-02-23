package service;

import exception.EmployeeNotFoundException;
import modal.Employee;

import java.util.List;

public interface EmployeeService
{
    void addEmployee(Employee employee);


    List<Employee> showAllEmployee();


    void updateEmployee();


    void removeEmployee(Integer id) throws EmployeeNotFoundException;
}
