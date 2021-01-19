package guru.framework.springmvcrest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class JwtUtilTest {

    private JwtUtil jwtUtil = new JwtUtil();

    private String SECRET_KEY = "secret";

    private Collection<? extends GrantedAuthority> authorities=new ArrayList<>();
    private UserDetails userDetails=new User("username","password",authorities);

    @Test
    void extractUsername() {
        String token=jwtUtil.generateToken(userDetails);
        String expected= jwtUtil.extractClaim(token, Claims::getSubject);

        String result=jwtUtil.extractUsername(token);
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void testExtractExpiration() {
        String token=jwtUtil.generateToken(userDetails);
        Date expected= jwtUtil.extractClaim(token, Claims::getExpiration);

        Date result=jwtUtil.extractExpiration(token);
        assertThat(expected).isEqualTo(result);

    }

//    @Test
//    void extractClaim() {
//    }

    @Test
    void generateToken() {
        Map<String, Object> claims = new HashMap<>();

        String expected = Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

        String result=jwtUtil.generateToken(userDetails);

        assertThat(jwtUtil.extractUsername(expected)).isEqualTo(jwtUtil.extractUsername(result));
        assertThat(jwtUtil.extractExpiration(expected)).isEqualTo(jwtUtil.extractExpiration(result));
    }

    private Boolean isTokenExpired(String token) {
        return jwtUtil.extractExpiration(token).before(new Date());
    }

    @Test
    void validateToken() {
        String token=jwtUtil.generateToken(userDetails);
        String username = jwtUtil.extractUsername(token);

        Boolean expected= (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        Boolean result=jwtUtil.validateToken(token,userDetails);

        assertThat(expected).isEqualTo(result);
    }
}