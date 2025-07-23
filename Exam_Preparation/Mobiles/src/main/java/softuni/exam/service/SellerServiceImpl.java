package softuni.exam.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SellerServiceImpl implements SellerService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return "";
    }

    @Override
    public String importSellers() throws IOException {
        return "";
    }
}
