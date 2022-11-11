package com.example.ebarandroid.service;

import com.example.ebarandroid.model.ArtikalModel;
import com.example.ebarandroid.repository.ArtikalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ArtikalServiceImpl implements ArtikalService{

    @Autowired
    private ArtikalRepository artikalRepository;

    @Override
    public List<ArtikalModel> getArtikaliByKategorijaId(int kategorija_id){
        System.out.println("Gadjan Servis : "+kategorija_id);
        return artikalRepository.getArtikaliByKategorijaId(kategorija_id);
    }

    @Override
    public ArtikalModel getArtikalById(int artikal_id){
        return artikalRepository.getArtikalById(artikal_id);
    }
}
