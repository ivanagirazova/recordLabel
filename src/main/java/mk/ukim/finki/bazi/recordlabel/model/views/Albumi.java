package mk.ukim.finki.bazi.recordlabel.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Immutable
public class Albumi {
    @Id
    public Integer id_album;
    public String artist;
    public String album;
    public String duration;
}
