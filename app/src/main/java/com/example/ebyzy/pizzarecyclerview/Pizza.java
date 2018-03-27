package com.example.ebyzy.pizzarecyclerview;

/**
 * Created by ebyzy on 1/25/18.
 */

public class Pizza {
    private  String name;
    private  int imageResourcedId;

    public static final Pizza[] pizzas = {
            new Pizza ("Diavolo",R.mipmap.diavolo),
            new Pizza("Funghi",R.mipmap.funghi)

    };
    private Pizza(String name, int imageResourcedId){
        this.name = name;
        this.imageResourcedId = imageResourcedId;
    }
    public String getName(){
        return name;
    }
    public int getImageResourcedId(){
        return imageResourcedId;
    }
}
