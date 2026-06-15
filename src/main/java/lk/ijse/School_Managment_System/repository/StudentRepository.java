package lk.ijse.School_Managment_System.repository;

import lk.ijse.School_Managment_System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
