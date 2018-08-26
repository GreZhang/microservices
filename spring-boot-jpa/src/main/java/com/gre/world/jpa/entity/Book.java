package com.gre.world.jpa.entity;

import com.gre.world.jpa.entity.listener.BookListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * @author 风骚的GRE
 * @Descriptions 图书实体
 * @date 2018/8/25.
 */
@Entity
@Table(name = "books")
@EntityListeners(BookListener.class)
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String isbn;

    private Date publishDate;

    @ManyToMany(mappedBy = "books")
    private Collection<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", customers=" + customers +
                '}';
    }
}
