package com.gre.world.jpa.controller;

import com.gre.world.jpa.entity.VipCustomer;
import com.gre.world.jpa.exception.ExcepCodeConst;
import com.gre.world.jpa.service.VipCustomerService;
import com.gre.world.jpa.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 风骚的GRE
 * @Descriptions Vip客户Controller
 * @date 2018/8/26.
 */
@RestController
@RequestMapping("vipCustomers")
public class VipCustomerController {
    private static final Logger LOG = LoggerFactory.getLogger(VipCustomerController.class);
    private final VipCustomerService vipCustomerService;

    @Autowired
    public VipCustomerController(VipCustomerService vipCustomerService) {
        this.vipCustomerService = vipCustomerService;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public JsonResult<Object> addVipCustomer(@RequestBody VipCustomer vipCustomer){
        JsonResult<Object> jsonResult = null;
        try {
            vipCustomerService.add(vipCustomer);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",vipCustomer);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public JsonResult<Object> deleteVipCustomer(@PathVariable Long id){
        JsonResult<Object> jsonResult = null;
        try {
            vipCustomerService.delete(id);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("删除失败!");
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public JsonResult<Object> updateVipCustomer(@PathVariable Long id, @RequestBody VipCustomer vipCustomer){
        JsonResult<Object> jsonResult = null;
        try {
            vipCustomerService.update(id,vipCustomer);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},修改失败!",vipCustomer);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult<Object> findVipCustomerById(@PathVariable long id){
        JsonResult<Object> jsonResult = null;
        try {
            VipCustomer creditCard = vipCustomerService.getById(id);
            jsonResult = new JsonResult<Object>(creditCard);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",id);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public JsonResult<Object> findVipCustomerCards(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                              @RequestParam(required = false,defaultValue = "10")int pageSize){
        JsonResult<Object> jsonResult = null;
        try {
            Page<VipCustomer> creditCards = vipCustomerService.getVipCustomerList(pageNum,pageSize);
            jsonResult = new JsonResult<Object>(creditCards);
        }catch (Exception e){
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }
}
