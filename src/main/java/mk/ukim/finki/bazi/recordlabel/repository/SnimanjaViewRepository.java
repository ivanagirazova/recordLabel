package mk.ukim.finki.bazi.recordlabel.repository;

import mk.ukim.finki.bazi.recordlabel.model.views.Snimanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnimanjaViewRepository extends JpaRepository<Snimanja,Integer> {
    List<Snimanja> findAllByPesna(String pesna);
}
