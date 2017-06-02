package jkami.demo.dao;

import java.util.List;
import java.util.Map;

import com.javatao.jkami.Page;
import com.javatao.jkami.annotations.KaMiDao;
import com.javatao.jkami.annotations.PageQuery;
import com.javatao.jkami.annotations.Param;
import com.javatao.jkami.annotations.ResultType;
import com.javatao.jkami.annotations.Sql;
import com.javatao.jkami.support.KaMiDaoInterface;

import jkami.demo.entity.User;

@KaMiDao
@ResultType(User.class)
public interface IUserDao extends KaMiDaoInterface<User> {
    /**
     * 根据名字查找user
     * 
     * @param name
     * @return
     */
    User findUserByMobile(@Param("tel") Long mobile);

    /**
     * 查找集合
     * 
     * @param name
     * @return
     */
    List<User> findListByName(@Param("name") String name);

    // :age or ${age}
    @ResultType(Long.class)
    @Sql("select count(1) from tb_user where age > :age ")
    Long countAge(@Param("age") int age);

    /**
     * 返回map
     * 
     * @param name
     * @return
     */
    @ResultType(Map.class)
    List<Map<String, Object>> findMapByName(@Param("name") String name);

    /**
     * 自定义分页
     * 
     * @param map
     * @return
     */
    @PageQuery
    Page<User> findMyPage(@Param("map") Map<String, Object> map);
    
}
