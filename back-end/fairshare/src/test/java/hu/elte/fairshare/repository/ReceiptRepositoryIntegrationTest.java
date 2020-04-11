package hu.elte.fairshare.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hu.elte.fairshare.entities.Receipt;

/**
 * This class tests the ReceiptRepository classes' functions, along with the
 * Item types basic functions.
 * 
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptRepositoryIntegrationTest {

    /**
     * The repository instance used for testing.
     */
    @Autowired
    ReceiptRepository receiptRepository;
    
    /**
     * This test checks if the repository can create a new receipt and save it into
     * the database, and also deletes it.
     * @throws Exception
     */
    @Test
    public void newReceipt_SavedSuccesfullyAndDeleteSuccesful() throws Exception {
        Receipt receipt = new Receipt();
        receipt.setName("test_receipt");
        
        receiptRepository.save(receipt);
        Optional<Receipt> result = receiptRepository.findByName("test_receipt");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_receipt", result.get().getName());

        receiptRepository.delete(receipt);
        result = receiptRepository.findByName("test_receipt");
        
        assertFalse(result.isPresent());
    }

    /**
     * This test checks if the created Receipt entity has the appropiate values,
     * and also deletes the item.
     * @throws Exception
     */
    @Test
    public void newReceipt_ValuesAreRightAndDeleteSuccesful() throws Exception {
        Receipt receipt = new Receipt();
        receipt.setName("test_receipt_values");
        
        receiptRepository.save(receipt);
        Optional<Receipt> result = receiptRepository.findByName("test_receipt_values");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_receipt_values", result.get().getName());

        receiptRepository.delete(receipt);
        result = receiptRepository.findByName("test_receipt_values");
        
        assertFalse(result.isPresent());
    }
}