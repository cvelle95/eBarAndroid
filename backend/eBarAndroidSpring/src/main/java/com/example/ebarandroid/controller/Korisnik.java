package com.example.ebarandroid.controller;

import com.example.ebarandroid.model.ArtikalModel;
import com.example.ebarandroid.model.KorisnikModel;
import com.example.ebarandroid.service.KorisnikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("korisnik")
public class Korisnik {
    @Autowired
    private KorisnikServiceImpl korisnikService;

    @GetMapping("loginuser")
    @CrossOrigin(origins = "*")
    public LinkedList<KorisnikModel> loginUser(String username, String password){
        return korisnikService.loginUser(username,password);
    }

}
