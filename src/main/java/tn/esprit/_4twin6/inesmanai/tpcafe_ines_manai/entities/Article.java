package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idArticle;

    @Column(name = "nom_article")
    String nomArticle;

    @Column(name = "prix_article")
    float prixArticle;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_article")
    TypeArticle typeArticle;
    @OneToMany(mappedBy = "article")
    List<Detail_Commande> detailC;
    @ManyToMany
    List<Promotion> promotions;
}