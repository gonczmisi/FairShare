package hu.elte.fairshare.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * This class implements a basic entry point.
 * Once a user agent is authenticated using BASIC authentication,
 * logout requires that the browser be closed or an unauthorized (401) header be sent.
 * The simplest way of achieving the latter is to call the
 * commence(HttpServletRequest, HttpServletResponse, AuthenticationException) method below.
 * This will indicate to the browser its credentials are no longer authorized,
 * causing it to prompt the user to login again.
 * @author mgoncz
 */
public class BasicEntryPoint extends BasicAuthenticationEntryPoint {
    
    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, 
    		final AuthenticationException authException) throws IOException, ServletException {
    	
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
         
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
    }
     
    @Override
    public void afterPropertiesSet() throws Exception {
    	
        setRealmName("FairShare");
        super.afterPropertiesSet();
    }
}
