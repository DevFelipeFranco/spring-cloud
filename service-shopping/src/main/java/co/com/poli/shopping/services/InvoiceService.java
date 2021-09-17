package co.com.poli.shopping.services;

import co.com.poli.shopping.entities.Invoice;

import java.util.List;

public interface InvoiceService {

    void save(Invoice invoice);
    void delete(Invoice invoice);
    List<Invoice> findAll();
    Invoice findById(Long id);
    Invoice findByNumberInvoice(String numberInvoice);

}
