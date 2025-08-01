package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Volcano;

@Repository
public interface VolcanoRepository extends JpaRepository<Volcano, Long> {
}