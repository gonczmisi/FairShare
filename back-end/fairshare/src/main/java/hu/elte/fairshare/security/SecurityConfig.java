package hu.elte.fairshare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author mgoncz
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /**
                 * Provides logout support.
                 * This is automatically applied when using WebSecurityConfigurerAdapter.
                 */
                .logout()
                /** 
                 * The URL that triggers log out to occur (default is /logout).
                 * If CSRF protection is enabled (default), then the request must also be a POST.
                 */
                .logoutUrl("/logout")
                /**The URL to redirect to after logout has occurred.
                 * The default is /login?logout.
                 */
                .logoutSuccessUrl("/login")
                /**
                 * Specify whether to invalidate the HttpSession at the time of logout.
                 * This is true by default.
                 * Configures the SecurityContextLogoutHandler under the covers.
                 */
                .invalidateHttpSession(true) 
                    .and()
                .cors()
                    .and()
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/users/**").permitAll()
                    .antMatchers("/items/**").hasRole("USER")
                    .antMatchers("/receipts/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .headers()
                    .frameOptions().disable()
                    .and()
                .httpBasic()
                    .authenticationEntryPoint(getBasicAuthEntryPoint())
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
    }

    /* Working in memory authentication
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("ADMIN", "USER").build());
        return manager;
    }
    */
    
     
    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth
          .userDetailsService(userDetailsService)
          .passwordEncoder(passwordEncoder());
      System.out.println(passwordEncoder().encode("password"));
    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth
          .userDetailsService(userDetailsService)
          .passwordEncoder(passwordEncoder());
      System.out.println(passwordEncoder().encode("password"));
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public BasicEntryPoint getBasicAuthEntryPoint(){
        return new BasicEntryPoint();
    }
    
}
