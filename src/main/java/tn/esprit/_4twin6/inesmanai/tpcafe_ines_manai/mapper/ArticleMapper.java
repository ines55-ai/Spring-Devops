package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PromotionMapper.class })
public interface ArticleMapper {
    ArticleResponse toDto(Article article);
    List<ArticleResponse> toDtoList(List<Article> articles);
    Article toEntity(ArticleRequest dto);
}
