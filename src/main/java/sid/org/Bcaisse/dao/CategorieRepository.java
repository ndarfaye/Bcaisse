package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Categorie;

import java.util.List;
import java.util.Optional;

@RestController
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
   Optional<Categorie> findByCode(String code);
    List<Categorie> findAllByLibelleContaining(String libelle);
    @Query(value = "SELECT COUNT(code) FROM Categorie ")
    public int nbre();
    @Query(value = "SELECT max(code) FROM Scategorie")
    public int max();

}
