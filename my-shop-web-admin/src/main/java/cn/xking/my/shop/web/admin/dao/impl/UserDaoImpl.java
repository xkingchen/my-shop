package cn.xking.my.shop.web.admin.dao.impl;

import cn.xking.my.shop.domain.User;
import cn.xking.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Override
    public User getUser(String email, String password) {
        logger.debug("调用 getuser(), email:{} password:{}", email, password);

        User user = null;
        if ("admin@xking.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail("admin@xking.com");
                user.setUsername("admin");

                logger.info("成功获取 \"{}\" 的用户信息", user.getUsername());
            }
            else {
                logger.warn("获取 \"{}\" 的用户信息失败", email);
            }
        }
        return user;
    }
}
