package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "volcanoes")
public class Volcano extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;



}
