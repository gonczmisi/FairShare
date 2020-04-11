package hu.elte.fairshare.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class tests the Receipt type's basic functions.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptUnitTest {

    /**
     * Tests the basic getters and setters.
     */
    @Test
    public void newReceipt_GettersAndSettersAreRight() {
        Receipt receipt = new Receipt();
        receipt.setName("RECEIPT");

        assertEquals("RECEIPT", receipt.getName());
    }

    /**
     * Tests the equals and hashCode methods.
     */
    @Test
    public void newReceipts_EqualsAndHashCodeAreRight() {
        Receipt receipt1 = new Receipt();
        receipt1.setName("RECEIPT");

        Receipt receipt2 = new Receipt();
        receipt2.setName("RECEIPT");

        assertTrue(receipt1.equals(receipt2));
        assertTrue(receipt2.equals(receipt1));
        assertEquals(receipt1.hashCode(), receipt2.hashCode());
    }
}