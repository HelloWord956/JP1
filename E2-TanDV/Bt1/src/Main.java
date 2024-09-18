import Entity.Employee;

public class Main {
    public static void main(String[] args) {
//        Employee employee1 = new Employee(8, "Peter", "Tan", 2500);
        // Tạo mảng 3 đối tượng
        Employee[] employees = new Employee[3];

        // Thêm dữ liệu vào mảng
        employees[0] = new Employee(1, "Peter", "Tan", 3000);
        employees[1] = new Employee(2, "Mike", "Jelly", 10000);
        employees[2] = new Employee(3, "Henry", "Wolf", 5000);
        Employee highestPaidEmployee = employees[0]; // Giả định nhân viên đầu tiên là người có mức lương cao nhất

        // display employee list
        System.out.println("Employee list:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // display employee get annual max salary
        for (Employee employee : employees) {
            if (employee.getAnnualSalary() > highestPaidEmployee.getAnnualSalary()){
                highestPaidEmployee = employee;
            }
        }
        System.out.println("\nEmployee get annual max salary is: ");
        System.out.println(highestPaidEmployee.getFirstName() + " " + highestPaidEmployee.getLastName() + " with " + highestPaidEmployee.getAnnualSalary());
    }
}