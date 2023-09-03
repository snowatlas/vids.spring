package vids.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vids.spring.model.Role;
import vids.spring.model.User;
import vids.spring.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }
    @Override
    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional // methode is transactional  we can put all userService @transactional so all methode class will be transact
    public void updateRole(Role newRole,String username){
        userRepository.updateUsserRole(username,newRole);
    }
}
