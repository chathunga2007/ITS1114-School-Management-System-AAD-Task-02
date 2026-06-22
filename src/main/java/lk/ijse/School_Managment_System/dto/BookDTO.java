package lk.ijse.School_Managment_System.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.School_Managment_System.enumeration.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private long bookId;
    private String bookName;
    private String bookAuthor;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
}