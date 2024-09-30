package Controller;

import Entity.Account;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountController {
    private List<Account> accounts;
    public AccountController(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> sortCustomerByAccount() {
        List<Account> sortByAccount = accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance))
                .collect(Collectors.toList());
        return sortByAccount;
    }

    public Optional<Account> searchAccountById(int id) {
        Optional<Account> searchById = accounts.stream()
                .filter(account -> account.getId() == id)
                .findFirst();

        if(searchById.isEmpty()) {
            System.out.println("Not found!");
        }
        return searchById;
    }

    public List<Account> searchAccountByName(String name) {
        List<Account> searchByName = accounts.stream()
                .filter(account -> account.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if(searchByName.isEmpty()) {
            System.out.println("Not found!");
        }
        return searchByName;
    }
}
