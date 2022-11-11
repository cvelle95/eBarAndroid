package com.example.eBarAndroid.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class Stavka {
    private int id;
    private int artikal_id;
    private float kolicina;
    private float cena;
    private int order_id;

    private Artikal artikalUstavci;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtikal_id() {
        return artikal_id;
    }

    public void setArtikal_id(int artikal_id) {
        this.artikal_id = artikal_id;
    }

    public float getKolicina() {
        return kolicina;
    }

    public void setKolicina(float kolicina) {
        this.kolicina = kolicina;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Artikal getArtikalUstavci() {
        return artikalUstavci;
    }

    public void setArtikalUstavci(Artikal artikalUstavci) {
        this.artikalUstavci = artikalUstavci;
    }

    public static Stavka parseStavka (JSONObject object){
        Stavka stavka = new Stavka();
        try{
            if (object.has("id")){
                stavka.setId(Integer.parseInt(object.getString("id")));
            }
            if (object.has("artikal_id")){
                stavka.setArtikal_id(Integer.parseInt(object.getString("artikal_id")));
            }
            if (object.has("kolicina")){
                stavka.setKolicina(Float.parseFloat(object.getString("kolicina")));
            }
            if (object.has("cena")){
                stavka.setCena(Float.parseFloat((object.getString("cena"))));
            }
            if (object.has("order_id")){
                stavka.setOrder_id(Integer.parseInt(object.getString("order_id")));
            }
            if (object.has("artikal")){//parsiranje json objekta u objektu
                stavka.setArtikalUstavci(Artikal.getArtikal(object.getJSONObject("artikal")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return stavka;
    }

    public static LinkedList<Stavka> getStavkePoPorudzbine(JSONArray array){
        LinkedList<Stavka> stavke = new LinkedList<>();

        try{
            for (int i = 0;i < array.length();i++){
                Stavka stavka = parseStavka(array.getJSONObject(i));
                stavke.add(stavka);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return stavke;
    }


}
