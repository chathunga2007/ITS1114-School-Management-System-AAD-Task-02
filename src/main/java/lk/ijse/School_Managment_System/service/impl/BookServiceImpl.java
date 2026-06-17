package lk.ijse.School_Managment_System.service.impl;

import lk.ijse.School_Managment_System.dto.BookDTO;
import lk.ijse.School_Managment_System.entity.Book;
import lk.ijse.School_Managment_System.repository.BookRepository;
import lk.ijse.School_Managment_System.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(BookDTO bookDTO) {
        log.info("saveBook");
        try {

            Book book = new Book();
            book.setBookName(bookDTO.getBookName());
            book.setBookAuthor(bookDTO.getBookAuthor());

            bookRepository.save(book);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        log.info("updateBook");
        try{

            Optional<Book> optionalBook = bookRepository.findById(bookDTO.getBookId());
            if(!optionalBook.isPresent()) {
                throw new Exception("Book not found with id " + bookDTO.getBookId());
            }

            Book book = optionalBook.get();
            book.setBookName(bookDTO.getBookName());
            book.setBookAuthor(bookDTO.getBookAuthor());

            bookRepository.save(book);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}