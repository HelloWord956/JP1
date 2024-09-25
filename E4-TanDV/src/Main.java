import Entity.Customer;
import Entity.Invoice;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        customers.add(new Customer(1, "John", 10));
        customers.add(new Customer(2, "Jane", 20));
        customers.add(new Customer(3, "Bob", 30));

        invoices.add(new Invoice(1, customers.get(0), 100));
        invoices.add(new Invoice(2, customers.get(0), 200));
        invoices.add(new Invoice(3, customers.get(1), 300));
        invoices.add(new Invoice(4, customers.get(1), 400));
        invoices.add(new Invoice(5, customers.get(2), 500));
        invoices.add(new Invoice(6, customers.get(2), 600));

        //Display info Invoice by ID of Customer
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of Customers : ");
        int customerId = sc.nextInt();

        List<Invoice> customerInvoices = invoices.stream()
                .filter(invoice -> invoice.getCustomer().getId() == customerId)
                .toList();

        if (customerInvoices.isEmpty()) {
            System.out.println("Not found Customer with ID " + customerId);
        } else {
            System.out.println("List of customer invoices: ");
            customerInvoices.forEach(System.out::println);
        }

        //Get Info of Customer has total getAmount() is MAX
        // Sử dụng Map để lưu tổng tiền của mỗi khách hàng
        Map<Customer, Double> totalAmounts = new HashMap<>();

        // Tính tổng tiền cho từng khách hàng
        invoices.forEach(invoice -> {
            Customer customer = invoice.getCustomer();
            double amount = invoice.getAmount();
            totalAmounts.put(customer, totalAmounts.getOrDefault(customer, 0.0) + amount);
        });

        // Tìm khách hàng có tổng số tiền lớn nhất
        Optional<Map.Entry<Customer, Double>> maxCustomerEntry = totalAmounts.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        // In ket qua
        if (maxCustomerEntry.isPresent()) {
            Customer maxCustomer = maxCustomerEntry.get().getKey();
            double maxAmount = maxCustomerEntry.get().getValue();

            System.out.println("Customer with max total amount is: " + maxCustomer.getName());
            System.out.println("Total amount is: " + maxAmount);
        }

        //Get info Customer has setDiscount is MIN
        Optional<Customer> minDiscountCustomer = customers.stream().
                min(Comparator.comparing(Customer::getDiscount));

        if (minDiscountCustomer.isPresent()) {
            Customer minDiscount = minDiscountCustomer.get();
            System.out.println("\nCustomer with min discount is: " + minDiscount.getName());
            System.out.println("Discount is: " + minDiscount.getDiscount());
        }

        //Search and display Customer via Invoice(Id) or Customer(Name)
        System.out.println("\nTìm kiếm theo (1) ID hóa đơn hay (2) Tên khách hàng?");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            // Tìm kiếm theo ID hóa đơn
            System.out.print("Nhập ID hóa đơn: ");
            int invoiceId = sc.nextInt();

            Optional<Invoice> foundInvoice = invoices.stream()
                    .filter(invoice -> invoice.getId() == invoiceId)
                    .findFirst();

            if (foundInvoice.isPresent()) {
                Customer customer = foundInvoice.get().getCustomer();
                System.out.println("Khách hàng của hóa đơn ID " + invoiceId + ": " + customer.getName());
            } else {
                System.out.println("Không tìm thấy hóa đơn với ID: " + invoiceId);
            }

        } else if (choice == 2) {
            // Tìm kiếm theo tên khách hàng
            System.out.print("Nhập tên khách hàng: ");
            String customerName = sc.nextLine();

            Optional<Customer> foundCustomer = customers.stream()
                    .filter(customer -> customer.getName().equalsIgnoreCase(customerName))
                    .findFirst();

            if (foundCustomer.isPresent()) {
                System.out.println("Khách hàng tìm thấy: " + foundCustomer.get().getName());
            } else {
                System.out.println("Không tìm thấy khách hàng với tên: " + customerName);
            }

        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }

        sc.close();
    }
}