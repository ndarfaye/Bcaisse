package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Compteur;

import java.util.Optional;

@RestController
@Repository
public interface CompteurRepository extends JpaRepository<Compteur, Long> {
   Optional<Compteur> findByAnnee(int annee);

    @Query("SELECT COUNT(y) FROM Compteur y where y.annee = :annee")
    public int nbre(@Param("annee") int annee);
}
