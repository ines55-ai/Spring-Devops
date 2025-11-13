package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Detail_CommandeResponse {
    Long idDetailCommande;
    int quantiteArticle;
    float sousTotalDetailArticle;
    float sousTotalDetailArticleApresPromo;
    ArticleResponse article;
}
