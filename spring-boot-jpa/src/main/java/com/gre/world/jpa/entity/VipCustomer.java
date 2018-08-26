package com.gre.world.jpa.entity;

import com.gre.world.jpa.entity.listener.VipCustomerListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Inheritance;

/**
 * @author 风骚的GRE
 * @Descriptions Vip客户实体
 * @date 2018/8/25.
 */
@Inheritance
@Entity
@EntityListeners(VipCustomerListener.class)
public class VipCustomer extends Customer {

    private Double discount;

    public VipCustomer(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "VipCustomer{" +
                "discount=" + discount +
                '}';
    }
}
