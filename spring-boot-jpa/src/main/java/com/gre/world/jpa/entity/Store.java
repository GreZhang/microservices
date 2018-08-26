package com.gre.world.jpa.entity;

import com.gre.world.jpa.entity.listener.StoreListener;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author 风骚的GRE
 * @Descriptions 店铺实体
 * @date 2018/8/25.
 */
@Entity
@Table(name = "store")
@EntityListeners(StoreListener.class)
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String name;

    @OneToMany(mappedBy = "store")
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

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
