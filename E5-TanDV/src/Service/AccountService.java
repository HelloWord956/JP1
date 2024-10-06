package Service;

import Entity.Account;
import IGeneral.IGeneral;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountService implements IGeneral {
    private List<Account> accounts;
    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public Account getById(int id) {
        Optional<Account> searchByAccountId = accounts.stream()
                .filter(account -> account.getId() == id)
                .findFirst();
        return searchByAccountId.orElse(null);
    }

    @Override
    public List<Account> getByName(String name) {
        return accounts.stream()
                .filter(account -> account.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> sortCustomer() {
        List<Account> sortByAccount = accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance))
                .collect(Collectors.toList());
        return sortByAccount;
    }
}
