package com.gre.world.jpa.service;

import com.gre.world.jpa.entity.VipCustomer;
import org.springframework.data.domain.Page;

/**
 * @author 风骚的GRE
 * @Descriptions Vip客户Service接口
 * @date 2018/8/25.
 */
public interface VipCustomerService {
    public boolean add(VipCustomer vipCustomer);
    public boolean update(Long id,VipCustomer vipCustomer);
    public VipCustomer getById(Long id);
    public Page<VipCustomer> getVipCustomerList(int pageNum, int pageSize);
    public boolean remove(Long id);
    public boolean delete(Long id);
}
