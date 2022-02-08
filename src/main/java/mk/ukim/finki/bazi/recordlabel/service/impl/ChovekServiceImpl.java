package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Chovek;
import mk.ukim.finki.bazi.recordlabel.repository.ChovekRepository;
import mk.ukim.finki.bazi.recordlabel.service.ChovekService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChovekServiceImpl implements ChovekService {

    private final ChovekRepository chovekRepository;

    public ChovekServiceImpl(ChovekRepository chovekRepository) {
        this.chovekRepository = chovekRepository;
    }

    @Override
    public Optional<Chovek> save(String embg, String ime, String prezime, String ulica, String broj) {
        Chovek chovek = new Chovek(embg,ime,prezime,ulica,broj);
        return Optional.of(chovekRepository.save(chovek));
    }
}
