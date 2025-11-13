package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import lombok.AllArgsConstructor;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Promotion;

import java.util.List;
@AllArgsConstructor

public class PromotionService implements IPromotionService {

    @Override
    public Promotion addPromotion(Promotion p) {
        return null;
    }

    @Override
    public List<Promotion> savePromotions(List<Promotion> promotions) {
        return List.of();
    }

    @Override
    public Promotion selectPromotionById(long id) {
        return null;
    }

    @Override
    public List<Promotion> selectAllPromotions() {
        return List.of();
    }

    @Override
    public void deletePromotion(Promotion p) {

    }

    @Override
    public void deleteAllPromotions() {

    }

    @Override
    public void deletePromotionById(long id) {

    }

    @Override
    public long countingPromotions() {
        return 0;
    }

    @Override
    public boolean verifPromotionById(long id) {
        return false;
    }
}
