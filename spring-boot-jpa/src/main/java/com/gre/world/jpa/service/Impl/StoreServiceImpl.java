package com.gre.world.jpa.service.Impl;

import com.gre.world.jpa.entity.Store;
import com.gre.world.jpa.repository.StoreRepository;
import com.gre.world.jpa.service.StoreService;
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
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean add(Store store) {
        boolean success = false;
        try {
            storeRepository.save(store);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public boolean update(Long id, Store store) {
        boolean success = false;
        try {
            store.setId(id);
            storeRepository.save(store);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public Store getById(Long id) {
        return storeRepository.getOne(id);
    }

    @Override
    public Page<Store> getStoreList(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return storeRepository.findAll(pageable);
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = false;
        try {
            storeRepository.deleteById(id);
            success = true;
        }catch (Exception e){

        }
        return success;
    }
}
