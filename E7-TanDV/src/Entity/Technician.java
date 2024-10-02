package Entity;

public class Technician extends Staff {
    private double overtimePay;

    public Technician() {;}
    public Technician(String name, double salary, double overtimePay) {
        super(name, salary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double getPaid() {
        return getSalary() + overtimePay;
    };

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
        return "Technician{" +
                "Name= " + this.getName() +
                ",Salary= " + this.getSalary() +
                ",OvertimePay= " + overtimePay +
                ",Paid= " + this.getPaid() +
                '}';
    }
}
