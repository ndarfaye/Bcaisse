package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Panier;

import java.util.List;

@RestController
@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
    List<Panier> findAllByNom(String nom);
}
