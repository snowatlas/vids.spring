package vids.spring.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.naming.directory.SearchControls;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Utf8;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import vids.spring.utils.SecurityUtils;
import vids.spring.utils.UserPrincipal;

@Component
public class JwtProviderImpl implements JwtProvider{
    
    
    @Value("${app.jwt.secret}")
    private String JWT_SECRET;
    

    @Value("${app.jwt.expiration-in.ms}")
    private Long JWT_EXPIRATION_IN_MS; 
    @Override
    public String generateToken(UserPrincipal auth){
        String authorities=auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                                                         .collect(Collectors.joining(","));


        Key key=Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                    .setSubject(auth.getUsername())
                    .claim("role", authorities) //extra parameter
                    .claim("userid", auth.getId()) //extraparameter
                    .setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION_IN_MS))
                    .signWith(key, SignatureAlgorithm.HS512)
                    .compact();

    }
    @Override
    public Authentication   getAuthentication(HttpServletRequest request){
        Claims claim=extractClaimes(request);
        if(claim == null) return null;
        String username=claim.getSubject();
        Long userId=claim.get("userid",Long.class);
        Set<GrantedAuthority> authorities=Arrays.stream(claim.get("role").toString().split(","))
                                                .map(SecurityUtils::convertToAuthority)
                                                .collect(Collectors.toSet());

        UserDetails userDetails=UserPrincipal.builder()
                                             .id(userId)
                                             .userName(username)
                                             .authorities(authorities)
                                             .build();
        
        if(username ==null) return null;

        //UsernamePasswordAuthenticationToken dd;
        
        //org.springframework.security.core.Authentication d1=dd;

        return new UsernamePasswordAuthenticationToken(userDetails,null,authorities);


        //grace aaa authorisationHeader qui contient Authentication
        
    }
    
    private Claims extractClaimes(HttpServletRequest request){
     
        String token=SecurityUtils.extractAuthTokenFromRequest(request);
        System.out.println(" Security extractClaimes "+token+" reques "+request.getAuthType());
        if(token == null) return null;
        Key key=Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.parserBuilder()
                   .setSigningKey(key)
                   .build()
                   .parseClaimsJws(token)
                   .getBody();

    }

    @Override
    public boolean isTokenValidate(HttpServletRequest request){
        Claims claims=extractClaimes(request);
        if(claims ==null ) return false;

        if(claims.getExpiration().before(new Date())) return false;

        return true;

    }

}