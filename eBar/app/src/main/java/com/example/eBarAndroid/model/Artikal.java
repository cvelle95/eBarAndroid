package com.example.eBarAndroid.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class Artikal {
    private int id;
    private String naziv;
    private float cena;
    private int kategorija_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getKategorija_id() {
        return kategorija_id;
    }

    public void setKategorija_id(int kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public static Artikal getArtikal (JSONObject object){
        Artikal artikal = new Artikal();
        try{
            if (object.has("id")){
                artikal.setId(Integer.parseInt(object.getString("id")));
            }
            if (object.has("naziv")){
                artikal.setNaziv(object.getString("naziv"));
            }
            if (object.has("cena")){
                artikal.setCena(Float.parseFloat(object.getString("cena")));
            }
            if (object.has("kategorija_id")){
                artikal.setKategorija_id(Integer.parseInt(object.getString("kategorija_id")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return artikal;
    }

    public static LinkedList<Artikal> getArtikliPoKategoriji(JSONArray array){
        LinkedList<Artikal> artikli = new LinkedList<>();

        try{
            for (int i = 0;i < array.length();i++){
                Artikal artikal = getArtikal(array.getJSONObject(i));
                artikli.add(artikal);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return artikli;
    }
}
