package jkami.demo.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jkami.demo.entity.User;
import jkami.demo.service.IUserService;

/**
 * indexController
 * 
 * @author TLF
 */
@Controller
@RequestMapping
public class IndexController implements  InitializingBean{
    @Autowired
    private IUserService userService;
    
    
    @ResponseBody
    @RequestMapping("index")
    public String index() {
        User user = new User();
        user.setAge(new Random().nextInt(100));
        user.setBirthday(new Date());
        user.setMobile("123456");
        user.setNickName("nickName");
        user.setName("name");
        userService.addUser(user);
        return "";
    }


    @Override
    public void afterPropertiesSet() throws Exception {
       System.out.println("IndexController init ");
        
    }
}
