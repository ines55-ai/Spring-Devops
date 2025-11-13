package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Article;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries.ArticleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article a) {
        return articleRepository.save(a);
    }

    @Override
    public List<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    @Override
    public Article selectArticleById(Long id) {
        return null;
    }

    @Override
    public Article selectArticleById(long id) {
        return articleRepository.findById((int) id).orElse(null);
    }

    @Override
    public List<Article> selectAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteById((int) id.intValue());
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    @Override
    public long countArticles() {
        return articleRepository.count();
    }

    @Override
    public boolean verifArticleById(Long id) {
        return false;
    }

    @Override
    public boolean verifArticleById(long id) {
        return articleRepository.existsById((int) id);
    }
}
