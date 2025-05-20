package com.example.demo.dto;

import com.example.demo.domain.Book;

public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String price;

    public BookDto() {}

    public BookDto(Long id, String title, String author, String price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static BookDto fromEntity(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}

