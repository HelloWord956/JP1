package Service;

import Entity.Customer;
import Entity.Invoice;
import IGeneral.IGeneral;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceService implements IGeneral<Invoice> {
    private List<Invoice> invoices;
    private List<Customer> customers;
    public InvoiceService(List<Invoice> invoices, List<Customer> customers) {
        this.invoices = invoices;
        this.customers = customers;
    }

    @Override
    public Invoice getById(int id) {
        Optional<Invoice> searchById = invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst();
        return searchById.orElse(null);
    }

    @Override
    public List<Invoice> getByName(String name) {
        List<Invoice> searchByName = invoices.stream()
                .filter(invoice -> invoice.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return searchByName;
    }

    @Override
    public List<Invoice> sortCustomer() {
        List<Invoice> sortByInvoice = invoices.stream()
                .sorted(Comparator.comparing(Invoice::getAmount))
                .collect(Collectors.toList());
        return sortByInvoice;
    }

    public void invoiceDiscountForFemale() {
        invoices.forEach(invoice -> {
            int customerId = invoice.getCustomerId();
            double originalInvoiceAmount = invoice.getAmountAfterDiscount();

            Customer customer = customers.stream()
                    .filter(c -> c.getId() == customerId)
                    .findFirst()
                    .orElse(null);

            if (customer != null && customer.getGender() == 'F' && invoice.getDateTime().getMonthValue() == 8) {
                originalInvoiceAmount *= 0.9;
                invoice.setAmount(originalInvoiceAmount);
            }
        });
    }

}
