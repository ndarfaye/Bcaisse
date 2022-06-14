package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import sid.org.Bcaisse.entites.Client;

import java.util.List;
import java.util.Optional;

@RestController
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select i from Client i where i.code = :id ")
    Optional<Client> findByCode(int id);
    Optional<Client> findById(int id);
    List<Client> findAllByLibelleContaining(String libelle);
    List<Client> findAllByEmail(String email);
}
