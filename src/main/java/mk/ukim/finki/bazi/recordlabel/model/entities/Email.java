package mk.ukim.finki.bazi.recordlabel.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Entity
@IdClass(Email.class)
public class Email implements Serializable {
    @Id
    public String embg;
    @Id
    public String email;
}
