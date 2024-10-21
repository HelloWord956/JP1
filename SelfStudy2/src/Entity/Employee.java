package Entity;

public class Employee {
    private int empNo;
    private String eName;
    private int salary;

    public Employee() {;}

    public Employee(int empNo, String eName, int salary) {
        this.empNo = empNo;
        this.eName = eName;
        this.salary = salary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", salary=" + salary +
                '}' + "\n";
    }
}
