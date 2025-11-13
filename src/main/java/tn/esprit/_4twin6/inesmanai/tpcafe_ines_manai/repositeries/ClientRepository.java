package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
