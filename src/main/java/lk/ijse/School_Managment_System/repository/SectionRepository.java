package lk.ijse.School_Managment_System.repository;

import lk.ijse.School_Managment_System.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {
}
