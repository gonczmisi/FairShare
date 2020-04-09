package hu.elte.fairshare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.fairshare.utils.Currency;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
@EqualsAndHashCode(doNotUseGetters = true)
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
    @Getter
    String name;
    
    /**
     * The price of the item.
     */
    @Column(
        name = "price",
        nullable = false)
    private Integer price;
    
    /**
     * The active currency of the item.
     */
    @Column(
        name = "currencyType",
        nullable = false,
        length = 5)
    @Enumerated(EnumType.STRING)
    private Currency currencyType;
    
    /**
     * The set of receipts attached to the item.
     */
    @ManyToMany
    @JoinTable(
        name = "items_receipts",
        joinColumns = @JoinColumn(name = "item_id"),
        inverseJoinColumns = @JoinColumn(name = "receipt_id"))
    @JsonIgnore
    private Set<Receipt> receipts;
    
    /**
     * Returns the name of the item.
     * @return The name of the item.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the price of the item.
     * @return The price of the item.
     */
    public int getPrice()
    {
        return this.price;
    }

    /**
     * Returns the currency type of the item.
     * @return The currency type of the item.
     */
    public Currency getCurrencyType()
    {
        return this.currencyType;
    }

    /**
     * The setter for name field.
     * @param name The new name of the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the item.
     * @param price The new price of the item.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the currency type of the item.
     * @param currency The new currency type of the item.
     */
    public void setCurrencyType(Currency currency) {
        this.currencyType = currency;
    }
}