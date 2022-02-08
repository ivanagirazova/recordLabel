package mk.ukim.finki.bazi.recordlabel.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(KolaboraciiId.class)
public class Kolaboracii implements Serializable {
    @Id
    public String embg_artist;

    @Id
    public Integer id_pesna;

    public Kolaboracii() {
    }

    public Kolaboracii(String embg_artist, Integer id_pesna) {
        this.embg_artist = embg_artist;
        this.id_pesna = id_pesna;
    }
}
