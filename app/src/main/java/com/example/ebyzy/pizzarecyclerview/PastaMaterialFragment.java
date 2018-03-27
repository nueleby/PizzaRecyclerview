package com.example.ebyzy.pizzarecyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PastaMaterialFragment extends android.app.Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pastaRecycler = (RecyclerView)inflater.inflate(
                R.layout.pasta_material_fragment,container,false);

        String [] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++){
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int [] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; i++){
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames,pastaImages);
        pastaRecycler.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        pastaRecycler.setLayoutManager(gridLayoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.PASTA_EXTRA, position);
                getActivity().startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return pastaRecycler;
    }

}
