package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarteFideliteResponse {
    Long idCarteFidelite;
    int pointsAccumule;
    LocalDate dateCreation;
}
