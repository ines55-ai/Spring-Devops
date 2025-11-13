package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Details_Commande")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Detail_Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idDetailCommande;

    @Column(name = "quantiteArticle")
     int quantiteArticle;

    @Column(name = "sousTotalDetailArticle")
     float sousTotalDetailArticle;

    @Column(name = "sousTotalDetailArticleApresPromo")
     float sousTotalDetailArticleApresPromo;

    @ManyToOne
    Commande commande;
    @ManyToOne
    Article article;
}

