package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.dtos.SellerInputDto;
import softuni.exam.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository repository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;

    public SellerServiceImpl(SellerRepository repository, Gson gson,
                             ValidationUtil validator, ModelMapper modelMapper) {
        this.repository = repository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/sellers.json");
        return Files.readString(path);
    }

    @Override
    public String importSellers() throws IOException {
        // 1. Parse sellers.json -> SellersInputDto
        SellerInputDto[] inputDtos = gson.fromJson(readSellersFromFile(), SellerInputDto[].class);
        // 2. Create a seller for each input DTO and print output
        StringBuilder sb = new StringBuilder();
        for (SellerInputDto inputDto : inputDtos) {
            Seller createdSeller = create(inputDto);
            if (createdSeller == null) {
                sb.append("Invalid seller\n");
            }
            else {
                sb.append(String.format("Successfully imported seller %s %s\n",
                        createdSeller.getFirstName(), createdSeller.getLastName()));
            }
        }
        return sb.toString();
    }

    private Seller create(SellerInputDto inputDto) {

        if (!validator.isValid(inputDto)) return null;

        try {
            Seller seller = modelMapper.map(inputDto, Seller.class);
            repository.save(seller);
            return seller;
        } catch (Exception e) {
            return null;
        }
    }
}
