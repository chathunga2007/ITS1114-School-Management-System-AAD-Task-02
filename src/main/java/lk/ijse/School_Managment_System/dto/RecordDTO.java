package lk.ijse.School_Managment_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    private long recordId;
    private long studentId;
    private long bookId;
}
