package com.gre.world.jpa.service;

import com.gre.world.jpa.entity.CreditCard;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 风骚的GRE
 * @Descriptions 信用卡Service接口
 * @date 2018/8/25.
 */
public interface CreditCardService {
    public boolean add(CreditCard creditCard);
    public boolean update(Long id,CreditCard creditCard);
    public CreditCard getById(Long id);
    public Page<CreditCard> getCreditCardList(int pageNum, int pageSize);
    public boolean remove(Long id);
    public boolean delete(Long id);
}
