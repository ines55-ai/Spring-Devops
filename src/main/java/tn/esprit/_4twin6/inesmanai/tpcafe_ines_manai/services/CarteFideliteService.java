package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.entities.CarteFidelite;
import tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.repositeries.CarteFideliteRepository;

import java.util.List;
@Service
public class CarteFideliteService implements ICarteFideliteService {

    @Autowired
    private CarteFideliteRepository carteFideliteRepository;

    @Override
    public CarteFidelite addCarteFidelite(CarteFidelite c) {
        return carteFideliteRepository.save(c);
    }

    @Override
    public List<CarteFidelite> saveCartesFidelite(List<CarteFidelite> cartes) {
        return carteFideliteRepository.saveAll(cartes);
    }

    @Override
    public CarteFidelite selectCarteFideliteById(long id) {
        return null;
    }

    @Override
    public CarteFidelite selectCarteFideliteById(Long id) {
        return carteFideliteRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public List<CarteFidelite> selectAllCartesFidelite() {
        return carteFideliteRepository.findAll();
    }

    @Override
    public void deleteCarteFidelite(CarteFidelite c) {
        carteFideliteRepository.delete(c);
    }

    @Override
    public void deleteCarteFideliteById(Long id) {
        carteFideliteRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public void deleteAllCartesFidelite() {
        carteFideliteRepository.deleteAll();
    }

    @Override
    public void deleteCarteFideliteById(long id) {

    }

    @Override
    public long countingCartesFidelite() {
        return 0;
    }

    @Override
    public boolean verifCarteFideliteById(long id) {
        return false;
    }

    @Override
    public long countCartesFidelite() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifCarteFideliteById(Long id) {
        return carteFideliteRepository.existsById(Math.toIntExact(id));
    }
}
