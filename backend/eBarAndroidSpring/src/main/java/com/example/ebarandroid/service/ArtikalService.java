package com.example.ebarandroid.service;

import com.example.ebarandroid.model.ArtikalModel;

import java.util.List;

public interface ArtikalService {
    public List<ArtikalModel> getArtikaliByKategorijaId(int kategorija_id);
    public ArtikalModel getArtikalById(int artikal_id);
}
