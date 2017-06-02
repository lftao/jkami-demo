package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.javatao.jkami.Page;
import com.javatao.jkami.SearchFilter;
import com.javatao.jkami.SearchFilter.Operator;

import jkami.demo.dao.IUserDao;
import jkami.demo.dao.IUserOrderDao;
import jkami.demo.entity.User;
import jkami.demo.entity.UserOrder;
import jkami.demo.service.IUserService;

public class UserTest extends BaseTest {
    @Autowired
    private IUserDao userDao;
    
    @Autowired
    private IUserOrderDao userOrderDao;
    
    @Autowired
    private IUserService userService;

    @Test
    public void save() {
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setAge(new Random().nextInt(100));
            user.setBirthday(new Date());
            user.setMobile("12346789");
            user.setNickName("nickName" + i);
            user.setName("name" + i);
            userDao.save(user);
        }
    }

    @Test
    public void findById() {
        User user = userDao.findById(10L);
        if (user != null) {
            System.out.println("#############################");
            System.out.println(JSON.toJSONString(user));
            List<UserOrder> list = user.getUserOrder();
            System.out.println("#############################");
            if (list != null) {
                System.out.println(JSON.toJSONString(list));
            }
        }
    }

    @Test
    public void deleteById() {
        int n = userDao.deleteById(1L);
        System.out.println("##################################### " + n);
    }

    @Test
    public void findListByName() {
        List<User> users = userDao.findListByName("name10");
        System.out.println(JSON.toJSONString(users));
    }

    @Test
    public void countAge() {
        Long size = userDao.countAge(10);
        System.out.println(size);
    }

    @Test
    public void findMapByName() {
        List<Map<String, Object>> list = userDao.findMapByName("name10");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void findPage() {
        Page<User> page = new Page<>();
        // page.addFilter(SearchFilter.newInstance(Operator.get, "age", 10));
        page.setOrder("id asc");
        Page<User> pagevo = userDao.findPage(page);
        System.out.println(JSON.toJSONString(pagevo));
    }

    @Test
    public void findMyPage() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        Page<User> pagevo = userDao.findMyPage(map);
        System.out.println(JSON.toJSONString(pagevo));
    }

    @Test
    public void insertOrders() {
        List<UserOrder> orders = new ArrayList<>();
        UserOrder o1 = new UserOrder();
        o1.setCreateDate(new Date());
        o1.setName("xxxxxxx--1");
        o1.setUserId(10L);
        orders.add(o1);
        UserOrder o2 = new UserOrder();
        o2.setCreateDate(new Date());
        o2.setName("xxxxxxx--2");
        o2.setUserId(10L);
        orders.add(o2);
        userOrderDao.insertOrders(orders);
    }

    @Test
    public void findListByWhereSql() {
        List<User> list = userDao.findList("where id =10");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void findListBySearch() {
        List<SearchFilter> searchFilters = new ArrayList<>();
        searchFilters.add(SearchFilter.newInstance(Operator.eq, "id", 10));
        searchFilters.add(SearchFilter.newInstance(Operator.let, "birthday", new Date()));
        List<User> list = userDao.findList(searchFilters);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void transactionalTest() {
        User user = new User();
        user.setAge(new Random().nextInt(100));
        user.setBirthday(new Date());
        user.setMobile("xxxxxxxxx");
        user.setNickName("nickName_transactional");
        user.setName("name_transactional");
        List<UserOrder> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UserOrder order = new UserOrder();
            order.setCreateDate(new Date());
            order.setName("xxxxxxx--" + i);
            order.setUserId(user.getId());
            orders.add(order);
            order.setUser(user);
        }
        user.setUserOrder(orders);
        userService.addUser(user);
    }
}
