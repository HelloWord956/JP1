package Controller;

import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountController {
    private List<Account> accounts;
    private AccountService as;

    public AccountController(AccountService as) {
        this.as = as;
    }

    public List<Account> getAccountByCustomerCode(String code) {
        accounts = as.getAccountByCustomerCode(code);
        return accounts;
    }

    public List<Account> getAccountByCustomerName(String name) {
        accounts = as.getAccountByCustomerName(name);
        return accounts;
    }

    public List<Account> getAccountByCustomer() {
        accounts = as.getAccountByCustomer();
        return accounts;
    }

    public List<Account> countAccountByCustomer() {
        accounts = as.countAccountByCustomer();
        return accounts;
    }

    public Account getMaxBalance() {
        Account account = as.getMaxBalance();
        return account;
    }
}
