package com.gre.world.jpa.entity;

import com.gre.world.jpa.entity.listener.CreditCardListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 风骚的GRE
 * @Descriptions 信用卡实体
 * @date 2018/8/23.
 */
@Entity
@Table(name = "credit_cards")
@EntityListeners(CreditCardListener.class)
public class CreditCard {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 128)
    private String number;
    @Column(name = "registered_date")
    private Date registeredDate;

    @OneToOne(mappedBy = "creditCard")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", registeredDate=" + registeredDate +
                ", customer=" + customer +
                '}';
    }
}



