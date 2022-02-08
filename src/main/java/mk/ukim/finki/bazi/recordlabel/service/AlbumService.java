package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.entities.Album;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();
    Optional<Album> save(String ime, String vremetraenje, String Artist);
}
