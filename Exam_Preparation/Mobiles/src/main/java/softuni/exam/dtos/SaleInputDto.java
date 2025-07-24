package softuni.exam.dtos;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class SaleInputDto {
    @Expose
    private boolean discounted;
    @Expose
    @NotNull
    @Length(min = 7, max = 7)
    private String number;
    @Expose
    @NotNull
    private String saleDate;
    @Expose
    private Long seller;

    public boolean isDiscounted() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    public @NotNull @Length(min = 7, max = 7) String getNumber() {
        return number;
    }

    public void setNumber(@NotNull @Length(min = 7, max = 7) String number) {
        this.number = number;
    }

    public @NotNull String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(@NotNull String saleDate) {
        this.saleDate = saleDate;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }
}
