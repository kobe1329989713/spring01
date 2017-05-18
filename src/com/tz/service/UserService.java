package com.tz.service;

import com.tz.dao.UserDao;
import com.tz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Administrator
 * @Date:2017/5/19 5:13
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean saveUser(User user){
        return userDao.saveUser(user);
    }

    public List<User> findUser(){
        return userDao.findUser();
    }
}
