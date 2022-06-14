package sid.org.Bcaisse.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String libcourt;
    private String libelle;
    private String adresse;
    private String mf;
    private String email;
    private String rib;
    private String tel;
    private int numc;
    private int  numf;

   /* @Override
    public String toString() {
        return "Parametre [id=" + id + ", libcourt=" + libcourt + ", libelle=" + libelle + ", adresse=" + adresse
                + ", mf=" + mf + ", email=" + email + ", rib=" + rib + ", tel=" + tel + ", numc=" + numc + ", numf="
                + numf + "]";
    }*/
}
