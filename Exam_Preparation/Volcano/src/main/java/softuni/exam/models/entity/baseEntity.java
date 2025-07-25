package softuni.exam.models.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class baseEntity {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}