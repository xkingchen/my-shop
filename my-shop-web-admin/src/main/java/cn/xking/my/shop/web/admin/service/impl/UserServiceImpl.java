package cn.xking.my.shop.web.admin.service.impl;

import cn.xking.my.shop.domain.User;
import cn.xking.my.shop.web.admin.dao.UserDao;
import cn.xking.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }

    @Override
    public void sayHi() {
        System.out.println("Hi");
    }
}
