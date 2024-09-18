package Entity;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private int annualSalary;

    //Constructor
    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getAnnualSalary(){
        return this.annualSalary = salary * 12;
    }

    public int raiseSalary(int percent){
        return this.salary = salary * percent / 100;
    }

    public String toString(){
        return "[Id: " + this.getId() +
                ",Name: " + this.getFirstName() + " " + this.getLastName() +
                ",Salary: " + this.getSalary() +
                "]";
    }
}
