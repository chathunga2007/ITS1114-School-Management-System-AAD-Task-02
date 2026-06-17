package lk.ijse.School_Managment_System.service;

import lk.ijse.School_Managment_System.dto.RecordDTO;

public interface RecordService {
    void saveRecord(RecordDTO recordDTO);
    void updateRecord(RecordDTO recordDTO);
    void deleteRecord(long recordId);
}
