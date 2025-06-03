package com.data.service;

import com.data.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    void delete(int id);

}
