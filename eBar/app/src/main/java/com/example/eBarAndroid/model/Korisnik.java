package com.example.eBarAndroid.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class Korisnik {
    private int id;
    private String ime,username,password;

    public static Korisnik getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Korisnik currentUser) {
        Korisnik.currentUser = currentUser;
    }

    private static Korisnik currentUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Korisnik parseKorisnik (JSONObject object){
        Korisnik korisnik = new Korisnik();
        try{
            if (object.has("id")){
                korisnik.setId(Integer.parseInt(object.getString("id")));
            }
            if (object.has("ime")){
                korisnik.setIme(object.getString("ime"));
            }
            if (object.has("username")){
                korisnik.setIme(object.getString("username"));
            }
            if (object.has("password")){
                korisnik.setIme(object.getString("password"));
            }

        }catch (Exception e){

        }
        setCurrentUser(korisnik);
        return korisnik;
    }

    public static LinkedList<Korisnik> loginKorisnik(JSONArray array){
        LinkedList<Korisnik> korisnici = new LinkedList<>();

        try{
            for (int i = 0;i < array.length();i++){
                Korisnik korisnik = parseKorisnik(array.getJSONObject(i));
                korisnici.add(korisnik);
            }
        }catch (Exception e){

        }

        return korisnici;
    }
}
