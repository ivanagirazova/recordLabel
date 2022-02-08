package mk.ukim.finki.bazi.recordlabel.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Immutable
public class Pesni {
    @Id
    public Integer id_pesna;
    public String pesna;
    public String artist;
    public String album;
    public String kolaboracija;
    public String vremetraenje;
}
