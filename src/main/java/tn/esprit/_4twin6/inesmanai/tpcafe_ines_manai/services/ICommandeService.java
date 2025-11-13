package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Commande;

import java.util.List;

public interface ICommandeService {
    Commande addCommande(Commande c);
    List<Commande> saveCommandes(List<Commande> commandes);
    Commande selectCommandeById(Long id);

    Commande selectCommandeById(long id);

    List<Commande> selectAllCommandes();
    void deleteCommande(Commande c);
    void deleteCommandeById(Long id);
    void deleteAllCommandes();
    long countCommandes();
    boolean verifCommandeById(Long id);

    void deleteCommandeById(long id);

    long countingCommandes();

    boolean verifCommandeById(long id);

    Commande selectCommandeByIdWithGet(Long id);

    Commande selectCommandeByIdWithOrelse(Long id);
}
