package hu.elte.fairshare.controller;

import hu.elte.fairshare.entities.Item;
import hu.elte.fairshare.repository.ItemRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ItemController class implements a REST controller which can handle
 * get, post, put, delete requests.
 * 
 * @author sajtizsolt
 */
@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {
    
    /**
     * The repository instance of the controller.
     */
    @Autowired
    private ItemRepository itemRepository;
    
    /**
     * The getAll method returns all of the data from the table.
     * @return All data from the items table.
     */
    @GetMapping("")
    public ResponseEntity<Iterable<Item>> getAll() {
        return ResponseEntity.ok(itemRepository.findAll());
    }
    
    /**
     * The get method returns the item with the given id.
     * @param id The id of the item.
     * @return The item with the given id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The post method puts a new record into the table.
     * @param item The item we want to add to the table.
     * @return The new item instance.
     */
    @PostMapping("")
    public ResponseEntity<Item> post(@RequestBody Item item) {
        Item newItem = itemRepository.save(item);
        return ResponseEntity.ok(newItem);
    }
    
    /**
     * The put method sets the id of the given item to the given id.
     * @param item The item we want to update.
     * @param id The id of the item.
     * @param name The new name of the item.
     * @return The updated item instance.
     */
    @PutMapping("/{name}")
    public ResponseEntity<Item> put(@RequestBody Item item, @PathVariable Long id, @PathVariable String name) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            item.setName(name);
            return ResponseEntity.ok(itemRepository.save(item));
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * The delete method deletes an item from the table given by id.
     * @param id The id of the item.
     * @return The deleted item instance.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            itemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}