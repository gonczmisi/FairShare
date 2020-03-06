package hu.elte.fairshare.repository;

import hu.elte.fairshare.entities.Receipt;
import org.springframework.data.repository.CrudRepository;

/**
 * The ReceiptRepository interface extends the CrudRepository interface and creates
 * a container for the receipts.
 * 
 * @author sajtizsolt
 */
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
    
}