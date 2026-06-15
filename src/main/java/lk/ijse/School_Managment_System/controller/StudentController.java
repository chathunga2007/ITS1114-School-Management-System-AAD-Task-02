package lk.ijse.School_Managment_System.controller;

import lk.ijse.School_Managment_System.constant.CommonResponse;
import lk.ijse.School_Managment_System.dto.StudentDTO;
import lk.ijse.School_Managment_System.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static lk.ijse.School_Managment_System.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.School_Managment_System.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveStudent(@RequestBody StudentDTO studentDTO){
        studentService.saveStudent(studentDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @DeleteMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteStudent(@PathVariable long studentId) {
        studentService.deleteStudent(studentId);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }
}