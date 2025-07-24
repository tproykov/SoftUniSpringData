package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import softuni.exam.dtos.SellerInputDto;
import softuni.exam.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository repository;
    private final Gson gson;

    public SellerServiceImpl(SellerRepository repository, Gson gson) {
        this.repository = repository;
        this.gson = gson;
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
        // 2. Create a seller for each input DTO. (Keep track of the success)
        // 3. Prepare the output

        return "";
    }
}
