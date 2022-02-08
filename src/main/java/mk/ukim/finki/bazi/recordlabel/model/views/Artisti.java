package mk.ukim.finki.bazi.recordlabel.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Immutable
public class Artisti {
    @Id
    public String embg;
    public String artist;
    public String ime;
    public String prezime;
}
