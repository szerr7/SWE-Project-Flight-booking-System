package in.co.airline.ticket.airlineticket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ServiceRequestAppConfig implements WebMvcConfigurer {

	 @Autowired
	    ServiceRequestInterceptor sri;

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        String pathPattern = "/ctl/**";
	        registry.addInterceptor(sri).excludePathPatterns(pathPattern);
	    }
	
}
