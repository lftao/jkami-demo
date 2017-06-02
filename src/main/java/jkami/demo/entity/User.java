package jkami.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.javatao.jkami.annotations.Column;
import com.javatao.jkami.annotations.Depth;
import com.javatao.jkami.annotations.Key;
import com.javatao.jkami.annotations.ResultType;
import com.javatao.jkami.annotations.Sql;
import com.javatao.jkami.annotations.Table;

@Depth(2)//嵌套实体查询深度，可不填写默认为2层
@Table("tb_user")//对象表名
public class User implements Serializable {
    private static final long serialVersionUID = 1208054851593657045L;
  
    @Key
    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
    // 默认 是 字段的 小驼峰命名规则 nick_name
    private String nickName;
    
    // 对应数据库字段
    @Column("tel")
    private String mobile;
    
    // 级联查询(如果开启懒加载只在第一次get时候读取) > 可选参数自身实体
    @ResultType(UserOrder.class)
    @Sql("select tb.* from tb_user_order tb where tb.user_id = :id")
    private List<UserOrder> userOrder;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<UserOrder> getUserOrder() {
        return this.userOrder;
    }

    public void setUserOrder(List<UserOrder> userOrder) {
        this.userOrder = userOrder;
    }
}
