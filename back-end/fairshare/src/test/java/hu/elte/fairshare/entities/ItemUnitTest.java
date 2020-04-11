package hu.elte.fairshare.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import hu.elte.fairshare.utils.Currency;

/**
 * This class tests the Item types basic functions.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUnitTest {

    /**
     * Tests the basic getters and setters.
     */
    @Test
    public void newItem_GettersAndSettersAreRight() {
        Item item = new Item();
        item.setName("ITEM");
        item.setPrice(10000);
        item.setCurrencyType(Currency.USD);

        assertEquals("ITEM", item.getName());
        assertEquals(10000, item.getPrice());
        assertEquals(Currency.USD, item.getCurrencyType());
    }

    /**
     * Tests the equals and hashCode methods.
     */
    @Test
    public void newItems_EqualsAndHashCodeAreRight() {
        Item item1 = new Item();
        item1.setName("ITEM");
        item1.setPrice(10000);
        item1.setCurrencyType(Currency.USD);

        Item item2 = new Item();
        item2.setName("ITEM");
        item2.setPrice(10000);
        item2.setCurrencyType(Currency.USD);

        assertTrue(item1.equals(item2));
        assertTrue(item2.equals(item1));
        assertEquals(item1.hashCode(), item2.hashCode());
    }
}