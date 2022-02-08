package mk.ukim.finki.bazi.recordlabel.model.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Producent extends Chovek {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_vraboten;

    public String getName() {
        return ime + " " + prezime;
    }
}
