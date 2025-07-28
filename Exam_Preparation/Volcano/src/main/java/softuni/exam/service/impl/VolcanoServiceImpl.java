package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.VolcanoService;

import java.io.IOException;

@Service
public class VolcanoServiceImpl implements VolcanoService {

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return "";
    }

    @Override
    public String importVolcanoes() throws IOException {
        return "";
    }

    @Override
    public String exportVolcanoes() {
        return "";
    }
}