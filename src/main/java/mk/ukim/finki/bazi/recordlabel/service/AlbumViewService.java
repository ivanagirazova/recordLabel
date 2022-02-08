package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.entities.Album;
import mk.ukim.finki.bazi.recordlabel.model.views.Albumi;

import java.util.List;

public interface AlbumViewService {
   List<Albumi> findAll();
   List<Albumi> findAllByArtist(String artist);
}
