package co.com.poli.shopping.services;

import co.com.poli.shopping.client.CustomerClient;
import co.com.poli.shopping.client.ProductClient;
import co.com.poli.shopping.entities.Invoice;
import co.com.poli.shopping.entities.InvoiceItem;
import co.com.poli.shopping.model.Customer;
import co.com.poli.shopping.model.Product;
import co.com.poli.shopping.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
      invoiceRepository.delete(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice findByNumberInvoice(String numberInvoice) {
       Invoice invoice = invoiceRepository.findByNumberInvoice(numberInvoice);
       ModelMapper modelMapper = new ModelMapper();
        Customer customer  = modelMapper.map(customerClient.findById(invoice.getCustomerId()).getData(),Customer.class);
       //Customer customer  = (Customer)customerClient.findById(invoice.getCustomerId()).getData();
       invoice.setCustomer(customer);
       List<InvoiceItem> itemList = invoice.getItems().stream()
               .map( invoiceItem -> {
                   Product product = modelMapper.map(productClient.findById(invoiceItem.getProductId()).getData(),Product.class);
                //Product product = (Product)productClient.findById(invoiceItem.getProductId()).getData();
                invoiceItem.setProduct(product);
                return invoiceItem;
               }).collect(Collectors.toList());
        return invoiceRepository.findByNumberInvoice(numberInvoice);
    }
}
