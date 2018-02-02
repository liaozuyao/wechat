package com.czyl.utils;

import com.alibaba.fastjson.JSONObject;
import com.czyl.common.Constants;
import com.czyl.entity.AccessToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.*;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liaozuyao on 2017/12/14.
 */
public class WeixinUtils {


//    //测试平台
//    private static final String APPID = "wxe49e176d5d56032f";
//    private static final String APPSECRET = "7264019e9149b660da388312dab10381";

    public static String GETCODEREQUEST = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        CloseableHttpClient clinet = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = clinet.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity != null){
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }

    /**
     * GET
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                String result = EntityUtils.toString(entity,"UTF-8");
                jsonObject = JSONObject.parseObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * POST
     * @param url
     * @param outStr
     * @return
     */
    public static JSONObject doPostStr(String url, String outStr){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(),"UTF-8");
            jsonObject = JSONObject.parseObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 重定向到新页面，返回数据 (GET方式)
     *
     * @param path
     * @return String
     */
    public static String jumpUrl(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(path);
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return sb.toString();
    }

    /**
     * 获取access_token
     * @return
     */
    public static AccessToken getAccessToken(){
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID", Constants.APPID).replace("APPSECRET", Constants.APPSECRET);
        JSONObject jsonObject = doGetStr(url);
        if(jsonObject != null){
            token.setToken(jsonObject.getString("access_token"));
            token.setExpiresIn(jsonObject.getInteger("expires_in"));
        }
        return token;
    }

    public static String getCodeRequest() {
        String result = null;
        GETCODEREQUEST = GETCODEREQUEST.replace("APPID", urlEnodeUTF8(Constants.APPID));
        GETCODEREQUEST = GETCODEREQUEST.replace("REDIRECT_URI", urlEnodeUTF8(Constants.REDIRECT_URI));
        GETCODEREQUEST = GETCODEREQUEST.replace("SCOPE", "snsapi_userinfo");
        result = GETCODEREQUEST;
        return result;
    }

    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String upload(String filePath, String accessToken, String type)throws IOException, NoSuchAlgorithmException{
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()){
            throw new IOException("文件不存在");
        }

        String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);

        //设置请求头
        con.setRequestProperty("Connection", "Keep-Alive");
        con.setRequestProperty("Charset", "UTF-8");
        //设置边界
        String BOUNDARY = "--------" + System.currentTimeMillis();
        con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" +BOUNDARY);
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append("\r\n");
        sb.append("Content-Disposition:form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
        byte[] head = sb.toString().getBytes("utf-8");
        OutputStream out = new DataOutputStream(con.getOutputStream());
        out.write(head);

        //文件正文部分
        //把文件以流文件的方式推送到url中
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while((bytes = in.read(bufferOut)) != -1){
            out.write(bufferOut, 0, bytes);
        }
        in.close();

        //结尾部分
        byte[] foot = ("\r\n--" +BOUNDARY + "--\r\n").getBytes("utf-8");
        out.write(foot);
        out.flush();
        out.close();

        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        String result = null;
        try {
            //定义bufferReader输入流来读取url的响应
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while((line = reader.readLine()) != null){
                buffer.append(line);
            }
            if(result == null){
                result = buffer.toString();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject);
        String typeName = "media_id";
        if(!"image".equals(type)){
            typeName = type + "_media_id";
        }
        String mediaId = jsonObject.getString(typeName);
        return mediaId;
    }

//    /**
//     * 组装菜单
//     * @return
//     */
//    public static Menu initMenu(){
//        Menu menu = new Menu();
//        ClickButton button11 = new ClickButton();
//        button11.setName("click菜单");
//        button11.setType("click");
//        button11.setKey("11");
//
//        ViewButton button21 = new ViewButton();
//        button21.setName("view菜单");
//        button21.setType("view");
//        button21.setUrl("http://www.baidu.com");
//
//        ClickButton button31 = new ClickButton();
//        button31.setName("扫码事件");
//        button31.setType("scancode_push");
//        button31.setKey("31");
//
//        ClickButton button32 = new ClickButton();
//        button32.setName("地理位置");
//        button32.setType("location_select");
//        button32.setKey("32");
//
//        Button button = new Button();
//        button.setName("菜单");
//        button.setSub_button(new Button[]{button31, button32});
//
//        menu.setButton(new Button[]{button11, button21, button});
//        return menu;
//    }

    public static int createMenu(String token, String menu){
        int result = 0;
        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = doPostStr(url, menu);
        if(jsonObject != null){
            result = jsonObject.getInteger("errcode");
        }
        return result;
    }

    public static JSONObject queryMenu(String token){
        String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = doGetStr(url);
        return jsonObject;
    }

    public static Integer deleteMenu(String token){
        int result = 0;
        String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = doGetStr(url);
        if(jsonObject != null){
            result = jsonObject.getInteger("errcode");
        }
        return result;
    }
}
