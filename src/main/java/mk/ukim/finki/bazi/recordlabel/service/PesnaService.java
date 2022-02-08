package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.entities.Pesna;

import java.util.List;
import java.util.Optional;

public interface PesnaService  {
    Optional<Pesna> save(String ime, String vremetraenje, String artist, Integer album, String collaborator);
    List<Pesna> findAll();
}
