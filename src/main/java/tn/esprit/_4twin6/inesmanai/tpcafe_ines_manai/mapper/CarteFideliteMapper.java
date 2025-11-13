package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.CarteFidelite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarteFideliteMapper {
    CarteFideliteResponse toDto(CarteFidelite carte);
    List<CarteFideliteResponse> toDtoList(List<CarteFidelite> cartes);
    CarteFidelite toEntity(CarteFideliteRequest dto);
}
