package vids.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import vids.spring.model.User;
import vids.spring.security.jwt.JwtProvider;
import vids.spring.utils.UserPrincipal;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signeInAndReturnJwt(User signeInRequest){
        Authentication authentication=authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(signeInRequest.getUsername(), signeInRequest.getPassword())
        );
        UserPrincipal userPrincipal=(UserPrincipal)authentication.getPrincipal();
        String jwt=jwtProvider.generateToken(userPrincipal);
        User signeInUser=userPrincipal.getUser();
        signeInUser.setToken(jwt);
        return signeInUser;

    }
    
}
