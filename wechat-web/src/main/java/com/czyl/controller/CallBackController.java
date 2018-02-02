package com.czyl.controller;

import com.alibaba.fastjson.JSONObject;
import com.czyl.common.Constants;
import com.czyl.entity.User;
import com.czyl.service.UserService;
import com.czyl.utils.WeixinUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by liaozuyao on 2018/1/2.
 */
@Controller
public class CallBackController extends BaseController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/wxLogin", method = RequestMethod.GET)
    public void wxLogin(HttpServletResponse response) throws IOException{
        String backUrl = Constants.REDIRECT_URI;
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +Constants.APPID +
                "&redirect_uri="+ URLEncoder.encode(backUrl)+
                "&response_type=code&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect ";
        response.sendRedirect(url);
    }

    @RequestMapping(value = "/callBack", method = RequestMethod.GET)
    public String getLogin(@RequestParam("code") String code, HttpServletRequest req) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Constants.APPID +
                "&secret=" + Constants.APPSECRET +
                "&code=" + code +
                "&grant_type=authorization_code";
        JSONObject jsonObject = null;
        try {
            jsonObject = WeixinUtils.doGetJson(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String openId = jsonObject.getString("openid");
        String token = jsonObject.getString("access_token");
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token +
                "&openid=" + openId +
                "&lang=zh_CN";
        JSONObject userInfo = WeixinUtils.doGetStr(infoUrl);
        System.out.println(userInfo);
        String openIdStr = userInfo.getString("openid");
        String name = userInfo.getString("nickname");
        String path = (String) req.getAttribute("path");
        System.out.println(openIdStr + "\t" + name + "\t" + path);
        User users = userService.selectUserExist(openIdStr);
        if (users != null) {
            req.getSession().setAttribute("user", users);
        } else {
            User user = new User();
            user.setOpenId(openIdStr);
            user.setName(name);
            userService.insertUser(user);
            req.getSession().setAttribute("user", user);
        }
        return path;
    }
}
