package lk.ijse.School_Managment_System.service.impl;

import lk.ijse.School_Managment_System.dto.StudentDTO;
import lk.ijse.School_Managment_System.entity.Section;
import lk.ijse.School_Managment_System.entity.Student;
import lk.ijse.School_Managment_System.enumeration.StudentStatus;
import lk.ijse.School_Managment_System.repository.SectionRepository;
import lk.ijse.School_Managment_System.repository.StudentRepository;
import lk.ijse.School_Managment_System.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final SectionRepository sectionRepository;

    public StudentServiceImpl(StudentRepository studentRepository,  SectionRepository sectionRepository) {
        this.studentRepository = studentRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        log.info("saveStudent");
        try {

            Student student = new Student();
            student.setStudentName(studentDTO.getStudentName());
            student.setDob(studentDTO.getDob());
            student.setStudentStatus(studentDTO.getStudentStatus());

            Optional<Section> optionalSection = sectionRepository.findById(studentDTO.getSectionId());

            if(!optionalSection.isPresent()) {
                throw new Exception("Section not found with id " + studentDTO.getSectionId());
            }

            student.setSection(optionalSection.get());
            studentRepository.save(student);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        log.info("updateStudent");
        try {

            Optional<Student> optionalStudent = studentRepository.findById(studentDTO.getStudentId());
            if(!optionalStudent.isPresent()) {
                throw new Exception("Student not found with id " + studentDTO.getStudentId());
            }

            Student student = optionalStudent.get();

            student.setStudentName(studentDTO.getStudentName());
            student.setDob(studentDTO.getDob());
            student.setStudentStatus(studentDTO.getStudentStatus());

            Optional<Section> optionalSection = sectionRepository.findById(studentDTO.getSectionId());
            if(!optionalSection.isPresent())
                throw new Exception("Section not found with id " + studentDTO.getSectionId());

            Section section = optionalSection.get();

            student.setSection(section);
            sectionRepository.save(section);
            studentRepository.save(student);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(long studentId) {
        log.info("deleteStudent");
        try {

            Optional<Student> optionalStudent = studentRepository.findById(studentId);
            if(!optionalStudent.isPresent()) {
                throw new Exception("Student not found with id " + studentId);
            }

            Student student = optionalStudent.get();

            student.setStudentStatus(StudentStatus.INACTIVE);

            studentRepository.save(student);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}