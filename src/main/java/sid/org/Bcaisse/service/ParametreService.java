package sid.org.Bcaisse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sid.org.Bcaisse.dao.ParametreRepository;
import sid.org.Bcaisse.entites.Parametre;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParametreService {
    @Autowired
    ParametreRepository repository;

   public List<Parametre> getAll() {
        System.out.println("Get all Parametres 11111...");
        return repository.findAll(Sort.by("libelle").ascending());
    }


    public Optional<Parametre> findById(long id) {
        return repository.findById(id);
    }

    public long save(Parametre Parametre) {
        System.out.println("save  all Parametres 11111...");

        return repository.save(Parametre)
                .getId();
    }
    public void update(long id, Parametre Parametre) {
        Optional<Parametre> param = repository.findById(id);
        if (param.isPresent()) {
            Parametre para = param.get();
            para.setLibelle(Parametre.getLibelle());
            repository.save(para);
        }
    }
    public void delete(long id) {
        Optional<Parametre> param = repository.findById(id);
        param.ifPresent(repository::delete);
    }
}
