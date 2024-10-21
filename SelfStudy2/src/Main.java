import Entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        List<Employee> employees = new ArrayList<Employee>();

        do{
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("6.SORT-down to up");
            System.out.println("7.SORT- up to down");
            System.out.println("0.EXIT");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How many employees do you want to insert: ");
                    int n = sc.nextInt();

                    for(int i = 0; i < n; i++) {
                        System.out.println("Enter Employee No: ");
                        int empNo = sc.nextInt();
                        System.out.println("Enter Employee Name: ");
                        String empName = sc1.nextLine();
                        System.out.println("Enter Employee Salary: ");
                        int empSal = sc.nextInt();

                        employees.add(new Employee(empNo, empName, empSal));
                    }
                    break;
                case 2:
                    System.out.println(employees);
                    break;
                case 3:
                    System.out.println("Enter empno to Search: ");
                    int empNo = sc.nextInt();
                    Optional<Employee> employee = employees.stream()
                            .filter(emp -> emp.getEmpNo() == empNo)
                            .findFirst();
                    if(employee.isPresent()) {
                        System.out.println(employee);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter empno to Delete: ");
                    int empNo1 = sc.nextInt();
                    Optional<Employee> employee1 = employees.stream()
                            .filter(emp -> emp.getEmpNo() == empNo1)
                            .findFirst();
                    if(employee1.isPresent()) {
                        employees.remove(employee1.get());
                        System.out.println(employees);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter empno to Update: ");
                    int empNo2 = sc.nextInt();
                    Optional<Employee> employee2 = employees.stream()
                            .filter(emp -> emp.getEmpNo() == empNo2)
                            .findFirst();
                    if(employee2.isPresent()) {
                        int index = employees.indexOf(employee2.get());
                        System.out.println("Enter new employee name: ");
                        String eName = sc1.nextLine();

                        System.out.println("Enter new employee salary: ");
                        int eSal = sc.nextInt();
                        employees.set(index ,new Employee(employee2.get().getEmpNo(), eName, eSal));
                        System.out.println(employees);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 6:
                    List<Employee> employeeSort = employees.stream()
                            .sorted(Comparator.comparing(Employee::getSalary))
                            .toList();
                    System.out.println(employeeSort);
                    break;
                case 7:
                    List<Employee> employeeSort1 = employees.stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .toList();
                    System.out.println(employeeSort1);
                    break;
            }
        } while (choice != 0);
    }
}