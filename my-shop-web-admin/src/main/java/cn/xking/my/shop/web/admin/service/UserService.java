package cn.xking.my.shop.web.admin.service;

import cn.xking.my.shop.domain.User;

public interface UserService {
    public User login(String email, String password);
    public void sayHi();
}
