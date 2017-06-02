package jkami.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jkami.demo.dao.IUserDao;
import jkami.demo.dao.IUserOrderDao;
import jkami.demo.entity.User;
import jkami.demo.entity.UserOrder;
import jkami.demo.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserOrderDao userOrderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(User u) {
        userDao.save(u);
        List<UserOrder> list = u.getUserOrder();
        if (list != null) {
            userOrderDao.insertOrders(list);
        }
        // int a = 1 / 0;
    }
}
