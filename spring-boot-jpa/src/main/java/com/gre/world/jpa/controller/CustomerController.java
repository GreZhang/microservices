package com.gre.world.jpa.controller;

import com.gre.world.jpa.entity.Customer;
import com.gre.world.jpa.exception.ExcepCodeConst;
import com.gre.world.jpa.service.CustomerService;
import com.gre.world.jpa.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 风骚的GRE
 * @Descriptions 客户Controller
 * @date 2018/8/26.
 */
@RestController
@RequestMapping("customers")
public class CustomerController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public JsonResult<Object> addCustomer(@RequestBody Customer customer){
        JsonResult<Object> jsonResult = null;
        try {
            customerService.addCustomer(customer);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",customer.getName());
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult<Object> findCustomerById(@PathVariable(value="id") Long id){
        JsonResult<Object> jsonResult = null;
        try {
            Customer customer = customerService.getCustomerById(id);
            jsonResult = new JsonResult<Object>(customer);
        }catch (Exception e){
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }
}
