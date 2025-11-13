package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.TypeArticle;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    Long idArticle;
    String nomArticle;
    float prixArticle;
    TypeArticle typeArticle;
    List<PromotionResponse> promotions;
}
