package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.entities.Snimanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnimanjeRepository extends JpaRepository<Snimanje,Integer> {
}
