package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Adresse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    AdresseResponse toDto(Adresse adresse);
    List<AdresseResponse> toDtoList(List<Adresse> adresses);
    Adresse toEntity(AdresseRequest dto);
}
