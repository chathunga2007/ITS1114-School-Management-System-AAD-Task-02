package lk.ijse.School_Managment_System.repository;

import lk.ijse.School_Managment_System.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
