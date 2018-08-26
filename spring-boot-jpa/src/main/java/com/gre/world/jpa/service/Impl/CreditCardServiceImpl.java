package com.gre.world.jpa.service.Impl;

import com.gre.world.jpa.entity.CreditCard;
import com.gre.world.jpa.repository.CreditCardRepository;
import com.gre.world.jpa.service.CreditCardService;
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
public class CreditCardServiceImpl implements CreditCardService
{
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public boolean add(CreditCard creditCard) {
        boolean success = false;
        try {
            creditCardRepository.save(creditCard);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public boolean update(Long id, CreditCard creditCard) {
        boolean success = false;
        try {
            creditCard.setId(id);
            creditCardRepository.save(creditCard);
            success = true;
        }catch (Exception e){

        }
        return success;
    }

    @Override
    public CreditCard getById(Long id) {
        return creditCardRepository.getOne(id);
    }

    @Override
    public Page<CreditCard> getCreditCardList(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return creditCardRepository.findAll(pageable);
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = false;
        try {
            creditCardRepository.deleteById(id);
            success = true;
        }catch (Exception e){

        }
        return success;
    }
}
