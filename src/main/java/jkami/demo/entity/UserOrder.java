package jkami.demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.javatao.jkami.annotations.Key;
import com.javatao.jkami.annotations.ResultType;
import com.javatao.jkami.annotations.Sql;
import com.javatao.jkami.annotations.Table;

@Table("tb_user_order")
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 7704723987952806124L;
    @Key
    private Long id;
    private String name;
    private Long userId;
    private Date createDate;

    
    @ResultType(User.class)
    @Sql("select * from tb_user where id = :userId")
    private User user;
    
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

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
