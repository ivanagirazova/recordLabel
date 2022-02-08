package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.entities.Kolaboracii;
import mk.ukim.finki.bazi.recordlabel.model.entities.KolaboraciiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KolaboraciiRepository extends JpaRepository<Kolaboracii, KolaboraciiId> {
}
