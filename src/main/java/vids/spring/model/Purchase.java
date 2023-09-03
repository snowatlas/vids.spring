package vids.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id",insertable = false,updatable = false)//it can not modify user table
    private User user;

    @Column(name="device_id",nullable = false)
    private Long deviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Device device;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "color",nullable = false)
    private  String color;

    @Column(name = "purchaseTime",nullable = false)
    private LocalDateTime purchaseTime;

   
}   
