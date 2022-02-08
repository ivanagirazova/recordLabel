package mk.ukim.finki.bazi.recordlabel.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class KolaboraciiId implements Serializable {

    public String embg_artist;

    public Integer id_pesna;

}
