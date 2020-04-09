package hu.elte.fairshare.security;

import hu.elte.fairshare.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * This class implements the authenticated user, 
 * who is currently authenticated to the application.
 * @author mgoncz
 */
@RequestScope
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {
    
    private User user;
}