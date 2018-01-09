package es.caser.archit.spring.service;

import java.util.List;

import es.caser.archit.spring.model.Article;

public interface IArticleService {
	 List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
