package hu.elte.fairshare.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * The Item class implements an item on a receipt.
 * 
 * @author sajtizsolt
 */
@Data
@Entity
@Table(
    name = "Item",
    schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    
    /**
     * The unique id of the receipt.
     */
    @Id
    @Column(
        name = "id",
        updatable = false,
        unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * The time the record was created.
     */
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    /**
     * The time the record was last updated.
     */
    @Column(
        name = "updated_at",
        nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    /**
     * The name of the item.
     */
    @Column(
        name = "name",
        nullable = false,
        length = 50)
    private String name;
    
    /**
     * The price of the item.
     */
    @Column(
        name = "price",
        nullable = false)
    private Integer price;
}