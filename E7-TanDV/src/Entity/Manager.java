package Entity;

public class Manager extends Staff{
    private double allowance;

    public Manager(){;}
    public Manager(String name, double salary, double allowance){
        super(name,salary);
        this.allowance = allowance;
    }

    @Override
    public double getPaid() {
        return getSalary() + allowance;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "Name= " + this.getName() +
                ",Salary= " + this.getSalary() +
                ",Allowance= " + allowance +
                ",Paid= " + this.getPaid() +
                '}';
    }
}
