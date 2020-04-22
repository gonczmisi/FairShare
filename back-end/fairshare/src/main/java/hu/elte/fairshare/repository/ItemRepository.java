package hu.elte.fairshare.repository;

import hu.elte.fairshare.entities.Item;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * The ItemRepository interface extends the CrudRepository interface and creates
 * a container for the items.
 *
 * @author sajtizsolt
 */
public interface ItemRepository extends CrudRepository<Item, Long> {

    /**
     * The findByName method is searching for the item by the given name.
     *
     * @param name The name of the item being searched.
     * @return Item The item with the given name.
     */
    Optional<Item> findByName(String name);
}
