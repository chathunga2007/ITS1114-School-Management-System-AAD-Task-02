package lk.ijse.School_Managment_System.controller;

import lk.ijse.School_Managment_System.constant.CommonResponse;
import lk.ijse.School_Managment_System.dto.BookDTO;
import lk.ijse.School_Managment_System.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static lk.ijse.School_Managment_System.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.School_Managment_System.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateBook(@RequestBody BookDTO bookDTO) {
        bookService.updateBook(bookDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }
}