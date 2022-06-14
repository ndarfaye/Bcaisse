package sid.org.Bcaisse.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sid.org.Bcaisse.entites.Scategorie;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScategorieRepository extends JpaRepository<Scategorie, Long> {
    Optional<Scategorie> findByCode(String code);
    List<Scategorie> findAllByLibelleContaining(String libelle);
    List<Scategorie> findAllByCcateg(String code);
    @Query("SELECT COUNT(y) From Scategorie y where y.ccateg = :code")
    public int nbre(@Param("code") String code);
    @Query("SELECT max(code) FROM  Scategorie where ccateg = :code")
    public int max(@Param("code") String code);
}
