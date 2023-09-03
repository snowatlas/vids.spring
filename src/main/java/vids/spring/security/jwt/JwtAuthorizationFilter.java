package vids.spring.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

////////////on filtre pour s'identifier ume sullle foi depuis la base

public class JwtAuthorizationFilter extends OncePerRequestFilter{
    @Autowired
    JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        Authentication authentication=jwtProvider.getAuthentication(request);
        if(authentication!=null && jwtProvider.isTokenValidate(request)){
                SecurityContextHolder.getContext().setAuthentication(authentication);
        }
            filterChain.doFilter(request, response);
    }
    
}
