package com.gre.world.jpa.controller;

import com.gre.world.jpa.entity.Book;
import com.gre.world.jpa.exception.ExcepCodeConst;
import com.gre.world.jpa.service.BookService;
import com.gre.world.jpa.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 风骚的GRE
 * @Descriptions 图书Controller
 * @date 2018/8/26.
 */
@RestController
@RequestMapping("books")
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public JsonResult<Object> addBook(@RequestBody Book book){
        JsonResult<Object> jsonResult = null;
        try {
            bookService.add(book);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",book.getName());
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public JsonResult<Object> deleteBook(@PathVariable Long id){
        JsonResult<Object> jsonResult = null;
        try {
            bookService.delete(id);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("删除失败!");
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public JsonResult<Object> updateBook(@PathVariable Long id, @RequestBody Book book){
        JsonResult<Object> jsonResult = null;
        try {
            bookService.update(id,book);
            jsonResult = new JsonResult<Object>(true);
        }catch (Exception e){
            LOG.info("客户->{},修改失败!",book.getName());
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult<Object> findBookById(@PathVariable long id){
        JsonResult<Object> jsonResult = null;
        try {
            Book book = bookService.getById(id);
            jsonResult = new JsonResult<Object>(book);
        }catch (Exception e){
            LOG.info("客户->{},保存失败!",id);
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public JsonResult<Object> findBooks(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                        @RequestParam(required = false,defaultValue = "10")int pageSize){
        JsonResult<Object> jsonResult = null;
        try {
            Page<Book> books = bookService.getBootList(pageNum,pageSize);
            jsonResult = new JsonResult<Object>(books);
        }catch (Exception e){
            jsonResult = new JsonResult<Object>(ExcepCodeConst.EXCHANGE_SYS_EXCEP.getMessage(),ExcepCodeConst.EXCHANGE_SYS_EXCEP.getState());
        }
        return  jsonResult;
    }
}
