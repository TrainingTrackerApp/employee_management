package util;

import exception.EmployeeNotFoundException;
import modal.Employee;
import service.EmployeeService;
import serviceimpl.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuUtil
{
    private EmployeeService employeeService;

    public MenuUtil()
    {
        employeeService=new EmployeeServiceImpl();
    }

    public void start()
    {
        int menuChoice;
        String continueChoice;
        Scanner sc=new Scanner(System.in);

        do {
            showMenu();  //Extract Method Shortcut---- ctrl+alt+M
            System.out.println("ENTER YOUR CHOICE: (1,2,3,4,0):");
            menuChoice = sc.nextInt();
            sc.nextLine(); //to read the enter key
            switch (menuChoice)
            {
                case 1:
                    Employee employee=new Employee();
                    System.out.println("Enter employee name");
                    employee.setEmployeenName(sc.nextLine());
                    System.out.println("Enter employee ID");
                    employee.setEmployeeId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter employee email");
                    employee.setEmployeeEmail(sc.nextLine());
                    employeeService.addEmployee(employee);
                    System.out.println("Employee Successfully Added!!");
                    break;

                case 2:
                    System.out.println("List of Employees");
                    List<Employee> lists=employeeService.showAllEmployee();
                    for(Employee emp:lists)
                    {
                        System.out.println(emp);
                    }
                    break;

                case 3:
                    System.out.println("Update operation");
                    break;

                case 4:
                    System.out.println("Delete Operation");
                    System.out.println("Enter ID of employee to delete");
                    Integer id=sc.nextInt();
                    try
                    {
                        employeeService.removeEmployee(id);
                    }
                    catch(EmployeeNotFoundException e)
                    {
                        System.out.println("Problem "+e.getMessage());
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }System.out.println("Do you want to continue: (yes/no):");
            continueChoice=sc.next();
        }while(continueChoice.equals("yes"));
    }

    private void showMenu()
    {
        System.out.println("This is Employee Management Module");
        System.out.println("1. ADD EMPLOYEE");
        System.out.println("2. LIST EMPLOYEES");
        System.out.println("3. UPDATE EMPLOYEE");
        System.out.println("4. DELETE EMPLOYEE");
        System.out.println("0. EXIT");
    }
}
