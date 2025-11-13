package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name =" Promotion")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idPromotion;

    @Column(name = "pourcentagePromo")
     String pourcentagePromo;


     LocalDate dateDebutPromotion;


     LocalDate dateFinPromotion;

    @ManyToMany(mappedBy = "promotions")
    List<Article> articles ;
}
