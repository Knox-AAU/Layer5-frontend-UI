package knox.frontend.configs;

import knox.frontend.Interceptors.AuthenticatorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Autowired
    private AuthenticatorInterceptor authenticatorInterceptor;

    @Override
    public void addInterceptors (InterceptorRegistry registry){
        System.out.println("Interceptor");
        registry.addInterceptor(authenticatorInterceptor);
    }
}
