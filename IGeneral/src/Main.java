import Controller.AccountController;
import Controller.CustomerController;
import Controller.StaffController;
import Entity.Account;
import Entity.Customer;
import Entity.Staff;
import Service.AccountService;
import Service.CustomerService;
import Service.StaffService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Staff> staffs = new ArrayList<Staff>();
        List<Account> accounts = new ArrayList<Account>();

        CustomerService cs = new CustomerService(customers);
        StaffService ss = new StaffService(staffs);
        AccountService as = new AccountService(accounts);

        CustomerController customerController = new CustomerController(cs);
        StaffController staffController = new StaffController(ss);
        AccountController accountController = new AccountController(as);

        customers.add(new Customer(1,"VCB01", "Binh"));
        customers.add(new Customer(2,"TCB002","Minh"));

        staffs.add(new Staff(1, "SS001", "Ha", LocalDateTime.of(2005,11,22,0,0)));
        staffs.add(new Staff(2, "SC002", "Nam", LocalDateTime.of(2005,2,11,0,0)));

        accounts.add(new Account(1, "AC1023123" , 1000000, LocalDateTime.of(2024, 12, 22, 10, 12), customers.getFirst()));
        accounts.add(new Account(2, "BC1203123" , 100000, LocalDateTime.of(2024, 8, 10, 20, 10), customers.get(1)));

//        Customer cus = customerController.getById(3);
//        if(cus!=null){
//            System.out.println(cus);
//        }else{
//            System.out.println("Not Found");
//        }
//        Staff st = staffController.getStaffById(1);
//        System.out.println(st);
//        List<Account> ac = accountController.getAccountByCustomerName("binh");
//        System.out.println(ac);
    }
}