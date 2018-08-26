package com.gre.world.jpa.service.Impl;

import com.gre.world.jpa.entity.Book;
import com.gre.world.jpa.repository.BookRepository;
import com.gre.world.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/8/25.
 */
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean add(Book book) {
        boolean success = false;
        try {
            bookRepository.save(book);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public boolean update(Long id, Book book) {
        boolean success = false;
        try {
            book.setId(id);
            bookRepository.save(book);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Page<Book> getBootList(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return bookRepository.findAll(pageable);
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = false;
        try {
            bookRepository.deleteById(id);
            success = true;
        }catch (Exception e){

        }
        return success;
    }
}
