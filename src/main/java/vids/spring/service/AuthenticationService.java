package vids.spring.service;

import vids.spring.model.User;

public interface AuthenticationService{
    public User signeInAndReturnJwt(User signeInRequest);

}