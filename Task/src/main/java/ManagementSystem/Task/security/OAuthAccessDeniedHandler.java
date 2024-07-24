package ManagementSystem.Task.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ManagementSystem.Task.response.ErrorResponse;
@Component
public class OAuthAccessDeniedHandler implements AccessDeniedHandler{

	  @Autowired
	    ObjectMapper mapper;
	  
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 ServletServerHttpResponse res = new ServletServerHttpResponse(response);
	        res.setStatusCode(HttpStatus.UNAUTHORIZED);
	        res.getServletResponse().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	        res.getBody().write(mapper.writeValueAsString(new ErrorResponse("You must provide valid credentials")).getBytes());
	}

}
