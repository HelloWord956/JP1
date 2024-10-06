package Controller;

import Entity.Invoice;
import Service.InvoiceService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceController {
    public static List<Invoice> invoices;
    private InvoiceService is;

    public InvoiceController(InvoiceService is) {
        this.is = is;
    }

    public List<Invoice> sortCustomer() {
        List<Invoice> invoices1 = is.sortCustomer();
        return invoices1;
    }

    public Invoice getById(int id) {
        Invoice invoice = is.getById(id);

        if(invoice != null) {
            return invoice;
        }
        return null;
    }

    public List<Invoice> getByName(String name) {
        List<Invoice> invoices1 = is.getByName(name);
        return invoices1;
    }
}
