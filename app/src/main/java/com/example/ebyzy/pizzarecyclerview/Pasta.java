package com.example.ebyzy.pizzarecyclerview;

/**
 * Created by ebyzy on 2/9/18.
 */

public class Pasta {
    String name;
    int imageResourceId;

    public static final Pasta [] pastas ={
            new Pasta(" Spahgetti Bolognese", R.mipmap.sphagetti),
            new Pasta("Lasagne",R.mipmap.lasagne),
            new Pasta("Macaroni Twisters",R.mipmap.macaroni)
    };
    private Pasta(String name, int imageResourceId){
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
