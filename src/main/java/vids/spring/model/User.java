package vids.spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity // for jpa mapping
@Table(name = "users")//user used by postgresql
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="username",unique = true,nullable = false,length = 100)
    private String username;
     @Column(name = "password",nullable = false,length = 100)
    private  String password;
    @Column(name = "name",nullable = false,length = 100)
     private String name;
    @Column(name = "createTime",nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private Role role;
    //it will not be a persistence object we will noot save it in database 
    @Transient
    private String token;
}
