package cn.xking.my.shop.web.admin.service.test;

import cn.xking.my.shop.domain.TbUser;
import cn.xking.my.shop.web.admin.dao.TbUserDao;
import cn.xking.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-mybatis.xml", "classpath:spring-context-druid.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println("this is print :" + tbUser.getName());
        }
    }
}
