package Controller;

import Entity.Invoice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceController {
    public static List<Invoice> invoices;
    public InvoiceController(List<Invoice> invoices) {
        InvoiceController.invoices = invoices;
    }

    public static List<Invoice> sortCustomerByInvoice() {
        List<Invoice> sortByInvoice = invoices.stream()
                .sorted(Comparator.comparing(Invoice::getAmount))
                .collect(Collectors.toList());
        return sortByInvoice;
    }

    public static Optional<Invoice> searchInvoiceById(int id) {
        Optional<Invoice> searchById = invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst();

        if(searchById.isEmpty()) {
            System.out.println("Not found!");
        }
        return searchById;
    }

    public static List<Invoice> searchInvoiceByName(String name) {
        List<Invoice> searchByName = invoices.stream()
                .filter(invoice -> invoice.getCustomerName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());

        if (searchByName.isEmpty()) {
            System.out.println("Not found!");
        }
        return searchByName;
    }
}
