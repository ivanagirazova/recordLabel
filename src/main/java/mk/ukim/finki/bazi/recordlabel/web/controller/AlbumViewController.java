package mk.ukim.finki.bazi.recordlabel.web.controller;

import mk.ukim.finki.bazi.recordlabel.model.entities.Artist;
import mk.ukim.finki.bazi.recordlabel.model.views.Albumi;
import mk.ukim.finki.bazi.recordlabel.service.AlbumService;
import mk.ukim.finki.bazi.recordlabel.service.AlbumViewService;
import mk.ukim.finki.bazi.recordlabel.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumViewController {

    private final AlbumViewService albumViewService;
    private final ArtistService artistService;
    private final AlbumService albumService;

    public AlbumViewController(AlbumViewService albumViewService, ArtistService artistService, AlbumService albumService) {
        this.albumViewService = albumViewService;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getAlbumsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Albumi> albums = this.albumViewService.findAll();
        List<Artist> artists = this.artistService.findAll();
        model.addAttribute("albums", albums);
        model.addAttribute("artists",artists);
        model.addAttribute("bodyContent", "albums");
        return "master-template";
    }

    @GetMapping("/filter")
    public String getAlbumsByArtist(@RequestParam String artist, Model model) {
        List<Albumi> albums = albumViewService.findAllByArtist(artist);
        model.addAttribute("albums",albums);
        List<Artist> artists = this.artistService.findAll();
        model.addAttribute("artists",artists);
        model.addAttribute("bodyContent", "albums");
        return "master-template";
    }

    @GetMapping("/add-form")
    public String getAddNewAlbumPage(Model model) {
        List<Artist> artists = this.artistService.findAll();
        model.addAttribute("artists",artists);
        model.addAttribute("bodyContent","add-album");
        return "master-template";
    }

    @PostMapping("/add")
    public String addNewAlbum(@RequestParam String ime,
                              @RequestParam String vremetraenje,
                              @RequestParam String artist) {
        albumService.save(ime,vremetraenje,artist);
        return "redirect:/albums";
    }

}
