package Service;

import Entity.Account;
import Entity.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private List<Account> accounts;
    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccountByCustomerCode(String code) {
        List<Account> accountByCustomer = accounts.stream()
                .filter(a -> a.getCustomer().getCode().equalsIgnoreCase(code))
                .toList();
        return accountByCustomer;
    }

    public List<Account> getAccountByCustomerName(String keyword) {
        List<Account> accountsByCustomer  = accounts.stream()
                .filter(a -> a.getCustomer().getName().equalsIgnoreCase(keyword))
                .toList();
        return accountsByCustomer;
    }

    public List<Account> getAccountByCustomer() {
        List<Account> accountByCustomer = accounts.stream()
                .filter(a -> a.getCustomer().getGender().equals(Gender.M) && a.getBalance() > 1000000)
                .toList();
        return accountByCustomer;
    }

    public List<Account> countAccountByCustomer() {
        List<Account> accountByCustomer = accounts.stream()
                .filter(a -> a.getCustomer().getGender().equals(Gender.F) && a.getBalance() > 100000)
                .toList();
        return accountByCustomer;
    }

    public Account getMaxBalance() {
        Optional<Account> maxAccount = accounts.stream()
                .filter(a -> a.getCustomer().getGender().equals(Gender.F))
                .max(Comparator.comparing(Account::getBalance));
        return maxAccount.orElse(null);
    }
}
