package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name = "Commande")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCommande;

    @Column(name = "date_commande")
    LocalDate dateCommande;

    @Column(name = "total_commande")
    float totalCommande;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_commande")
    StatusCommande statusCommande;
    @ManyToOne
    Client client;
    @OneToMany(mappedBy = "commande")
    List<Detail_Commande> detailC;
}
