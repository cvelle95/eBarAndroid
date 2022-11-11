package com.example.ebarandroid.service;

import com.example.ebarandroid.model.KorisnikModel;

import java.util.LinkedList;

public interface KorisnikService {
    public LinkedList<KorisnikModel> loginUser(String username, String password);
}
