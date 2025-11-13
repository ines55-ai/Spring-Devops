package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Promotion;

import java.util.List;

public interface IPromotionService {
    Promotion addPromotion(Promotion p);
    List<Promotion> savePromotions(List<Promotion> promotions);
    Promotion selectPromotionById(long id);
    List<Promotion> selectAllPromotions();
    void deletePromotion(Promotion p);
    void deleteAllPromotions();
    void deletePromotionById(long id);
    long countingPromotions();
    boolean verifPromotionById(long id);
}
