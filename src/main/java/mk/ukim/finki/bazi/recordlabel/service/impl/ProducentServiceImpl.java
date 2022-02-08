package mk.ukim.finki.bazi.recordlabel.service.impl;

import mk.ukim.finki.bazi.recordlabel.model.entities.Producent;
import mk.ukim.finki.bazi.recordlabel.repository.ProducentRepository;
import mk.ukim.finki.bazi.recordlabel.service.ProducentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducentServiceImpl implements ProducentService {

    private final ProducentRepository producentRepository;

    public ProducentServiceImpl(ProducentRepository producentRepository) {
        this.producentRepository = producentRepository;
    }

    @Override
    public List<Producent> findAll() {
        return producentRepository.findAll();
    }
}
