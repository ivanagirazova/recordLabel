package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.views.Pesni;

import java.util.List;

public interface PesniViewService {
    List<Pesni> findAll();
    List<Pesni> findAllByArtist(String artist);
    List<Pesni> findAllByAlbum(String album);
}
