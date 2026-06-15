package lk.ijse.School_Managment_System.service;

import lk.ijse.School_Managment_System.dto.StudentDTO;

public interface StudentService {
    void saveStudent(StudentDTO  studentDTO);
    void updateStudent(StudentDTO  studentDTO);
    void deleteStudent(long studentId);
}
