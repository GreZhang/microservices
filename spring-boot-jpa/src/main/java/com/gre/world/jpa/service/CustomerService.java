package com.gre.world.jpa.service;

import com.gre.world.jpa.entity.Customer;

/**
 * @author 风骚的GRE
 * @Descriptions 客户Service接口
 * @date 2018/8/25.
 */
public interface CustomerService{
    /**
     * 添加客户
     *
     * @param customer
     */
    public void addCustomer(Customer customer);

    /**
     * 通过ID查询客户
     * @param id
     * @return
     */
    public Customer getCustomerById(Long id) ;
}
