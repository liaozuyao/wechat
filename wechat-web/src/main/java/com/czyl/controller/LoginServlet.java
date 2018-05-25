package com.czyl.controller;

import com.czyl.common.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by liaozuyao on 2018/1/2.
 */

@WebServlet("/wxLogin")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String backUrl = Constants.REDIRECT_URI;
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" +Constants.APPID +
                "&redirect_uri="+ URLEncoder.encode(backUrl)+
                "&response_type=code&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect ";
        resp.sendRedirect(url);
    }
}
