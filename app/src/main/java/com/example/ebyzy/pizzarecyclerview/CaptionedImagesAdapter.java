package com.example.ebyzy.pizzarecyclerview;

import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ebyzy on 1/29/18.
 */
 class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {
    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener{
        public void onClick(int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;

        }
    }
    public CaptionedImagesAdapter(String[] captions, int[] imageIds){
        this.captions = captions;
        this.imageIds = imageIds;
    }
    public void setListener(Listener listener){
        this.listener = listener;
    }


        @Override
        public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_captioned_image, viewGroup, false);
        return new ViewHolder(cv);
        }

        public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
            ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
            Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(captions[position]);
            TextView textView = (TextView)cardView.findViewById(R.id.info_text);
            textView.setText(captions[position]);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onClick(position);
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
        return captions.length;

        }

}
