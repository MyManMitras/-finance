package mmm.service.finance.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint{
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpAuthenticationEntryPoint.class);
	
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {
    	
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        LOGGER.info("I got is entry point ");
    }

}
