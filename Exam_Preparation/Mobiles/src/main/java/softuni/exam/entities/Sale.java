package softuni.exam.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    private Boolean discounted;
    private String number;
    private Double price;
    private LocalDateTime saleDate;


}
