package Controller;

import Entity.Staff;
import Service.StaffService;

import java.security.AllPermission;
import java.util.List;

public class StaffController {
    private List<Staff> staffs;
    private StaffService ss;

    public StaffController(StaffService ss) {
        this.ss = ss;
    }

    public Staff getStaffById(int id) {
        Staff staff = ss.getById(id);
        return staff;
    }

    public Staff getStaffByCode(String code) {
        Staff staff = ss.getByCode(code);
        return staff;
    }
}
