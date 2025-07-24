package softuni.exam.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SaleInputDto {
    @Expose
    private boolean discounted;
    @Expose
    private String number;
    @Expose
    private String saleDate;
    @Expose
    private Long seller;
}
