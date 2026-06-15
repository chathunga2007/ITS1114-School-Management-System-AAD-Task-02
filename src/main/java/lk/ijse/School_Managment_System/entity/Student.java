package lk.ijse.School_Managment_System.entity;

import jakarta.persistence.*;
import lk.ijse.School_Managment_System.enumeration.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String studentName;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    @ManyToOne
    private Section section;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Record> recordList;
}