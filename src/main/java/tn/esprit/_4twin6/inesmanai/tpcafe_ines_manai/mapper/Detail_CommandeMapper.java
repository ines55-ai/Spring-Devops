package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Detail_Commande;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ArticleMapper.class })
public interface Detail_CommandeMapper {
    Detail_CommandeResponse toDto(Detail_Commande detail);
    List<Detail_CommandeResponse> toDtoList(List<Detail_Commande> details);
    Detail_Commande toEntity(Detail_CommandeRequest dto);
}
