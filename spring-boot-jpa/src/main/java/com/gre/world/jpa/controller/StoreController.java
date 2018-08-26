package com.gre.world.jpa.controller;

import com.gre.world.jpa.entity.Store;
import com.gre.world.jpa.exception.ExcepCodeConst;
import com.gre.world.jpa.service.StoreService;
import com.gre.world.jpa.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 风骚的GRE
 * @Descriptions 店铺Controller
 * @date 2018/8/26.
 */
@RestController
@RequestMapping("stores")
public class StoreController {
    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public JsonResult<Object> addStore(@RequestBody Store store){
        JsonResult<Object> jsonResult = null;
        try {
            storeService.add(store);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",store);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public JsonResult<Object> deleteStore(@PathVariable Long id){
        JsonResult<Object> jsonResult = null;
        try {
            storeService.delete(id);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("删除失败!");
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public JsonResult<Object> updateStore(@PathVariable Long id, @RequestBody Store store){
        JsonResult<Object> jsonResult = null;
        try {
            storeService.update(id,store);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},修改失败!",store);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult<Object> findStoreById(@PathVariable long id){
        JsonResult<Object> jsonResult = null;
        try {
            Store store = storeService.getById(id);
            jsonResult = new JsonResult<Object>(store);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",id);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public JsonResult<Object> findStores(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                              @RequestParam(required = false,defaultValue = "10")int pageSize){
        JsonResult<Object> jsonResult = null;
        try {
            Page<Store> creditCards = storeService.getStoreList(pageNum,pageSize);
            jsonResult = new JsonResult<Object>(creditCards);
        }catch (Exception e){
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }
}
