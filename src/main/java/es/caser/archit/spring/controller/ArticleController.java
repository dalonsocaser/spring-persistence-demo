package es.caser.archit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import es.caser.archit.spring.model.Article;
import es.caser.archit.spring.service.IArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	@Autowired
	private IArticleService articleService;

	@GetMapping("/{id}")
	public Article getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id);
		return article;
	}

	@GetMapping
	public List<Article> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return list;
	}

	@PostMapping
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
		boolean flag = articleService.addArticle(article);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping
	public Article updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return article;
	}

	@DeleteMapping("/{id}")
	public Optional<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return Optional.empty();

	}
}
