package knox.frontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// Most of this class is based on: https://www.baeldung.com/spring-security-login
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static class ROLES {
        public final static String ADMIN = "ADMIN";
        public final static String NORDJYSKE = "NordjyskeUser";
        public final static String GRUNDFOS = "GrundfosUser";
    }

    @Autowired
    public void configureGlobalSecurity( final AuthenticationManagerBuilder auth) // This is where to create users, each with a "WithUser()" statement
            throws Exception {
        System.out.println("GlobalSecurity");
        auth.inMemoryAuthentication().withUser("both").password("both").roles(ROLES.ADMIN, ROLES.GRUNDFOS,ROLES.NORDJYSKE)
       .and().withUser("grundfos").password("grundfos").roles(ROLES.GRUNDFOS)
       .and().withUser("nordjyske").password("nordjyske").roles(ROLES.NORDJYSKE);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/publics/**");
    }


    @Override
    protected void configure( HttpSecurity http) throws Exception { // This is where to create security protocols
        System.out.println("Security configure");
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/Neutral").permitAll()
                .antMatchers("/grundfos","/grundfos/search").hasRole(ROLES.NORDJYSKE)
                .antMatchers("/nordjyske", "/nordjyske/search").hasRole(ROLES.GRUNDFOS)

                .anyRequest().authenticated()

                .and()                      // and() seems to break passages apart, distincting them from eachother
                .formLogin()
                .loginPage("/Neutral")                      //Link to the view used as login
                .loginProcessingUrl("/Neutral")           // The url, which handles login
                .defaultSuccessUrl("/")
                .failureUrl("/Neutral")
                .failureHandler(FailureHandler());

/*              Since no Logout functionality is currently in place, this part of the code crashes it.
                .and()
                .logout() // Currently not implemented
                .logoutUrl("/Logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(LogoutHandler());
*/
    }

    public AuthenticationFailureHandler FailureHandler(){
        return null;

        // not implemented yet
    }
    public LogoutSuccessHandler LogoutHandler(){
        // not implemented yet
        return null;
    }
}
