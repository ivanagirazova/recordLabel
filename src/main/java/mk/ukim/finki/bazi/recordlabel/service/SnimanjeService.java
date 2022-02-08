package mk.ukim.finki.bazi.recordlabel.service;

import mk.ukim.finki.bazi.recordlabel.model.entities.Pesna;
import mk.ukim.finki.bazi.recordlabel.model.entities.Producent;
import mk.ukim.finki.bazi.recordlabel.model.entities.Snimanje;
import mk.ukim.finki.bazi.recordlabel.model.entities.Studio;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

public interface SnimanjeService {
    Optional<Snimanje> save(Date datum, Time chas, Integer pesnaId, String producentId, Integer studioId);
}
