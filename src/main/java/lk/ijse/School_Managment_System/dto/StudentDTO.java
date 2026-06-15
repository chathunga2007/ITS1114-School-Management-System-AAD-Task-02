package lk.ijse.School_Managment_System.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.School_Managment_System.enumeration.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long studentId;
    private String studentName;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    public StudentDTO(String studentName, LocalDate dob) {
        this.studentName = studentName;
        this.dob = dob;
    }
}
