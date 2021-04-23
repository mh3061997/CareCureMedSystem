package com.carecure.medsysten.security.config;


import com.carecure.medsysten.security.filters.jwtRequestFilter;
import com.carecure.medsysten.security.utils.jwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class webSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private com.carecure.medsysten.security.utils.jwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private com.carecure.medsysten.security.filters.jwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.csrf().disable()
                .cors().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers("/login", "/register").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/appointment").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.GET, "/patient").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.GET, "/doctor/speciality").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/utils/**").permitAll()

                .antMatchers("/servicePriceList/**").hasAnyAuthority("ADMIN")
                .antMatchers("/userDao/**").hasAnyAuthority("ADMIN")
                .antMatchers("/registerNonPatient").hasAnyAuthority("ADMIN")

                // all other requests need to be authenticated
                        .anyRequest().authenticated().and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
