package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Fournisseur;

import java.util.List;
import java.util.Optional;

@RestController
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    List<Fournisseur> findAllByLibelleContaining(String libelle);
    Optional<Fournisseur> findByCode(int code);
    List<Fournisseur> findAllByEmail(String email);

}
