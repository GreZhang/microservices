package com.gre.world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/8/10.
 */
//@RestController
@Controller
public class IndexController {

    @RequestMapping("")
    public String index(Model model) { // 现代写法
        // 模(mu)板渲染
        model.addAttribute("message", "Hello,World");
        return "index";
    }

}
