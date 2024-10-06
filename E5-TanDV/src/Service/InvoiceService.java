package Service;

import Entity.Invoice;
import IGeneral.IGeneral;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceService implements IGeneral {
    private List<Invoice> invoices;
    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
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
}
