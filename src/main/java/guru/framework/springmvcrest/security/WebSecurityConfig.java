package guru.framework.springmvcrest.security;

import guru.framework.springmvcrest.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;


@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                        .allowedHeaders("*");
                registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("*");
            }
        };
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        String admin="admin";

        httpSecurity
                .csrf().disable().cors().and()
                .authorizeRequests()// Enabling URL to be accessed by all users (even un-authenticated)
                .antMatchers("/admin_ui/authenticate/signin").permitAll().

                antMatchers("/admin_ui/users").permitAll().

                antMatchers("/admin_ui/users/{id}").permitAll().
                antMatchers("/websocket-chat").permitAll().
                antMatchers("/websocket-chat/user-all").permitAll().
                antMatchers("/websocket-chat/topic/user").permitAll().
                antMatchers("/websocket-chat/*").permitAll().
                antMatchers("/websocket-chat/**").permitAll().

                antMatchers("/admin_ui/restaurants/mockRestaurant").hasAuthority(admin).

                antMatchers("/admin_ui/restaurants").permitAll().
                antMatchers("/admin_ui/restaurants/top-rated").permitAll().
                antMatchers("/admin_ui/restaurants/{id}").permitAll().

                antMatchers("/admin_ui/roles").hasAuthority(admin).
                antMatchers("/admin_ui/profiles").permitAll().

                antMatchers("/admin_ui/orders").permitAll().
                antMatchers("/admin_ui/orders/{id}").permitAll().
                antMatchers("/admin_ui/restaurants/view-restaurant/{id}").permitAll().

                antMatchers("/admin_ui/{userRole}").hasAuthority(admin).
                antMatchers("/admin_ui/{userRole}/{id}").hasAuthority(admin).


                anyRequest()
                .authenticated()// Any resources not mentioned above needs to be authenticated
                .and().sessionManagement()

                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//not to create a session
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}