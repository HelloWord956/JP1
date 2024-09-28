import Controller.StaffController;
import Controller.StudentController;
import Entity.Gender;
import Entity.Staff;
import Entity.Student;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("C2309G5971", "Hai", LocalDate.of(2001, 05, 24), Gender.M, "Ha Noi"));
//        students.add(new Student("C2309G5972", "Dung", LocalDate.of(2004, 07, 12), Gender.O, "Bac Ninh"));
//        students.add(new Student("C2309G5973", "Linh", LocalDate.of(2006, 12, 25), Gender.F, "Ninh Binh"));
//
////        students.forEach(System.out::println);
//        StudentController sc = new StudentController(students);
//        Optional<Student> studentYoungest = sc.getYoungest();
//        System.out.println(studentYoungest);
//        System.out.println("\nYour search:");
//        StudentController.getByName("D").forEach(System.out::println);
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("C101", "Aptech", "Nam", "Ha Noi", Gender.M, LocalDate.of(2022, 6, 24), 2000));
        staffs.add(new Staff("C84", "Bach Khoa", "Le", "Bac Ninh", Gender.F, LocalDate.of(2020, 11, 10), 4000));
        staffs.add(new Staff("C73", "Gtvt", "Ha", "Bac Giang", Gender.F, LocalDate.of(2020, 11, 15), 5000));
        staffs.add(new Staff("C105", "Aptech", "Nguyet", "Ha Noi", Gender.F, LocalDate.of(2022, 9, 13), 2000));
        staffs.add(new Staff("C112", "Ngoai Thuong", "Toan", "Ha Noi", Gender.M, LocalDate.of(2023, 12, 24), 1800));

        StaffController sc = new StaffController(staffs);
        Optional<Staff> maxSalaryFemale = sc.MaxSalary();
        System.out.println(maxSalaryFemale);

        //Search By Id
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter the id of the staff: ");
        String id = scanner.nextLine();
        Optional<Staff> searchDataById = sc.GetById(id);
        if (searchDataById.isPresent()) {
            System.out.println(searchDataById);
        } else {
            System.out.println("Not found staff with id " + id);
        }

        //Search By Name
        System.out.println("\nPlease enter the name of the staff: ");
        String name = scanner.nextLine();
        List<Staff> searchDataByName = sc.GetByName(name);
        if (searchDataByName.size() > 0) {
            System.out.println(searchDataByName);
        } else {
            System.out.println("Staff not found");
        }

        //Rename Staff
        System.out.println("\nPlease enter the name of the staff you want to rename: ");
        String oldName = scanner.nextLine();
        List<Staff> reNameStaff = sc.GetByName(oldName);
        System.out.println("\nEnter the new name of the staff: ");
        String newName = scanner.nextLine();
        if (reNameStaff.size() > 0) {
            reNameStaff.get(0).changeName(newName);
            System.out.println(reNameStaff);
        } else {
            System.out.println("Cannot rename staff");
        }
    }
}