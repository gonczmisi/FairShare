package hu.elte.fairshare.repository;

import hu.elte.fairshare.entities.Item;
import hu.elte.fairshare.utils.Currency;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class tests the ItemRepository classes functions, along with the
 * Item types basic functions.
 * @author sajtizsolt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryIntegrationTest {
    
    /**
     * The repository instance used for testing.
     */
    @Autowired
    ItemRepository itemRepository;
    
    /**
     * This test checks if the repository can create a new item and save it into
     * the database, and also deletes it.
     * @throws Exception
     */
    @Test
    public void newItem_SavedSuccesfullyAndDeleteSuccesful() throws Exception {
        Item item = new Item();
        item.setName("test_item");
        item.setPrice(200);
        item.setCurrencyType(Currency.HUF);
        
        
        itemRepository.save(item);
        Optional<Item> result = itemRepository.findByName("test_item");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_item", result.get().getName());

        itemRepository.delete(item);
        result = itemRepository.findByName("test_item");
        
        assertFalse(result.isPresent());
    }

    /**
     * This test checks if the created Item entity has the appropiate values,
     * and also deletes the item.
     * @throws Exception
     */
    @Test
    public void newItem_ValuesAreRightAndDeleteSuccesful() throws Exception {
        Item item = new Item();
        item.setName("test_item_values");
        item.setPrice(400);
        item.setCurrencyType(Currency.EUR);
        
        
        itemRepository.save(item);
        Optional<Item> result = itemRepository.findByName("test_item_values");
        
        assertTrue(result.isPresent());
        assertNotNull(result.get());
        assertEquals("test_item_values", result.get().getName());
        assertEquals(400, result.get().getPrice());
        assertEquals(Currency.EUR, result.get().getCurrencyType());

        itemRepository.delete(item);
        result = itemRepository.findByName("test_item_values");
        
        assertFalse(result.isPresent());
    }
}