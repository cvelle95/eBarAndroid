package com.example.ebarandroid.service;

import com.example.ebarandroid.controller.Korisnik;
import com.example.ebarandroid.model.KorisnikModel;
import com.example.ebarandroid.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service()
public class KorisnikServiceImpl implements KorisnikService{
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public LinkedList<KorisnikModel> loginUser(String username, String password){
        KorisnikModel user = korisnikRepository.getKorisnikByUsername(username);
        LinkedList<KorisnikModel> korisnici= new LinkedList<>();
        if(user.getPassword().equals(password)){
            korisnici.add(user);
            return korisnici;
        }
        else{
            return null;
        }
    }
}
