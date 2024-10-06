package Controller;

import Entity.Account;
import Service.AccountService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountController {
    private List<Account> accounts;
    private AccountService as;

    public AccountController(AccountService as) {
        this.as = as;
    }

    public List<Account> sortCustomer() {
        List<Account> accounts1 = as.sortCustomer();
        return accounts1;
    }

    public Account getById(int id) {
        Account account = as.getById(id);

        if(account != null) {
            return account;
        }

        return null;
    }

    public List<Account> getByName(String name) {
        List<Account> accounts1 = as.getByName(name);
        return accounts1;
    }
}
