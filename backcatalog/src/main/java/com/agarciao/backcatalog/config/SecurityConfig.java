package com.agarciao.backcatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    //endpoints de administracion de ususarios
                    http.requestMatchers(HttpMethod.GET, "/auth/users/list").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.GET, "/auth/users/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/auth/users/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/users/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/users/delete/{id}").hasAnyRole("DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/marcas/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/marcas/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/auth/marcas/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/marcas/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/marcas/delete/{id}").hasAnyRole("DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/category/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/category/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.POST, "/auth/category/create").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.PUT, "/auth/category/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/category/delete/{id}").hasAnyRole("DEVELOPER");

                    http.requestMatchers(HttpMethod.GET, "/auth/model/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/model/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/model/create").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.PUT, "/auth/model/update/{id}").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/model/delete/{id}").hasAnyRole("DEVELOPER", "ADMIN");

                    http.requestMatchers(HttpMethod.GET, "/auth/diagram/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/diagram/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/diagram/create").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.PUT, "/auth/diagram/update/{id}").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/diagram/delete/{id}").hasAnyRole("DEVELOPER", "ADMIN");

                    http.requestMatchers(HttpMethod.GET, "/auth/item/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/item/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/item/create").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.PUT, "/auth/item/update/{id}").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/item/delete/{id}").hasAnyRole("DEVELOPER", "ADMIN");

                    http.requestMatchers(HttpMethod.GET, "/auth/vehicle/list").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.GET, "/auth/vehicle/{id}").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/auth/vehicle/create").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.PUT, "/auth/vehicle/update/{id}").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.DELETE, "/auth/vehicle/delete/{id}").hasAnyRole("DEVELOPER", "ADMIN");

                    http.anyRequest().denyAll();
                })
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
       // metodo de encriptacion de textos, se debe mejorar para configurar en cada password registrada
    }

}
