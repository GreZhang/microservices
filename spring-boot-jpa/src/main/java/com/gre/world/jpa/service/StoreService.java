package com.gre.world.jpa.service;

import com.gre.world.jpa.entity.Store;
import org.springframework.data.domain.Page;

/**
 * @author 风骚的GRE
 * @Descriptions 店铺Service接口
 * @date 2018/8/25.
 */
public interface StoreService {
    public boolean add(Store store);
    public boolean update(Long id,Store store);
    public Store getById(Long id);
    public Page<Store> getStoreList(int pageNum, int pageSize);
    public boolean remove(Long id);
    public boolean delete(Long id);
}
