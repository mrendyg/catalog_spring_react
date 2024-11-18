package com.agarciao.backcatalog.config;

<<<<<<< HEAD
import com.agarciao.backcatalog.service.user.UserDetailsServiceImpl;
=======
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
<<<<<<< HEAD
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
=======
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
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
<<<<<<< HEAD
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
=======
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
<<<<<<< HEAD
                .authorizeHttpRequests(
                    http -> {

                        http.requestMatchers(HttpMethod.GET, "/auth/users/list").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.GET, "/auth/users/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.POST, "/auth/users/create").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.PUT, "/auth/users/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.DELETE, "/auth/users/delete/{id}").hasAnyRole("DEVELOPER");

                        http.requestMatchers(HttpMethod.GET, "/auth/diagram/list").hasAnyAuthority("READ");
                        http.requestMatchers(HttpMethod.GET, "/auth/diagram/{id}").hasAnyAuthority("READ");
                        http.requestMatchers(HttpMethod.POST, "/auth/diagram/create").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.PUT, "/auth/diagram/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.DELETE, "/auth/diagram/delete/{id}").hasAnyRole("DEVELOPER");

                        http.requestMatchers(HttpMethod.GET, "/auth/concessionaire/list").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.GET, "/auth/concessionaire/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.POST, "/auth/concessionaire/create").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.PUT, "/auth/concessionaire/update/{id}").hasAnyRole("DEVELOPER", "ADMIN");
                        http.requestMatchers(HttpMethod.DELETE, "/auth/concessionaire/delete/{id}").hasAnyRole("DEVELOPER");


                        http.anyRequest().denyAll();
                    }
                )
=======
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
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
                .build();
    }

    @Bean
<<<<<<< HEAD
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
=======
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
<<<<<<< HEAD
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
=======
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

<<<<<<< HEAD
//        public static void main(String[] args){
//        System.out.println(new BCryptPasswordEncoder().encode("1234"));
////        metodo de encriptacion de textos, se debe mejorar para configurar en cada password registrada
//    }
=======
    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
       // metodo de encriptacion de textos, se debe mejorar para configurar en cada password registrada
    }
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e

}
