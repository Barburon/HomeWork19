package com.cursor.library.services;

import com.cursor.library.daos.BookDao;
import com.cursor.library.exceptions.BadIdException;
import com.cursor.library.exceptions.BookNameIsNullException;
import com.cursor.library.exceptions.BookNameIsTooLongException;
import com.cursor.library.models.Book;
import com.cursor.library.models.CreateBookDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    private BookService bookService;
    private BookDao bookDao;

    @BeforeAll
    void setUp() {
        bookDao = Mockito.mock(BookDao.class);
        bookService = new BookService(bookDao);
    }

    @Test
    void getBookByIdSuccessTest() {
        String bookId = "book-id";

        Mockito.when(bookDao.getById(bookId)).thenReturn(new Book(bookId));

        Book bookFromDB = bookService.getById(bookId);

        assertEquals(
                bookId,
                bookFromDB.getBookId()
        );
    }

    @Test
    void getBookByIdNullExceptionTest() {

        assertThrows(BadIdException.class, () -> bookService.getById(null));
    }

    @Test
    void getBookByIdBadIdExceptionTest() {
        assertThrows(
                BadIdException.class,
                () -> bookService.getById("       ")
        );
    }

    @Test
    void getValidatedBookNameExpectBookNameIsNullExceptionTest() {
        assertThrows(
                BookNameIsNullException.class,
                () -> bookService.getValidatedBookName(null)
        );
    }

    @Test
    void getValidateBookNameExpectBookNameIsTooLongExceptionTest() {
        String bookName = " ";
        for (int i = 0; i < 10; i++) {
            bookName += bookName;
        }

        String finalBookName = bookName;
        assertThrows(
                BookNameIsTooLongException.class,
                () -> bookService.getValidatedBookName(finalBookName)
        );
    }

    @Test
    void createBookTest() {
        CreateBookDto bookDto = new CreateBookDto();

        bookDto.setName("BookDtoName");
        String name = "BookDtoName";
        assertEquals(name, bookDto.getName());

        bookDto.setDescription("BookDto description");
        String description = "BookDto description";
        assertEquals(description, bookDto.getDescription());

        List<String> authors = Arrays.asList("Author1", "Author2", "Author3");
        bookDto.setAuthors(authors);
        List<String> authors2 = Arrays.asList("Author1", "Author2", "Author3");
        assertEquals(authors2, bookDto.getAuthors());

        Integer numberOfWords = 678;
        bookDto.setNumberOfWords(678);
        assertEquals(numberOfWords, bookDto.getNumberOfWords());

        Integer rating = 3;
        bookDto.setRating(3);
        assertEquals(rating, bookDto.getRating());

        Integer year = 2015;
        bookDto.setYearOfPublication(2015);
        assertEquals(year, bookDto.getYearOfPublication());

        assertNotNull(bookDto);

    }
}
