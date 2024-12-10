package com.agarciao.backcatalog.config;

import com.agarciao.backcatalog.config.filter.JwtTokenValidator;
import com.agarciao.backcatalog.service.user.UserDetailsServiceImpl;
import com.agarciao.backcatalog.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@CrossOrigin
public class SecurityConfig {

    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
            .csrf(csrf -> csrf.disable())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(
                http -> {

                    //Endpoints
                    http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();

                    http.requestMatchers(HttpMethod.GET, "/auth/users/list").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.GET, "/auth/users/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/auth/users/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/users/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/users/delete/{id}").hasAnyRole("DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/concessionaire/list").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.GET, "/auth/concessionaire/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/auth/concessionaire/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/concessionaire/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/concessionaire/delete/{id}").hasAnyRole("DEVELOPER", "ADMIN");

                    http.requestMatchers(HttpMethod.GET, "/auth/brand/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/brand/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/brand/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/brand/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/brand/delete/{id}").hasRole("DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/category/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/category/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/category/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/brand/category/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/category/delete/{id}").hasRole("DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/diagram/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/diagram/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/diagram/create").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.PUT, "/auth/brand/update/{id}").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/diagram/delete/{id}").hasAuthority("DELETE");

                    http.requestMatchers(HttpMethod.GET, "/auth/item/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/item/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/item/create").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.PUT, "/auth/item/update/{id}").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/item/delete/{id}").hasAnyRole("ADMIN", "DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/model/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/model/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/model/create").hasAnyRole("ADMIN", "DEVELOPER");
                    http.requestMatchers(HttpMethod.PUT, "/auth/model/update/{id}").hasAnyRole("ADMIN", "DEVELOPER");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/model/delete/{id}").hasAnyRole("ADMIN", "DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/vehicle/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/vehicle/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/vehicle/create").hasAnyRole("ADMIN", "DEVELOPER");
                    http.requestMatchers(HttpMethod.PUT, "/auth/vehicle/update/{id}").hasAnyRole("ADMIN", "DEVELOPER");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/vehicle/delete/{id}").hasAnyRole("ADMIN", "DEVELOPER");

                    http.anyRequest().denyAll();
                }
            )
            .formLogin(Customizer.withDefaults())
            .oauth2Client(Customizer.withDefaults())
            .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//        public static void main(String[] args){
//        System.out.println(new BCryptPasswordEncoder().encode("1234"));
////        metodo de encriptacion de textos, se debe mejorar para configurar en cada password registrada
//    }



}