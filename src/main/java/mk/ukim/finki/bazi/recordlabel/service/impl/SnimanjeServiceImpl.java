package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Pesna;
import mk.ukim.finki.bazi.recordlabel.model.entities.Producent;
import mk.ukim.finki.bazi.recordlabel.model.entities.Snimanje;
import mk.ukim.finki.bazi.recordlabel.model.entities.Studio;
import mk.ukim.finki.bazi.recordlabel.repository.PesnaRepository;
import mk.ukim.finki.bazi.recordlabel.repository.ProducentRepository;
import mk.ukim.finki.bazi.recordlabel.repository.SnimanjeRepository;
import mk.ukim.finki.bazi.recordlabel.repository.StudioRepository;
import mk.ukim.finki.bazi.recordlabel.service.SnimanjeService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

@Service
public class SnimanjeServiceImpl implements SnimanjeService {

    private final SnimanjeRepository snimanjeRepository;
    private final PesnaRepository pesnaRepository;
    private final ProducentRepository producentRepository;
    private final StudioRepository studioRepository;

    public SnimanjeServiceImpl(SnimanjeRepository snimanjeRepository, PesnaRepository pesnaRepository, ProducentRepository producentRepository, StudioRepository studioRepository) {
        this.snimanjeRepository = snimanjeRepository;
        this.pesnaRepository = pesnaRepository;
        this.producentRepository = producentRepository;
        this.studioRepository = studioRepository;
    }

    @Override
    public Optional<Snimanje> save(Date datum, Time chas, Integer pesnaId, String producentId, Integer studioId) {
        Pesna pesna = pesnaRepository.findById(pesnaId).get();
        Producent producent = producentRepository.findById(producentId).get();
        Studio studio = studioRepository.findById(studioId).get();
        Snimanje snimanje = new Snimanje(datum,chas,producent,pesna,studio);
        return Optional.of(snimanjeRepository.save(snimanje));
    }
}
