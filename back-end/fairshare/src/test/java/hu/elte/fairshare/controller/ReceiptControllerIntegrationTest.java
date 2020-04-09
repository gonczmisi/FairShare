package hu.elte.fairshare.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hu.elte.fairshare.entities.Receipt;

/**
 * This class is used to test the REST functions of the Receipt type.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptControllerIntegrationTest {

    /**
     * The controller reference used for testing.
     */
    @Autowired
    ReceiptController receiptController;

    /**
     * Tests POST, GET and DELETE.
     */
    @Test
    public void newReceipt_CreatedAndRetrievedAndDeletedSuccesfully() {

        Receipt receipt = new Receipt();
        receipt.setName("SOMETHING");

        receiptController.post(receipt);
        Receipt result = receiptController.get(receipt.getId()).getBody();

        assertEquals(receipt, result);

        receiptController.delete(result.getId());
        result = receiptController.get(receipt.getId()).getBody();

        assertNull(result);
    }

    /**
     * Tests POST, GET, PUT and DELETE.
     */
    @Test
    public void existingReceipt_ModifiedAndRetrievedAndDeletedSuccesfully()
    {
        Receipt receipt = new Receipt();
        receipt.setName("SOMETHING");

        receiptController.post(receipt);
        Receipt result = receiptController.get(receipt.getId()).getBody();

        assertEquals(receipt, result);

        receipt.setName("MODIFIED");

        receiptController.put(receipt, result.getId(), receipt.getName());
        result = receiptController.get(receipt.getId()).getBody();

        assertEquals("MODIFIED", result.getName());

        receiptController.delete(result.getId());
        result = receiptController.get(receipt.getId()).getBody();

        assertNull(result);
    }
}