package vids.spring.service;

import vids.spring.model.Role;
import vids.spring.model.User;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findUserByUsername(String username);

    @Transactional
    void updateRole(Role newRole, String username);
}
