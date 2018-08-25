package com.gre.world.jpa.entity;

import javax.persistence.*;

/**
 * @author 风骚的GRE
 * @Descriptions 客户实体
 * @date 2018/8/23.
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private long id;// 注解
    @Column(name = "name",length = 50)
    private String name;// 姓名
    @Column(name = "age",length = 3)
    private int age;// 年龄
    @Column(name = "address",length = 256)
    private String address;// 地址

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
