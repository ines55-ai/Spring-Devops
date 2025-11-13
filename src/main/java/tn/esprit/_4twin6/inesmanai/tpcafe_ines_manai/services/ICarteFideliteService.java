package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;


import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.CarteFidelite;

import java.util.List;

public interface ICarteFideliteService {
    CarteFidelite addCarteFidelite(CarteFidelite c);
    List<CarteFidelite> saveCartesFidelite(List<CarteFidelite> cartes);

    CarteFidelite selectCarteFideliteById(long id);

    CarteFidelite selectCarteFideliteById(Long id);
    List<CarteFidelite> selectAllCartesFidelite();
    void deleteCarteFidelite(CarteFidelite c);
    void deleteCarteFideliteById(Long id);
    void deleteAllCartesFidelite();

    void deleteCarteFideliteById(long id);

    long countingCartesFidelite();

    boolean verifCarteFideliteById(long id);

    long countCartesFidelite();
    boolean verifCarteFideliteById(Long id);
}


