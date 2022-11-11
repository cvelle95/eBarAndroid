package com.example.ebarandroid.repository;

import com.example.ebarandroid.model.ArtikalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtikalRepository extends JpaRepository<ArtikalModel,Long> {
    @Query(nativeQuery = true, value = "SELECT a.* FROM artikal a WHERE a.kategorija_id = :kategorija_id ")
    List<ArtikalModel> getArtikaliByKategorijaId(@Param("kategorija_id")int kategorija_id);

    ArtikalModel getArtikalById(int artikal_id);
}
