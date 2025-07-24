package softuni.exam.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;
import softuni.exam.enums.DeviceType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceInputDto {
    @XmlElement(name = "brand")
    @NotNull
    @Length(min = 2, max = 20)
    private String brand;
    @XmlElement(name = "device_type")
    private DeviceType deviceType;
    @XmlElement(name = "model")
    @NotNull
    @Length(min = 1, max = 20)
    private String model;
    @XmlElement(name = "price")
    @Positive
    private Double price;
    @XmlElement(name = "storage")
    @Positive
    private Integer storage;
    @XmlElement(name = "sale_id")
    private Long sale;

    public @NotNull @Length(min = 2, max = 20) String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull @Length(min = 2, max = 20) String brand) {
        this.brand = brand;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public @NotNull @Length(min = 1, max = 20) String getModel() {
        return model;
    }

    public void setModel(@NotNull @Length(min = 1, max = 20) String model) {
        this.model = model;
    }

    public @Positive Double getPrice() {
        return price;
    }

    public void setPrice(@Positive Double price) {
        this.price = price;
    }

    public @Positive Integer getStorage() {
        return storage;
    }

    public void setStorage(@Positive Integer storage) {
        this.storage = storage;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }
}
