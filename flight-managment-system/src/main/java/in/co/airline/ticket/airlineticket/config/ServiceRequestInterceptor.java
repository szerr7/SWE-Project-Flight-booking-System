package in.co.airline.ticket.airlineticket.config;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sun.istack.Nullable;

@Component
public class ServiceRequestInterceptor extends HandlerInterceptorAdapter {

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

	        return true;
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex){
	         // Some useful techniques
	    }
	
}
