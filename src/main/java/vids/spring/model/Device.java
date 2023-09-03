package vids.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_Type", nullable = false)
    private DeviceType deviceType;

   // @OneToMany(fetch = FetchType.LAZY,mappedBy = "device")//nom variable dans classe purchase
    //private Set<Device> purchases;
}