package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDate;

@Entity
@Table(name = "carteFidelite")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class CarteFidelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idCarteFidelite;

    @Column
     int pointAccumules;


     LocalDate dateCreation;

    @OneToOne (mappedBy ="carte") /*le mot carte dans mapped by est le meme dans la classe client*/
            Client client;


}
