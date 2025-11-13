package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdresseResponse {
    Long idAdresse;
    String rue;
    String ville;
    String codePostal;
}
