package sid.org.Bcaisse.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sid.org.Bcaisse.dao.FournisseurRepository;
import sid.org.Bcaisse.dao.ParametreRepository;
import sid.org.Bcaisse.dao.UserRepository;
import sid.org.Bcaisse.entites.Fournisseur;
import sid.org.Bcaisse.entites.Parametre;
import sid.org.Bcaisse.entites.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class FournisseurService {
    @Autowired
    FournisseurRepository repository;
    @Autowired
    ParametreRepository paramRepository;
    @Autowired
    UserRepository userRepository;

    final private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public List<Fournisseur> getAll() {
        log.info("return all Fournisseur");
        System.out.println("Get all Fournisseurs 11111...");
        return repository.findAll(Sort.by("libelle").ascending());
    }


    public Optional<Fournisseur> findByCode(int id) {
        log.info("get by code refference");
        return repository.findByCode(id);
    }

    public long save(Fournisseur Four) {
        System.out.println("save  all Fournisseurs 11111...");
        long id = 1;
        Optional<Parametre> ParamInfo = paramRepository.findById(id);
        if (ParamInfo.isPresent()) {
            Parametre param = ParamInfo.get();
            param.setNumf(param.getNumf()+1);
            param = paramRepository.save(param);
        }
        User user = new User();
        user.setUsername(Four.getEmail());
        user.setNom(Four.getLibelle());
        user.setCode(Four.getCode());
        user.setEmail(Four.getEmail());
        user.setPassword(Four.getPwd());
        user.setRole("FOUR");
        user.setActive(true);
        userRepository.save(user);
        return repository.save(Four).getId();
    }


    public void update(int code, Fournisseur Fournisseur) {
        Optional<Fournisseur> four = repository.findByCode(code);
        if (four.isPresent()) {
            Fournisseur fr = four.get();
            fr.setLibelle(Fournisseur.getLibelle());
            fr.setAdresse(Fournisseur.getAdresse());
            repository.save(fr);
        }
    }


    public List<Fournisseur> findByEmail(String email) {

        return repository.findAllByEmail(email);
    }

    public List<Fournisseur> findByLibelle(String libelle) {

        return repository.findAllByLibelleContaining(libelle);
    }

    public void delete(int code) {
        Optional<Fournisseur> cat = repository.findByCode(code);
        cat.ifPresent(repository::delete);
    }

}
