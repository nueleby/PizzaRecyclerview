package com.example.ebyzy.pizzarecyclerview;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ebyzy on 1/30/18.
 */

public class PizzaMaterialFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,
                             Bundle savedInstanceState){
        RecyclerView pizzaRecycler = (RecyclerView)layoutInflater.inflate(
                R.layout.pizza_material_fragment, viewGroup, false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i<pizzaNames.length; i++) {
pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i<pizzaImages.length; i++){
            pizzaImages[i] = Pizza.pizzas[i].getImageResourcedId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(gridLayoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.PIZZA_EXTRA, position);
                getActivity().startActivity(intent);
            }
        });
        return pizzaRecycler;
    }
}
