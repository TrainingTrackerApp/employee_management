package serviceimpl;

import dao.EmployeeDAO;
import daoimpl.EmployeeDAOImpl;
import daoimpl.EmployeeDAOJDBCImpl;
import exception.EmployeeNotFoundException;
import modal.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {

        this.employeeDAO = new EmployeeDAOJDBCImpl();
    }


    @Override
    public void addEmployee(Employee employee)
    {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public List<Employee> showAllEmployee()
    {
        return employeeDAO.list();
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void removeEmployee(Integer id)  throws EmployeeNotFoundException
    {
        try {
            employeeDAO.deleteEmployee(id);
        }
        catch (EmployeeNotFoundException e)
        {
            throw  new EmployeeNotFoundException(e.getMessage());
        }

    }
}
