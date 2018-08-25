package com.gre.world.jpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 风骚的GRE
 * @Descriptions 信用卡实体
 * @date 2018/8/23.
 */
@Entity
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 128)
    private String number;
    @Column(name = "registered_date")
    private Date registeredDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}



