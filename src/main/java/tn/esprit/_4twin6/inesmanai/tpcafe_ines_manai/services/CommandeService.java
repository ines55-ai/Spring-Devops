package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Commande;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries.CommandeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;

    @Override
    public Commande addCommande(Commande c) {
        return commandeRepository.save(c);
    }

    @Override
    public List<Commande> saveCommandes(List<Commande> commandes) {
        return commandeRepository.saveAll(commandes);
    }

    @Override
    public Commande selectCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> selectAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public void deleteCommande(Commande c) {
        commandeRepository.delete(c);
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public void deleteAllCommandes() {
        commandeRepository.deleteAll();
    }

    @Override
    public long countCommandes() {
        return commandeRepository.count();
    }

    @Override
    public boolean verifCommandeById(Long id) {
        return commandeRepository.existsById(id);
    }

    // Deprecated duplicate methods — we implement once only
    @Override
    public Commande selectCommandeById(long id) {
        return selectCommandeById(Long.valueOf(id));
    }

    @Override
    public void deleteCommandeById(long id) {
        deleteCommandeById(Long.valueOf(id));
    }

    @Override
    public long countingCommandes() {
        return countCommandes();
    }

    @Override
    public boolean verifCommandeById(long id) {
        return verifCommandeById(Long.valueOf(id));
    }

    @Override
    public Commande selectCommandeByIdWithGet(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public Commande selectCommandeByIdWithOrelse(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }
}
