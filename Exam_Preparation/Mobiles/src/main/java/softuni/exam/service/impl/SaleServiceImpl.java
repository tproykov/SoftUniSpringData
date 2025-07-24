package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;

    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
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
        return "";
    }
}
