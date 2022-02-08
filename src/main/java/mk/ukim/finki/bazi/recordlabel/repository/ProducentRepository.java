package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.entities.Producent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducentRepository extends JpaRepository<Producent,String> {
}
