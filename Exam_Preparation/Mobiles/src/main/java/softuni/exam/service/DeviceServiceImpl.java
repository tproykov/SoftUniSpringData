package softuni.exam.service;

import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        Path path = Paths.get("src/main/java/resources.devices.xml");
        Files.readString(src/main/java/resources/devices.xml);
        return "src/main/java/resources/devices.xml";
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
