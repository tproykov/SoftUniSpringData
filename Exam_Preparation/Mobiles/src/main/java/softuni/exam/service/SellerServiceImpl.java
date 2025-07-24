package softuni.exam.service;

import org.springframework.stereotype.Service;
import softuni.exam.repository.SellerRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public boolean areImported() {
        return false;
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
