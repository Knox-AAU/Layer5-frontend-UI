package knox.frontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobalSecurity( final AuthenticationManagerBuilder auth)
            throws Exception {
        System.out.println("GlobalSecurity");
        auth.inMemoryAuthentication().withUser("both").password("both").roles("NordjyskeUser","GrundfosUser", "ADMIN")
       .and().withUser("grundfos").password("grundfos").roles("GrundfosUser")
       .and().withUser("nordjyske").password("nordjyske").roles("NordjyskeUser");
    }

    @Override
    protected void configure( HttpSecurity http) throws Exception {
        System.out.println("Security configure");
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/grundfos","/grundfos/search").hasRole("GrundfosUser")
                .antMatchers("/nordjyske", "/nordjyske/search").hasRole("NordjyskeUser")
                .antMatchers("/Neutral").permitAll()

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
        // not implemented yet
        return null;
    }
    public LogoutSuccessHandler LogoutHandler(){
        // not implemented yet
        return null;
    }
}
