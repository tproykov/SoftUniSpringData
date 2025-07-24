package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.dtos.SaleInputDto;
import softuni.exam.entities.Sale;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ValidationUtilImpl validationUtilImpl;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository repository, Gson gson,
                           ValidationUtil validator, ValidationUtilImpl validationUtilImpl, ModelMapper modelMapper) {
        this.repository = repository;
        this.gson = gson;
        this.validator = validator;
        this.validationUtilImpl = validationUtilImpl;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/sales.json");
        return Files.readString(path);
    }

    @Override
    public String importSales() throws IOException {
        SaleInputDto[] inputDtos = gson.fromJson(readSalesFileContent(), SaleInputDto[].class);
        for (SaleInputDto inputDto : inputDtos) {
            Sale createdSale = create(inputDto);



        }




        return "";
    }

    private Sale create(SaleInputDto inputDto) {
        if (!validator.isValid(inputDto)) return null;

        try {
            Sale sale = modelMapper.map(inputDto, Sale.class);
            repository.save(sale);
            return sale;
        } catch (Exception e) {
            return null;
        }
    }
}
