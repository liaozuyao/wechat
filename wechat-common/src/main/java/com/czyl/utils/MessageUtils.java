package com.czyl.utils;

import com.czyl.entity.News;
import com.czyl.entity.NewsMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by liaozuyao on 2017/12/14.
 */
public class MessageUtils {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_NEWS = "news";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_MUSIC = "music";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSRCIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLIKC = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";
    public static final String MESSAGE_SCANCODE = "scancode_push";
    /**
     * xml转为map
     * @param req
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String, String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = req.getInputStream();
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

//    /**
//     * 将文本消息对象转为xml
//     * @param textMessage
//     * @return
//     */
//    public static String textMessageToXml(TextMessage textMessage){
//        XStream xStream = new XStream();
//        xStream.alias("xml", textMessage.getClass());
//        return xStream.toXML(textMessage);
//    }
//
//    public static String initText(String toUserName, String fromUserName, String content){
//        TextMessage text = new TextMessage();
//        text.setFromUserName(toUserName);
//        text.setToUserName(fromUserName);
//        text.setMsgType(MessageUtils.MESSAGE_TEXT);
//        text.setCreateTime(new Date().getTime());
//        text.setContent("发送的消息是:"+content);
//        return textMessageToXml(text);
//    }

    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("welcome!!!!");
        return sb.toString();
    }

    public static String firstMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("介绍");
        return sb.toString();
    }

    public static String secondMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("介绍2");
        return sb.toString();
    }

    /**
     * 图文消息转为xml
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);
    }

//    public static String imageMessageToXml(ImageMessage imageMessage){
//        XStream xStream = new XStream();
//        xStream.alias("xml", imageMessage.getClass());
//        return xStream.toXML(imageMessage);
//    }
//
//    /**
//     * 音乐消息转xml
//     * @param musicMessage
//     * @return
//     */
//    public static String musicMessageToXml(MusicMessage musicMessage){
//        XStream xStream = new XStream();
//        xStream.alias("xml", musicMessage.getClass());
//        return xStream.toXML(musicMessage);
//    }

    /**
     * 图文消息的组装
     * @param toUserName
     * @param fromUserName
     * @return
     */
    public static String initNewsMessage(String toUserName, String fromUserName){
        String message = null;
        List<News> newsList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();
        News news = new News();
        news.setTitle("介绍");
        news.setDescription("描述");
        news.setPicUrl("http://img5.imgtn.bdimg.com/it/u=49366202,632101467&fm=27&gp=0.jpg");
        news.setUrl("http://admin.hk1.mofasuidao.cn/index.html");
        newsList.add(news);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MESSAGE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());
        message = newsMessageToXml(newsMessage);
        System.out.println(message);
        return message;
    }

//    /**
//     * 组装图片消息
//     * @param toUserName
//     * @param fromUserName
//     * @return
//     */
//    public static String initImageMessage(String toUserName, String fromUserName){
//        String message = null;
//        Image image = new Image();
//        image.setMediaId("");
//        ImageMessage imageMessage = new ImageMessage();
//        imageMessage.setFromUserName(toUserName);
//        imageMessage.setToUserName(fromUserName);
//        imageMessage.setMsgType(MESSAGE_IMAGE);
//        imageMessage.setCreateTime(new Date().getTime());
//        imageMessage.setImage(image);
//        message = imageMessageToXml(imageMessage);
//        return message;
//    }

}
