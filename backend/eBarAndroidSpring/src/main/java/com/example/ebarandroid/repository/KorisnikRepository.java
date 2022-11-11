package com.example.ebarandroid.repository;

import com.example.ebarandroid.model.KorisnikModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<KorisnikModel,Long> {
    KorisnikModel getKorisnikByUsername(String username);
}
