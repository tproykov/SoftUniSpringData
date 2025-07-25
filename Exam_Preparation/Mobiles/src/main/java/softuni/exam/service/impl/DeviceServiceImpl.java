package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.dtos.DeviceInputDto;
import softuni.exam.dtos.DevicesImportDto;
import softuni.exam.entities.Device;
import softuni.exam.entities.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository repository;
    private final XmlParser xmlParser;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final SaleService saleService;

    public DeviceServiceImpl(DeviceRepository repository, XmlParser xmlParser,
                             ValidationUtil validator, ModelMapper modelMapper,
                             SaleService saleService) {
        this.repository = repository;
        this.xmlParser = xmlParser;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.saleService = saleService;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/xml/devices.xml");
        return Files.readString(path);
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        DevicesImportDto importDto = xmlParser.fromXml(readDevicesFromFile(),
                DevicesImportDto.class);
        StringBuilder sb = new StringBuilder();
        for (DeviceInputDto inputDto : importDto.getInput()) {
            Device createdDevice = create(inputDto);
            if (createdDevice == null) {
                sb.append("Invalid device\n");
            }
            else {
                sb.append(String.format("Successfully imported device of type %s with " +
                        "brand %s\n", createdDevice.getDeviceType(),
                        createdDevice.getBrand()));
            }
        }
        return sb.toString();
    }

    @Override
    public String exportDevices() {
        return "";
    }

    private Device create(DeviceInputDto inputDto) {
        if (!validator.isValid(inputDto)) return null;

        try {
            Device device = modelMapper.map(inputDto, Device.class);

            Long saleId = inputDto.getSale();
            if (saleId != null) {
                Sale sale = saleService.getReferenceById(saleId);
                device.setSale(sale);
            }
            repository.save(device);
            return device;
        } catch (Exception e) {
            return null;
        }
    }
}