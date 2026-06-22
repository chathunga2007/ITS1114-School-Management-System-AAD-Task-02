package lk.ijse.School_Managment_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;
    @Temporal(TemporalType.DATE)
    private LocalDate borrowDate;
    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Book book;
}