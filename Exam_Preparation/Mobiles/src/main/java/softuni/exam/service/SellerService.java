package softuni.exam.service;

import softuni.exam.entities.Seller;

import java.io.IOException;

public interface SellerService {
    boolean areImported();
    String readSellersFromFile() throws IOException;
    String importSellers() throws IOException;
    Seller getReferenceById(Long id);
}