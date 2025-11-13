package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
