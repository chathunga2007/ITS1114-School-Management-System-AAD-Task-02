package lk.ijse.School_Managment_System.repository;

import lk.ijse.School_Managment_System.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
}
