package com.gre.world.jpa.repository;

import com.gre.world.jpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author 风骚的GRE
 * @Descriptions 客户仓储
 * @date 2018/8/25.
 */
@Repository
@Transactional(readOnly = false)
public class CustomerRepository extends SimpleJpaRepository<Customer,Long> {
    @Autowired
    public CustomerRepository(EntityManager em) {
        super(Customer.class, em);
    }

}
