package cn.xking.my.shop.web.admin.service.impl;

import cn.xking.my.shop.domain.TbUser;
import cn.xking.my.shop.web.admin.dao.TbUserDao;
import cn.xking.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }
}
