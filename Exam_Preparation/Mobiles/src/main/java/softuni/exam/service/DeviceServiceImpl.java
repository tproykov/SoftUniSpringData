package softuni.exam.service;

import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return "";
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        return "";
    }

    @Override
    public String exportDevices() {
        return "";
    }
}
