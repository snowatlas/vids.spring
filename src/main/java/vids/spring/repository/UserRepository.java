package vids.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vids.spring.model.Role;
import vids.spring.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

    //findby +fieldname
    Optional<User> findByUsername(String username);
    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUsserRole(@Param("username") String username, @Param("role") Role role);

}
