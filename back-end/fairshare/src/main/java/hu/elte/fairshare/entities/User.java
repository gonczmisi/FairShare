package hu.elte.fairshare.entities;

import hu.elte.fairshare.utils.UserRole;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * The User class implements the user of the application.
 * 
 * @author sajtizsolt
 */
@Data
@Entity
@Table(name = "User", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    
    /**
     * The unique id of the user.
     */
    @Id
    @Column(name = "id", updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * The time the record was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    /**
     * The time the record was last updated.
     */
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    /**
     * The username of the user.
     */
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    
    /**
     * The encrypted password of the user.
     */
    @Column(name = "password", nullable = false, length = 256)  
    private String password;
    
    /**
     * The unique email address of the user - one registrated user with one
     * email address at a time.
     */
    @Column(name = "email_address", nullable = false, length = 50, unique = true)
    private String emailAddress;
    
    /**
     * The role of the user.
     */
    @Column(name = "user_role", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}