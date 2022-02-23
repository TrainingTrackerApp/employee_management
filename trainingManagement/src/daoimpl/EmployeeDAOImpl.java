package daoimpl;

import dao.EmployeeDAO;
import exception.EmployeeNotFoundException;
import modal.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO
{

    List<Employee> localRepository;

    public EmployeeDAOImpl()
    {
        this.localRepository=new ArrayList<>();
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        localRepository.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee)
    {

    }


    @Override
    public void deleteEmployee(Integer id) throws EmployeeNotFoundException
    {
        boolean isFound=false;
        for (Employee employee:localRepository)
        {
            if (employee.getEmployeeId().equals(id))
            {
                isFound=true;
                localRepository.remove(employee);
                break;
            }
            else
            {
                isFound=false;
            }
        }
    }

    @Override
    public List<Employee> list() {
        return localRepository;
    }

    @Override
    public void searchEmployee(Employee employee)
    {
        if(localRepository.contains(employee))
            System.out.println("We found "+employee.getEmployeenName());
    }

}
