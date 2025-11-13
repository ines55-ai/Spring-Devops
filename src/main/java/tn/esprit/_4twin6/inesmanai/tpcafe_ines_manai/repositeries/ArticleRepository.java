package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
