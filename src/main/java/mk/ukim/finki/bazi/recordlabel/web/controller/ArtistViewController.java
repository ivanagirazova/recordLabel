package mk.ukim.finki.bazi.recordlabel.web.controller;

import mk.ukim.finki.bazi.recordlabel.model.views.Artisti;
import mk.ukim.finki.bazi.recordlabel.service.ArtistService;
import mk.ukim.finki.bazi.recordlabel.service.ArtistViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistViewController {

    private final ArtistViewService artistViewService;
    private final ArtistService artistService;

    public ArtistViewController(ArtistViewService artistViewService, ArtistService artistService) {
        this.artistViewService = artistViewService;
        this.artistService = artistService;
    }

    @GetMapping
    public String getArtistsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Artisti> artists = this.artistViewService.findAll();
        model.addAttribute("artists", artists);
        model.addAttribute("bodyContent", "artists");
        return "master-template";
    }

    @GetMapping("/add-form")
    public String getAddNewArtistPage (Model model) {
        model.addAttribute("bodyContent", "add-artist");
        return "master-template";
    }

    @PostMapping("/add")
    public String addNewArtist(@RequestParam String embg,
                               @RequestParam String ime,
                               @RequestParam String prezime,
                               @RequestParam String ulica,
                               @RequestParam String broj,
                               @RequestParam String stagename) {
        artistService.save(embg, ime, prezime, ulica, broj, stagename);
        return "redirect:/artists";
    }
}
