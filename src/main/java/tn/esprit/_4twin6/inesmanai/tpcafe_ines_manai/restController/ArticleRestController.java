package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.restController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Article;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services.IArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Tag(name = "📰 Articles")
public class ArticleRestController {

    private final IArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.selectAllArticles();
    }

    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PostMapping("/addall")
    public List<Article> addArticles(@RequestBody List<Article> articles) {
        return articleService.saveArticles(articles);
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.selectArticleById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return "Article with ID " + id + " deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllArticles() {
        articleService.deleteAllArticles();
        return "All articles deleted successfully";
    }

    @GetMapping("/count")
    public long countArticles() {
        return articleService.countArticles();
    }

    @GetMapping("/exists/{id}")
    public boolean verifArticleById(@PathVariable Long id) {
        return articleService.verifArticleById(id);
    }
}
