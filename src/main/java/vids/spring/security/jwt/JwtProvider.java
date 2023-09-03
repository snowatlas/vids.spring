package vids.spring.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import vids.spring.utils.UserPrincipal;

public interface JwtProvider{
    
     public String generateToken(UserPrincipal auth);
     public Authentication   getAuthentication(HttpServletRequest request);
     public boolean isTokenValidate(HttpServletRequest request);
    
}