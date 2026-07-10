package com.basanta.security.config;


import com.basanta.security.exception.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class ProjectSecurityConfigProd {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests)-> requests
                .requestMatchers("/api/**").authenticated()
                .requestMatchers("/notices", "/contacts", "/error", "/register").permitAll());
//        http.authorizeHttpRequests((requests)-> requests.anyRequest().denyAll());
//        http.authorizeHttpRequests((requests)-> requests.anyRequest().permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(hbc-> hbc.authenticationEntryPoint(new CustomAuthenticationEntryPoint()));
        return http.build();
    }

    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("user").password("{noop}Basanta@123").authorities("read").build();
//        UserDetails admin = User.withUsername("admin").password("{bcrypt}$2a$12$Skp74WcE42I8e9MlrWCaWuiQC.rSyOyyi60FFxs7WfSC7PAjcwe8i").authorities("admin").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
//
//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker(){
//        return new HaveIBeenPwnedRestApiPasswordChecker();
//    }
}
