package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Detail_Commande;

import java.util.List;

public interface IDetails_CommandeService {
    Detail_Commande addDetailCommande(Detail_Commande d);
    List<Detail_Commande> saveDetailsCommande(List<Detail_Commande> details);
    Detail_Commande selectDetailCommandeById(long id);
    List<Detail_Commande> selectAllDetailsCommande();
    void deleteDetailCommande(Detail_Commande d);
    void deleteAllDetailsCommande();
    void deleteDetailCommandeById(long id);
    long countingDetailsCommande();
    boolean verifDetailCommandeById(long id);
}
