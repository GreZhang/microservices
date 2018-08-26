package com.gre.world.jpa.entity;

import com.gre.world.jpa.entity.listener.CustomerListener;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author 风骚的GRE
 * @Descriptions 客户实体
 * @date 2018/8/23.
 */
@Entity
@Table(name = "customer")
@EntityListeners(value = {CustomerListener.class})
public class Customer {
    @Id
    @GeneratedValue
    private long id;// 注解
    @Column(length = 50)
    private String name;// 姓名
    @OneToOne
    private CreditCard creditCard;

    @ManyToOne
    private Store store;

    @ManyToMany
    private Collection<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creditCard=" + creditCard +
                ", store=" + store +
                ", books=" + books +
                '}';
    }
}
