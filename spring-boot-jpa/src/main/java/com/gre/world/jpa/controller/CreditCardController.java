package com.gre.world.jpa.controller;

import com.gre.world.jpa.entity.CreditCard;
import com.gre.world.jpa.exception.ExcepCodeConst;
import com.gre.world.jpa.service.CreditCardService;
import com.gre.world.jpa.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 风骚的GRE
 * @Descriptions 信用卡Controller
 * @date 2018/8/26.
 */
@RestController
@RequestMapping("creditCards")
public class CreditCardController {
    private static final Logger LOG = LoggerFactory.getLogger(CreditCardController.class);

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public JsonResult<Object> addCreditCard(@RequestBody CreditCard creditCard){
        JsonResult<Object> jsonResult = null;
        try {
            creditCardService.add(creditCard);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",creditCard);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public JsonResult<Object> deleteCreditCard(@PathVariable Long id){
        JsonResult<Object> jsonResult = null;
        try {
            creditCardService.delete(id);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("删除失败!");
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public JsonResult<Object> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard){
        JsonResult<Object> jsonResult = null;
        try {
            creditCardService.update(id,creditCard);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},修改失败!",creditCard);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult<Object> findCreditCardById(@PathVariable long id){
        JsonResult<Object> jsonResult = null;
        try {
            CreditCard creditCard = creditCardService.getById(id);
            jsonResult = new JsonResult<Object>(creditCard);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",id);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public JsonResult<Object> findCreditCards(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                        @RequestParam(required = false,defaultValue = "10")int pageSize){
        JsonResult<Object> jsonResult = null;
        try {
            Page<CreditCard> creditCards = creditCardService.getCreditCardList(pageNum,pageSize);
            jsonResult = new JsonResult<Object>(creditCards);
        }catch (Exception e){
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }
}
