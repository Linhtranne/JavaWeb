package com.data.service;

import com.data.entity.Book;
import com.data.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Override
    public void delete(int id) {
        bookRepo.delete(id);
    }
}
