package dao;


import exception.EmployeeNotFoundException;
import modal.Employee;

import java.util.List;

/**
 * This interface will work on the CRUD of the project
 */
public interface EmployeeDAO
{
    /**
     * This will help to add the employee data
     */
    public void saveEmployee(Employee employee);


    /**
     * This will help to update the employee data
     */
    public void updateEmployee(Employee employee);

    /**
     * This will help to delete the employee data
     */
    public void deleteEmployee(Integer id) throws EmployeeNotFoundException;

    /**
     * This will help to search the employee data
     */
    public void searchEmployee(Employee employee);

    /**
     * This method will return all the Employee in the list
     * @return List of employee id found
     */
    List<Employee> list();


}
