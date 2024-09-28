package Controller;

import Entity.Gender;
import Entity.Staff;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StaffController {
    private static List<Staff> staffs;
    public StaffController(List<Staff> staffs) {
        StaffController.staffs = staffs;
    }
    public Optional<Staff> MaxSalary() {
        Optional<Staff> maxSalaryFemale = staffs.stream().
                filter(staff -> staff.getGender() == Gender.F).
                max(Comparator.comparing(Staff::getPay));
        return maxSalaryFemale;
    }

    public Optional<Staff> GetById(String id) {
        Optional<Staff> searchDataById = staffs.stream()
                .filter(staff -> staff.getid().equals(id)).findFirst();
        return searchDataById;
    }

    public List<Staff> GetByName(String name) {
        List<Staff> searchDataByName = staffs.stream()
                .filter(staff -> staff.getName().contains(name)).
                collect(Collectors.toList());
        return searchDataByName;
    }


}
