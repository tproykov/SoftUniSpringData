package softuni.exam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import softuni.exam.enums.DeviceType;

@Entity
@Table(name = "devices")
public class Device extends BaseEntity {
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "device_type")
    private DeviceType deviceType;
    @Column(name = "models", nullable = false, unique = true)
    private String model;
    @Column(name = "price")
    private Double price;
    @Column(name = "storage")
    private Integer storage;

    private Sale sale;




}
