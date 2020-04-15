package cn.xking.my.shop.web.admin.dao;

import cn.xking.my.shop.domain.User;

public interface UserDao {
    public User getUser(String email, String password);
}
