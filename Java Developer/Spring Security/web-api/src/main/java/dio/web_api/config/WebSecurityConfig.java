package dio.web_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private SecurityDatabaseConfiguration securityDatabaseConfiguration;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(securityDatabaseConfiguration).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.builder()
                .username("maycon")
                .password("{noop}maycon123456")
                .roles("USER")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}manager123456")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(List.of(user, manager));
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        try {
            http
                    .authorizeHttpRequests(auth -> {
                                try {
                                    auth
                                            .requestMatchers("/").permitAll()
                                            .requestMatchers("/login").permitAll()
                                            .requestMatchers("/users").hasAnyRole("USER", "MANAGER")
                                            .requestMatchers("/managers").hasRole("MANAGER")
                                            .anyRequest().authenticated()
                                            .and()
                                            .httpBasic();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    );
        }catch (Exception e){
            e.printStackTrace();
        }

        return http.build();
    }

}
