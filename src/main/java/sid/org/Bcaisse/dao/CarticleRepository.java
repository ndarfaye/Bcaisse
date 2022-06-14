package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Carticle;
import sid.org.Bcaisse.entites.Categorie;

import java.util.List;
import java.util.Optional;

@RestController
//@Repository
public interface CarticleRepository extends JpaRepository<Carticle, Long> {

    Optional<Categorie> findByCode(String code);

    List<Categorie> findAllByLibelleContaining(String libelle);
    @Query(value = "SELECT count(code) FROM Categorie")
    public int nbre();

    @Query(value = "SELECT max(code) FROM Categorie")
    public int max();
}
