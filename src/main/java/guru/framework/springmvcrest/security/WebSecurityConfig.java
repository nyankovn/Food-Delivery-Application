package guru.framework.springmvcrest.security;

import guru.framework.springmvcrest.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
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
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE")
//                        .allowedOrigins("*")
                        .allowedHeaders("*");
                registry.addMapping("/**").allowCredentials(true)
//                        .allowedOrigins("*")
                        .allowedMethods("*");
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


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
        auth.authenticationProvider(authProvider());

        auth.userDetailsService(myUserDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String admin = "Admin";
        String customer = "Customer";
        String restaurantOwner = "RestaurantOwner";

        httpSecurity
                .csrf().disable().cors().and()
                .authorizeRequests()// Enabling URL to be accessed by all users (even un-authenticated)

                .antMatchers("/authenticate/signin").permitAll().
                antMatchers("/authenticate/signin/**").permitAll().

                antMatchers("/authenticate/signup").permitAll().
                antMatchers("/authenticate/signup/**").permitAll().

                antMatchers("/users").hasAuthority(customer).
                antMatchers("/users/{id}").permitAll().

                antMatchers("/profiles").permitAll().
                antMatchers("/profiles/{id}").permitAll().
                antMatchers("/profiles/register-restaurant").permitAll().

                antMatchers("/{role}").permitAll().
                antMatchers("/profiles}/{id}").permitAll().

                antMatchers("/restaurants").permitAll().
                antMatchers("/restaurants/assign-restaurant/{profileId}").permitAll().
                antMatchers("/restaurants/top-rated").permitAll().
                antMatchers("/restaurants/{id}").permitAll().

                antMatchers("/menus").permitAll().
                antMatchers("/menus/{id}").permitAll().
                antMatchers("/menus/{menuId}/{typeProduct}").permitAll().

                antMatchers("/restaurants/{restaurantId}/menus").permitAll().
                antMatchers("/restaurants/{restaurantId}/menus").permitAll().
                antMatchers("/restaurants/{restaurantId}/menus/{menuId}").permitAll().
                antMatchers("/restaurants/{id}/tags/{tagId}").permitAll().
                antMatchers("/restaurants/{id}/rate/{rating}").permitAll().

                antMatchers("/tags").permitAll().
                antMatchers("/tags/{id}").permitAll().

                antMatchers("/products").permitAll().
                antMatchers("/products/{id}").permitAll().
                antMatchers("/menus/{menuId}/{typeProduct}").permitAll().
                antMatchers("/menus/{menuId}/products/{id}").permitAll().

                antMatchers("/orders").permitAll().
                antMatchers("/orders/{id}").permitAll().
                antMatchers("/restaurants/view-restaurant/{id}").permitAll().

                antMatchers("/websocket-chat").permitAll().
                antMatchers("/websocket-chat/user-all").permitAll().
                antMatchers("/websocket-chat/topic/user").permitAll().
                antMatchers("/websocket-chat/*").permitAll().
                antMatchers("/websocket-chat/**").permitAll().

                antMatchers("/roles").hasAuthority(admin).

                anyRequest()
                .authenticated()// Any resources not mentioned above needs to be authenticated
                .and().sessionManagement()

                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//not to create a session
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}