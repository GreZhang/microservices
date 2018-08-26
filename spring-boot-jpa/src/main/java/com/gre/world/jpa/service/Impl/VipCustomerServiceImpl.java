package com.gre.world.jpa.service.Impl;

import com.gre.world.jpa.entity.VipCustomer;
import com.gre.world.jpa.repository.VipCustomerRepository;
import com.gre.world.jpa.service.VipCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/8/25.
 */
@Service
public class VipCustomerServiceImpl implements VipCustomerService {
    private final VipCustomerRepository vipCustomerRepository;

    @Autowired
    public VipCustomerServiceImpl(VipCustomerRepository vipCustomerRepository) {
        this.vipCustomerRepository = vipCustomerRepository;
    }

    @Override
    public boolean add(VipCustomer vipCustomer) {
        boolean success = false;
        try {
            vipCustomerRepository.save(vipCustomer);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public boolean update(Long id, VipCustomer vipCustomer) {
        boolean success = false;
        try {
            vipCustomer.setId(id);
            vipCustomerRepository.save(vipCustomer);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public VipCustomer getById(Long id) {
        return vipCustomerRepository.getOne(id);
    }

    @Override
    public Page<VipCustomer> getVipCustomerList(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return vipCustomerRepository.findAll(pageable);
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = false;
        try {
            vipCustomerRepository.deleteById(id);
            success = true;
        }catch (Exception e){

        }
        return success;
    }
}
