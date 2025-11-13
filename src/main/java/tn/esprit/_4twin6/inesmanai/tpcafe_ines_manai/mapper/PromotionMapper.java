package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.mapper;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.dto.*;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Promotion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    PromotionResponse toDto(Promotion promotion);
    List<PromotionResponse> toDtoList(List<Promotion> promotions);
    Promotion toEntity(PromotionRequest dto);
}
