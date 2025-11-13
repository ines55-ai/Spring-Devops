package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper MapStruct pour convertir entre entité Client et DTOs ClientRequest / ClientResponse.
 */
@Mapper(componentModel = "spring", uses = {
        AdresseMapper.class,
        CarteFideliteMapper.class,
        CommandeMapper.class
})
public interface ClientMapper {

    // Mapping de l'entité vers le DTO de réponse (inclut les sous-objets)
    @Mapping(target = "adress", source = "adress")
    @Mapping(target = "carte", source = "carte")
    @Mapping(target = "commande", source = "commande")
    ClientResponse toDto(Client client);

    // Mapping de la liste d'entités vers liste de DTOs
    List<ClientResponse> toDtoList(List<Client> clients);

    // Mapping du DTO de requête vers l'entité
    @Mapping(target = "idClient", ignore = true) // ID auto-généré
    @Mapping(target = "commande", ignore = true) // Commandes non présentes dans la requête
    Client toEntity(ClientRequest dto);
}
