package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.StatusCommande;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeResponse {
    Long idCommande;
    LocalDate dateCommande;
    float totalCommande;
    StatusCommande statusCommande;
    List<Detail_CommandeResponse> detailC;
}
