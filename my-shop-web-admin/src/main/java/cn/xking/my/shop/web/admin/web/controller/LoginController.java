package cn.xking.my.shop.web.admin.web.controller;

import cn.xking.my.shop.commons.constants.ConstantsUtils;
import cn.xking.my.shop.commons.utils.CookieUtils;
import cn.xking.my.shop.domain.User;
import cn.xking.my.shop.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest){
        String userInfo = CookieUtils.getCookieValue(httpServletRequest, COOKIE_NAME_USER_INFO);
        if (StringUtils.isNotBlank(userInfo)) {
            String[] userInfoArr = userInfo.split(":");
            String email = userInfoArr[0];
            String password = userInfoArr[1];
            httpServletRequest.setAttribute("email", email);
            httpServletRequest.setAttribute("password", password);
            httpServletRequest.setAttribute("isRemember", true);
        }
        return "login";
    }

    /**
     * 登陆逻辑
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    private String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, @RequestParam(required = false) String isRemember, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean isRememberResult = (isRemember == null ? false : true);
        User user = userService.login(email, password);

        if (!isRememberResult) {
            CookieUtils.deleteCookie(httpServletRequest, httpServletResponse, COOKIE_NAME_USER_INFO);
        }
        if (user == null) {
            httpServletRequest.setAttribute("message", "用户名或密码错误");
            return login(httpServletRequest);
        }
        else {
            if (isRememberResult) {
                CookieUtils.setCookie(httpServletRequest, httpServletResponse, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }
            httpServletRequest.getSession().setAttribute(ConstantsUtils.SESSION_USER, user);
            return "redirect:/main";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    private String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return login(httpServletRequest);
    }
}
