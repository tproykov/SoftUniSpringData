package softuni.exam.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SaleServiceImpl implements SaleService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        return "";
    }

    @Override
    public String importSales() throws IOException {
        return "";
    }
}
