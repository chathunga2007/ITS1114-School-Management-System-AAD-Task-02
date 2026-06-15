package lk.ijse.School_Managment_System.service;

import lk.ijse.School_Managment_System.dto.BookDTO;

public interface BookService {
    void saveBook(BookDTO  bookDTO);
    void updateBook(BookDTO  bookDTO);
}
