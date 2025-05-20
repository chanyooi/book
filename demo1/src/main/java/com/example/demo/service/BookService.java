package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    //생성자 주입
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //책 등록
    public BookDto createBook(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        return BookDto.fromEntity(bookRepository.save(book));
    }
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(BookDto::fromEntity).collect(Collectors.toList());
    }
    public BookDto getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(BookDto::fromEntity).orElse(null);
    }

    public BookDto updateBook(Long id, BookDto bookDto) {
        Optional<Book> book = bookRepository.findById(bookDto.getId());
        if (book.isPresent()) {
            book.get().setAuthor(bookDto.getAuthor());
            book.get().setTitle(bookDto.getTitle());
            book.get().setPrice(bookDto.getPrice());
            return BookDto.fromEntity(bookRepository.save(book.get()));
        }
        return null;
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
