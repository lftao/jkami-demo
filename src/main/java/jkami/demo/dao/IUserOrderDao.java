package jkami.demo.dao;

import java.util.List;

import com.javatao.jkami.annotations.ExecuteUpdate;
import com.javatao.jkami.annotations.KaMiDao;
import com.javatao.jkami.annotations.Param;

import jkami.demo.entity.UserOrder;

@KaMiDao
public interface IUserOrderDao {
    // 执行更新插入，需要返回值
    @ExecuteUpdate
    int[] insertOrders(@Param("orders") List<UserOrder> orders);

    // 执行更新插入，不需要返回值 可以不用 @ExecuteUpdate
    void insertOrdersVoid(@Param("orders") List<UserOrder> orders);
}
