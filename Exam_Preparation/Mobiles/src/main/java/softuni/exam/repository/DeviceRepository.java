package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.entities.Device;
import softuni.exam.enums.DeviceType;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device AS d WHERE d.deviceType = :deviceType " +
            "AND d.price < :maxPriceExclusive AND d.storage >= :minStorageInclusive " +
            "ORDER BY lower(d.brand)")
    List<Device> findExportable(DeviceType deviceType, Double maxPriceExclusive,
                                Integer minStorageInclusive);
}
