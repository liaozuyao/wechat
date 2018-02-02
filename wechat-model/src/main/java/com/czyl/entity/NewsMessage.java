package com.czyl.entity;

import java.util.List;

/**
 * Created by liaozuyao on 2017/12/14.
 */
public class NewsMessage extends BaseMessage{

    private Integer ArticleCount;
    private List<News> Articles;

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}
