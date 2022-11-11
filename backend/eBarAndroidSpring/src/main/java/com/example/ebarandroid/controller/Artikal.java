package com.example.ebarandroid.controller;
import com.example.ebarandroid.model.ArtikalModel;
import com.example.ebarandroid.service.ArtikalService;
import com.example.ebarandroid.service.ArtikalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("artikal")
public class Artikal {
    @Autowired
    private ArtikalServiceImpl artikalService;


    @GetMapping("getartiklibykategorijaid")
    @CrossOrigin(origins = "*") //Pronalazi korisnika sa username i inner join-uje omiljene kategorije korisnika
    public List<ArtikalModel> getArtikaliByKategorijaId(int kategorija_id){
        return artikalService.getArtikaliByKategorijaId(kategorija_id);
    }
    @GetMapping("getartikalbyid")
    @CrossOrigin(origins = "*") //Pronalazi korisnika sa username i inner join-uje omiljene kategorije korisnika
    public ArtikalModel getArtikalById(int artikal_id){
        return artikalService.getArtikalById(artikal_id);
    }
}
