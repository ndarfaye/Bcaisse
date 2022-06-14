package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Vente;
@RestController
//@Repository
public interface VentRepository extends JpaRepository<Vente, Long> {

}
