package lk.ijse.School_Managment_System.service.impl;

import lk.ijse.School_Managment_System.dto.RecordDTO;
import lk.ijse.School_Managment_System.entity.Book;
import lk.ijse.School_Managment_System.entity.Record;
import lk.ijse.School_Managment_System.entity.Student;
import lk.ijse.School_Managment_System.repository.BookRepository;
import lk.ijse.School_Managment_System.repository.RecordRepository;
import lk.ijse.School_Managment_System.repository.StudentRepository;
import lk.ijse.School_Managment_System.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public RecordServiceImpl(RecordRepository recordRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.recordRepository = recordRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveRecord(RecordDTO recordDTO) {
        log.info("saveRecord");
        try {
            Record record = new Record();

            Optional<Student> optionalStudent = studentRepository.findById(recordDTO.getStudentId());
            if (!optionalStudent.isPresent()) {
                throw new Exception("Student not found with id " + recordDTO.getStudentId());
            }

            Optional<Book> optionalBook = bookRepository.findById(recordDTO.getBookId());
            if (!optionalBook.isPresent()) {
                throw new Exception("Book not found with id " + recordDTO.getBookId());
            }

            record.setStudent(optionalStudent.get());
            record.setBook(optionalBook.get());

            recordRepository.save(record);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateRecord(RecordDTO recordDTO) {
        log.info("updateRecord");
        try {
            Optional<Record> optionalRecord = recordRepository.findById(recordDTO.getRecordId());
            if (!optionalRecord.isPresent()) {
                throw new Exception("Record not found with id " + recordDTO.getRecordId());
            }

            Record record = optionalRecord.get();

            Optional<Student> optionalStudent = studentRepository.findById(recordDTO.getStudentId());
            if (!optionalStudent.isPresent()) {
                throw new Exception("Student not found with id " + recordDTO.getStudentId());
            }

            Optional<Book> optionalBook = bookRepository.findById(recordDTO.getBookId());
            if (!optionalBook.isPresent()) {
                throw new Exception("Book not found with id " + recordDTO.getBookId());
            }

            record.setStudent(optionalStudent.get());
            record.setBook(optionalBook.get());

            recordRepository.save(record);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void deleteRecord(long recordId) {
        log.info("deleteRecord");
        try {
            Optional<Record> optionalRecord = recordRepository.findById(recordId);
            if (optionalRecord.isPresent()) {
                recordRepository.delete(optionalRecord.get());
            } else {
                throw new Exception("Record not found with id " + recordId);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
