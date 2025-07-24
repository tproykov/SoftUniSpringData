package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository repository;

    public SellerServiceImpl(SellerRepository repository) {
        this.repository = repository;
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
        return "";
    }
}
