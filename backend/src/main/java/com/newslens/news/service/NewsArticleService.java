package com.newslens.news.service;

import com.newslens.news.entity.NewsArticle;
import com.newslens.news.repository.NewsArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsArticleService {

    private final NewsArticleRepository newsArticleRepository;

    public NewsArticleService(NewsArticleRepository newsArticleRepository) {
        this.newsArticleRepository = newsArticleRepository;
    }

    public List<NewsArticle> getAllArticles() {
        return newsArticleRepository.findAll();
    }

    public NewsArticle getArticleById(Long id) {
        return newsArticleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public NewsArticle createArticle(NewsArticle article) {
        return newsArticleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        newsArticleRepository.deleteById(id);
    }
}