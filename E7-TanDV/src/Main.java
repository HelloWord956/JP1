import Entity.Staff;
import Entity.Manager;
import Entity.Technician;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Staff> staffs = new ArrayList<>();

        staffs.add(new Manager("John", 1000, 200));
        staffs.add(new Technician("Alice", 2000, 400));
        staffs.add(new Manager("Bob", 3000, 600));

        String staffName = getStaffNameFromUser();

        Optional<Staff> staffData = staffs.stream()
                .filter(s -> s.getName().toLowerCase().equalsIgnoreCase(staffName.toLowerCase()))
                .findFirst();

        if(staffData.isPresent()) {
            Staff foundStaff = staffData.get();
            System.out.println(foundStaff);
        } else {
            System.out.println("Not found staff " + staffName);
        }
    }

    private static String getStaffNameFromUser() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter staff name: ");
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

