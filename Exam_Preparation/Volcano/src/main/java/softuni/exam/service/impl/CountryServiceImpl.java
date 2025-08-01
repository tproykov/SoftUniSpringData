package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.CountryService;

import javax.persistence.criteria.Path;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        Path path = Paths.get("");
        return "";
    }

    @Override
    public String importCountries() throws IOException {
        return "";
    }
}
