package cn.xking.my.shop.web.admin.dao;

import cn.xking.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "TbUserDao")
public interface TbUserDao {
    public List<TbUser> selectAll();
}
