package co.com.poli.shopping.repositories;

import co.com.poli.shopping.entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {

}
