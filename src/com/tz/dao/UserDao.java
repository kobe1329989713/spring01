package com.tz.dao;

import com.tz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
public class UserDao {
    /**
     *  这个因为它是在 spring 容器里面去获取的，所以你必须在 xx.xml 里面配置好，然后它才可以获取到的，就是
     *  哪个ID
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean saveUser(User user){
        String sql = "INSERT INTO tz_user(username,password,age,address,email)VALUES(?,?,?,?,?)";
        //保存，修改，删除都是update
        int count = jdbcTemplate.update(sql, user.getUsername(),user.getPassword(),
                user.getAge(),user.getAddress(),user.getEmail());
        return count >0?true:false;
    }



    @SuppressWarnings("unchecked")
    public List<User> findUser(){
        String sql = "SELECT id,username,address,`password`,email,create_time FROM tz_user";
        final List<User> users = new ArrayList<User>();
        jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int index) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                users.add(user);
                return user;
            }
        });
        return users;
    }


}
