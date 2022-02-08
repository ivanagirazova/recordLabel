package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.views.Snimanja;

import java.util.List;

public interface SnimanjaViewService {
    List<Snimanja> findAll();
    List<Snimanja> findAllByPesna(String pesna);
}
