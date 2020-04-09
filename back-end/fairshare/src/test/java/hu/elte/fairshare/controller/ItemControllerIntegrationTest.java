package hu.elte.fairshare.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import hu.elte.fairshare.entities.Item;
import hu.elte.fairshare.utils.Currency;

/**
 * This class is used to test the REST functions of the Item type.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerIntegrationTest {

    /**
     * The controller reference used for testing.
     */
    @Autowired
    ItemController itemController;

    /**
     * Tests POST, GET and DELETE.
     */
    @Test
    public void newItem_CreatedAndRetrievedAndDeletedSuccesfully() {

        Item item = new Item();
        item.setName("SOMETHING");
        item.setPrice(100);
        item.setCurrencyType(Currency.HUF);

        itemController.post(item);
        Item result = itemController.get(item.getId()).getBody();

        assertEquals(item, result);

        itemController.delete(result.getId());
        result = itemController.get(item.getId()).getBody();

        assertNull(result);
    }

    /**
     * Tests POST, GET, PUT and DELETE.
     */
    @Test
    public void existingItem_ModifiedAndRetrievedAndDeletedSuccesfully()
    {
        Item item = new Item();
        item.setName("SOMETHING");
        item.setPrice(100);
        item.setCurrencyType(Currency.HUF);

        itemController.post(item);
        Item result = itemController.get(item.getId()).getBody();

        assertEquals(item, result, result.getName());

        item.setName("MODIFIED");

        itemController.put(item, result.getId(), item.getName());
        result = itemController.get(item.getId()).getBody();

        assertEquals("MODIFIED", result.getName());

        itemController.delete(result.getId());
        result = itemController.get(item.getId()).getBody();

        assertNull(result);
    }
}