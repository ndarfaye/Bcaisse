package sid.org.Bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sid.org.Bcaisse.dto.ListArticle;
import sid.org.Bcaisse.entites.Article;

import java.util.List;
import java.util.Optional;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByLibelleContaining(String libelle);

    List<Article> findAllByCcateg(String code);

    List<Article> findAllByCscateg(String code);



    @Query(value = "SELECT new sid.org.Bcaisse.dto.ListArticle (a.id,a.code,a.libelle,b.libelle,c.libelle,a.pa,a.pv,a.tva,a.stock,d.libelle,d.code)"
            + " from Article a, Scategorie b, Categorie c, Fournisseur d  where a.cscateg = b.code and b.ccateg = c.code and a.codef = d.code"
            + " and  d.code  = :code")
    List<ListArticle> listArticleFour(@Param("code") int  code);

    Optional<Article> findAllById(Long id);
    @Query(value = "SELECT new sid.org.Bcaisse.dto.ListArticle (a.id,a.code,a.libelle,b.libelle,c.libelle,a.pa,a.pv,a.tva,a.stock,d.libelle,d.code)"
            + " from Article a, Scategorie b, Categorie c, Fournisseur d  where a.cscateg = b.code and b.ccateg = c.code and a.codef = d.code")
    List<ListArticle> listArticle();

    Optional<Article> findByCode(String code);

    @Query(value =   "SELECT count (x)  FROM Article x   WHERE x.cscateg  = :code")
    public int nbre (@Param("code") String  code);

    @Query(value = "SELECT max(code) FROM Article  where cscateg = :code")
    public int max(@Param("code") String  code);


}
