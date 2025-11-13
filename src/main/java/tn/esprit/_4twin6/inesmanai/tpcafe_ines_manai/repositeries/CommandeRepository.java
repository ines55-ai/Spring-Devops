package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Commande;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.StatusCommande;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    // 🧾 Custom query methods (optional)

    // Find all commandes for a specific client by id
    List<Commande> findByClient_IdClient(Long idClient);

    // Find all commandes by status
    List<Commande> findByStatusCommande(StatusCommande statusCommande);

    // Find commandes between two dates
    List<Commande> findByDateCommandeBetween(LocalDate start, LocalDate end);

    // Find commandes with total greater than a given amount
    List<Commande> findByTotalCommandeGreaterThan(float totalMin);
}
