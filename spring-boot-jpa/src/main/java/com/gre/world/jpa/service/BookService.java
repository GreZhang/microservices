package com.gre.world.jpa.service;

import com.gre.world.jpa.entity.Book;
import org.springframework.data.domain.Page;

/**
 * @author 风骚的GRE
 * @Descriptions 图书Service
 * @date 2018/8/25.
 */
public interface BookService {
    public boolean add(Book book);
    public boolean update(Long id,Book book);
    public Book getById(Long id);
    public Page<Book> getBootList(int pageNum, int pageSize);
    public boolean remove(Long id);
    public boolean delete(Long id);
}
