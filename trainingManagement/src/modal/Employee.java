package modal;

public class Employee
{

    /**
     * id of the employee
     */
    private Integer employeeId;


    /**
     * Name of the employee
     */
    private String employeenName;

    /**
     * Email of the employee
     * @return
     */
    private String employeeEmail;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeenName() {
        return employeenName;
    }

    public void setEmployeenName(String employeenName) {
        this.employeenName = employeenName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeenName='" + employeenName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }
}
