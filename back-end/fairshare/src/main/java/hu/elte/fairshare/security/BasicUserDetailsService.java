package hu.elte.fairshare.security;

import hu.elte.fairshare.entities.User;
import hu.elte.fairshare.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mgoncz
 */
@Service
public class BasicUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    
    @Autowired 
    private AuthenticatedUser authenticatedUser;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> oUser = userRepository.findByUsername(username);
        if (!oUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        User user = oUser.get();
        authenticatedUser.setUser(user);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
