package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Parametre;
@RestController
@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long> {
}
