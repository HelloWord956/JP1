import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        customers.add(new Customer(1, "Alice", 'F', 10));
        customers.add(new Customer(2, "Bob", 'M', 15));
        customers.add(new Customer(3, "Charlie", 'M', 20));
        customers.add(new Customer(4, "Olivia", 'F', 25));


        accounts.add(new Account(1, customers.get(0), 1500.20));
        accounts.add(new Account(2, customers.get(1), 2000.45));
        accounts.add(new Account(3, customers.get(2), 3355.16));
        accounts.add(new Account(4, customers.get(3), 4020.15));

        invoices.add(new Invoice(1, customers.get(0), 3000.0, LocalDate.of(2024, 3, 4)));
        invoices.add(new Invoice(2, customers.get(1), 300.0, LocalDate.of(2024, 1, 3)));
        invoices.add(new Invoice(3, customers.get(2), 450.0, LocalDate.of(2023, 9, 22)));
        invoices.add(new Invoice(4, customers.get(3), 500.0, LocalDate.of(2023, 7, 26)));

        System.out.println("Enter your choice(b - c - d - e - f):");

        Scanner scanner = new Scanner(System.in);
        CustomerController cc = new CustomerController(customers);
        AccountController ac = new AccountController(accounts);
        InvoiceController ic = new InvoiceController(invoices);

        char choice = scanner.next().toLowerCase().charAt(0);

        switch (choice) {
            case 'b':
                System.out.println("a.Sort by name - b.Sort by Account - c.Sort by invoice");
                choice = scanner.next().toLowerCase().charAt(0);
                if(choice == 'a') {
                    List<Customer> sortByName = cc.sortCustomerByName();
                    System.out.println(sortByName);
                }
                if(choice == 'b') {
                    List<Account> sortByAccount = ac.sortCustomerByAccount();
                    System.out.println(sortByAccount);
                }
                if(choice == 'c') {
                    List<Invoice> sortByInvoice = ic.sortCustomerByInvoice();
                    System.out.println(sortByInvoice);
                }
                break;
            case 'c':
                System.out.println("a.Find Account - b.Find Invoice");
                choice = scanner.next().toLowerCase().charAt(0);
                if(choice == 'a') {
                    System.out.println("a.Find by name - b.Find by id");
                    choice = scanner.next().toLowerCase().charAt(0);
                    if(choice == 'a') {
                        System.out.println("Enter your name:");
                        String name = scanner.next();
                        List<Account> searchByName = ac.searchAccountByName(name);
                        System.out.println(searchByName);
                    } else if (choice == 'b') {
                        System.out.println("Enter your account id:");
                        int id = scanner.nextInt();
                        Optional<Account> searchById = ac.searchAccountById(id);
                        System.out.println(searchById);
                    }
                } else if(choice == 'b') {
                    System.out.println("a.Find by name - b.Find by id");
                    choice = scanner.next().toLowerCase().charAt(0);
                    if(choice == 'a') {
                        System.out.println("Enter your name:");
                        String name = scanner.next();
                        List<Invoice> searchByName = ic.searchInvoiceByName(name);
                        System.out.println(searchByName);
                    } else if (choice == 'b') {
                        System.out.println("Enter your invoice id:");
                        int id = scanner.nextInt();
                        Optional<Invoice> searchById = ic.searchInvoiceById(id);
                        System.out.println(searchById);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                }
                break;
            case 'd':invoices.forEach(invoice -> {
                int customerId = invoice.getCustomerId();
                double amountAfterDiscount = invoice.getAmountAfterDiscount();

                accounts.stream()
                        .filter(account -> account.getCustomer().getId() == customerId)
                        .findFirst()
                        .ifPresent(account -> {
                            double accountBalance = account.getBalance();
                            double newBalance = accountBalance - amountAfterDiscount;
                            if(newBalance > 0) {
                                System.out.println("Customer: " + account.getCustomerName());
                                System.out.println("Invoice ID: " + invoice.getId());
                                System.out.println("Account ID: " + account.getId());
                                System.out.println("Amount after discount: " + amountAfterDiscount);
                                System.out.println("New account balance: " + newBalance);
                            }
                        });
            });
                break;

            case 'e':
                invoices.forEach(invoice -> {
                    int customerId = invoice.getCustomerId();
                    double invoiceAmount = invoice.getAmount();

                    accounts.stream()
                            .filter(account -> account.getCustomer().getId() == customerId)
                            .findFirst()
                            .ifPresent(account -> {
                                double accountBalance = account.getBalance();
                                double newBalance = accountBalance - invoiceAmount;
                                if(newBalance < 0) {
                                    System.out.println("Customer: " + account.getCustomerName());
                                    System.out.println("Invoice ID: " + invoice.getId());
                                    System.out.println("Account ID: " + account.getId());
                                    System.out.println("Amount: " + invoiceAmount);
                                    System.out.println("New account balance: " + newBalance);
                                }
                            });
                });
                break;
            case 'f':
//                invoices.forEach(invoice -> {
//                    int customerId = invoice.getCustomerId();
//                    double originalInvoiceAmount = invoice.getAmountAfterDiscount();
//                    int dateTimeInvalid = LocalDate.now().getYear() - invoice.getDateTime().getYear();
//
//                    Customer customer = customers.stream()
//                            .filter(c -> c.getId() == customerId)
//                            .findFirst()
//                            .orElse(null);
//
//                    double invoiceAmount = originalInvoiceAmount;
//                    if (customer != null && customer.getGender() == 'F' && dateTimeInvalid >= 1) {
//                        invoiceAmount *= 0.9;
//                    }
//
//                    accounts.stream()
//                            .filter(account -> account.getCustomer().getId() == customerId)
//                            .findFirst()
//                            .ifPresent(account -> {
//                                double accountBalance = account.getBalance();
//
//                                if (accountBalance >= invoiceAmount) {
//                                    System.out.println("Customer: " + account.getCustomerName());
//                                    System.out.println("Invoice ID: " + invoice.getId());
//                                    System.out.println("Account ID: " + account.getId());
//                                    System.out.println("Amount after discount: " + invoiceAmount);
//                                    System.out.println("New account balance: " + (accountBalance - invoiceAmount));
//                                }
//                            });
//                });
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}