package com.example.eBarAndroid.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private int id;
    private float ukupno;
    private int table_id;
    private String status;
    private List<Stavka> stavkePorudzbine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getUkupno() {
        return ukupno;
    }

    public void setUkupno(float ukupno) {
        this.ukupno = ukupno;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Stavka> getStavkePorudzbine() {
        return stavkePorudzbine;
    }

    public void setStavkePorudzbine(List<Stavka> stavkePorudzbine) {
        this.stavkePorudzbine = stavkePorudzbine;
    }

    public static Order parseOrder (JSONObject object){
        Order order = new Order();
        try{
            if (object.has("id")){
                order.setId(Integer.parseInt(object.getString("id")));
            }
            if (object.has("ukupno")){
                order.setUkupno(Float.parseFloat(object.getString("ukupno")));
            }
            if (object.has("table_id")){
                order.setTable_id(Integer.parseInt(object.getString("table_id")));
            }
            if (object.has("status")){
                order.setStatus(object.getString("status"));
            }
            if (object.has("stavkePorudzbine")){//parsiranje json objekta u objektu
                order.setStavkePorudzbine(Stavka.getStavkePoPorudzbine(object.getJSONArray("stavkePorudzbine")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public static LinkedList<Order> getOrders(JSONArray array){
        LinkedList<Order> orders = new LinkedList<>();

        try{
            for (int i = 0;i < array.length();i++){
                Order order = parseOrder(array.getJSONObject(i));
                orders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return orders;
    }
}
