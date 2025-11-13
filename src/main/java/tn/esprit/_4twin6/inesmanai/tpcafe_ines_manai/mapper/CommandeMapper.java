package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { Detail_CommandeMapper.class })
public interface CommandeMapper {

    @Mapping(target = "detailC", source = "detailC")
    CommandeResponse toDto(Commande commande);

    List<CommandeResponse> toDtoList(List<Commande> commandes);

    @Mapping(target = "idCommande", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "detailC", ignore = true)
    Commande toEntity(CommandeRequest dto);
}
