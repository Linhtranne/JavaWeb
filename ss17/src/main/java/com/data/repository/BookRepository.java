package com.data.repository;

import com.data.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();

    void delete(int id);
}
