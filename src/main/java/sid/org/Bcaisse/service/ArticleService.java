package sid.org.Bcaisse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sid.org.Bcaisse.dao.ArticleRepository;
import sid.org.Bcaisse.dto.ListArticle;
import sid.org.Bcaisse.entites.Article;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

  /*  public long save(Article article) {
        return repository.save(article).getId();
    }

    public List<Article> getAll() {
        System.out.println("Get all Articles 11111...");
        return repository.findAll();
    }*/

   public Optional<Article> findByCode(String code) {
       return repository.findByCode(code);
   }
   public List<Article> getAll(){
       return repository.findAll();
   }

    public long save(Article article) {
        return repository.save(article).getId();
    }
    public void update(String code, Article article) {
        Optional<Article> artic = repository.findByCode(code);
        if (artic.isPresent()) {
            Article art = artic.get();
            art.setLibelle(article.getLibelle());
            art.setCcateg(article.getCcateg());
            repository.save(art);
        }
    }

    public List<Article> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(String code) {
        Optional<Article> art = repository.findByCode(code);
        art.ifPresent(repository::delete);
    }

    public List<Article> findByCcateg(String code) {

        return repository.findAllByCcateg(code);

    }

    public List<Article> findByCscateg(String code) {

        return repository.findAllByCscateg(code);

    }

    public int nbre(String code) {

        return repository.nbre(code);

    }


    public int max(String code) {

        return repository.max(code);

    }

    public Optional<Article> findById(Long id) {

        return repository.findById(id);

    }


    public List<ListArticle> listArtf(int code) {
        // TODO Auto-generated method stub
        return repository.listArticleFour(code);

    }
}
