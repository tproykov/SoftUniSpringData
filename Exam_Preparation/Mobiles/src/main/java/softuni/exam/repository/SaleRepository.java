package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}