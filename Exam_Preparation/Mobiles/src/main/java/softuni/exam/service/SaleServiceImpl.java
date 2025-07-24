package softuni.exam.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SaleServiceImpl implements SaleService {
    @Override
    public boolean areImported() {
        return false;
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
