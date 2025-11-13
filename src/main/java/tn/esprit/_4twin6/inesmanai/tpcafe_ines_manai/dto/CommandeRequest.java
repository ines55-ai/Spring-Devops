package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.StatusCommande;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeRequest {
    LocalDate dateCommande;
    float totalCommande;
    StatusCommande statusCommande;
    Long clientId; // pour lier à un client existant
}
