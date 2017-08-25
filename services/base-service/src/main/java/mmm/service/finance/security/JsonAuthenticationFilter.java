package mmm.service.finance.security;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import mmm.service.finance.model.json.Login;

public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private boolean postOnly;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		if (postOnly && !request.getMethod().equals("POST")) {
	        throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
	    }
		UsernamePasswordAuthenticationToken authRequest = null;
		try {
			authRequest = this.getUserNamePasswordAuthenticationToken(request);
			setDetails(request, authRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	private UsernamePasswordAuthenticationToken getUserNamePasswordAuthenticationToken(HttpServletRequest request) throws IOException{
	
		StringBuffer sb = new StringBuffer();
	    BufferedReader bufferedReader = null;
	    String content = "";
	    Login sr = null;

	    try {
	        bufferedReader =  request.getReader();
	        char[] charBuffer = new char[128];
	        int bytesRead;
	        while ( (bytesRead = bufferedReader.read(charBuffer)) != -1 ) {
	            sb.append(charBuffer, 0, bytesRead);
	        }
	        content = sb.toString();
	        ObjectMapper objectMapper = new ObjectMapper();
	        try{
	            sr = objectMapper.readValue(content, Login.class);
	        }catch(Throwable t){
	            throw new IOException(t.getMessage(), t);
	        }
	    } catch (IOException ex) {

	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }
	    return new UsernamePasswordAuthenticationToken(sr.getLogin(), sr.getPassword());

	}

}
