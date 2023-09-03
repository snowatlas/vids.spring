package vids.spring.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vids.spring.model.User;
import vids.spring.service.UserService;
import vids.spring.utils.SecurityUtils;
import vids.spring.utils.UserPrincipal;

import java.util.Set;
@Service
public class CustomerUserDetailsService implements  UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        User user=userService.findUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
        //spring desgigne that user can have multiple role
        Set<GrantedAuthority> authorities= Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
       //return sercuty user contain  usename password and authorities
        //userdatails contail details user username and password and it's abstracted class=> we must create userPrincipal

        return UserPrincipal.builder()
                            .id(user.getId())
                            .userName(username)
                            .password(user.getPassword())
                            .user(user)
                            .authorities(authorities)
                            .build();
    }
}
