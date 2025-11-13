package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities;



import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAdresse;

    @Column(name = "rue")
    String rue;

    @Column(name = "ville")
    String ville;

    @Column(name = "code_postal")
    String codePostal;
}