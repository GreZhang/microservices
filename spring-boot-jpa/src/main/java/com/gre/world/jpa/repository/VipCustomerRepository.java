package com.gre.world.jpa.repository;

import com.gre.world.jpa.entity.VipCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 风骚的GRE
 * @Descriptions Vip客户仓库
 * @date 2018/8/25.
 */
@Repository
@Transactional(readOnly = false)
public interface VipCustomerRepository extends JpaRepository<VipCustomer,Long>,JpaSpecificationExecutor<VipCustomer> {
}
