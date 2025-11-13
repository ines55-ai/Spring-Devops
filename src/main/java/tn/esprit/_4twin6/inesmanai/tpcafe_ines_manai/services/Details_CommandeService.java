package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import lombok.AllArgsConstructor;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Detail_Commande;

import java.util.List;
@AllArgsConstructor

public class Details_CommandeService implements IDetails_CommandeService{
    @Override
    public Detail_Commande addDetailCommande(Detail_Commande d) {
        return null;
    }

    @Override
    public List<Detail_Commande> saveDetailsCommande(List<Detail_Commande> details) {
        return List.of();
    }

    @Override
    public Detail_Commande selectDetailCommandeById(long id) {
        return null;
    }

    @Override
    public List<Detail_Commande> selectAllDetailsCommande() {
        return List.of();
    }

    @Override
    public void deleteDetailCommande(Detail_Commande d) {

    }

    @Override
    public void deleteAllDetailsCommande() {

    }

    @Override
    public void deleteDetailCommandeById(long id) {

    }

    @Override
    public long countingDetailsCommande() {
        return 0;
    }

    @Override
    public boolean verifDetailCommandeById(long id) {
        return false;
    }
}
