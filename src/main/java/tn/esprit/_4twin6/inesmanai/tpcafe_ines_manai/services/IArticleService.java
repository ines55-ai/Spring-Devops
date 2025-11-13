package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Article;
import java.util.List;

public interface IArticleService {
    Article addArticle(Article a);
    List<Article> saveArticles(List<Article> articles);
    Article selectArticleById(Long id);

    Article selectArticleById(long id);

    List<Article> selectAllArticles();
    void deleteArticleById(Long id);
    void deleteAllArticles();
    long countArticles();
    boolean verifArticleById(Long id);

    boolean verifArticleById(long id);
}
