package com.gre.world.controller;

import com.gre.world.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 风骚的GRE
 * @Descriptions 人 {@link com.gre.world.domain.Person}
 * @date 2018/8/16.
 */
//@Controller //修饰Class,用来创建处理Http请求的对象
//@ResponseBody // 配合@Controller注解，如果使用@RestController就不需要了,它默认返回的是json格式
@RestController // Spring4后加入的注解，原来在@Controller返回json需要@ResponseBody
@RequestMapping("persons") //配置URL映射
public class PersonRestController {

    private Map<Long,Person> repos =  Collections.synchronizedMap(new HashMap<Long,Person>());// 线程安全的map，用来存储Person对象

    public PersonRestController() {
        Person person = new Person();
        person.setId(1);
        person.setName("小马哥");
        Person person2 = new Person();
        person2.setId(2);
        person2.setName("Gre");
        repos.put(person.getId(),person);
        repos.put(person2.getId(),person2);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String createPerson(@ModelAttribute Person person){
        repos.put(person.getId(),person);
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deletePerson(@PathVariable long id){
        repos.remove(id);
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updatePerson(@PathVariable Long id,@ModelAttribute Person person){
        Person oldPerson = repos.get(id);
        oldPerson.setName(person.getName());
        repos.put(id,oldPerson);
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Person findPersonById(@PathVariable Long id){
        Person person = repos.get(id);
        return person;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Person> findPerson(){
        List<Person> persons = new ArrayList<>();
        for(Map.Entry<Long, Person> entry:repos.entrySet()){
            persons.add(entry.getValue());
        }
        return persons;
    }

    @PostMapping(value = "/json/to/properties",produces = "application/properties+person")
    public Person personJsonToProperties(@RequestBody Person person){
        // @RequestBody 的内容是 JSON
        // 响应的内容是 Properties
        return person;
    }
    @PostMapping(value = "/properties/to/json",
            consumes = "application/properties+person", // 请求类型 // Content-Type
            produces =  MediaType.APPLICATION_JSON_UTF8_VALUE// 响应类型 // Accept
    )
    public Person personPropertiesToJson(@RequestBody Person person){
        // @RequestBody 的内容是 Properties
        // 响应的内容是 JSON
        return person;
    }

}
