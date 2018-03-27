package com.example.ebyzy.pizzarecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PastaDetailActivity extends Activity {
    private ShareActionProvider shareActionProvider;
    public static final  String PASTA_EXTRA ="pastaNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        int pastaNo = (Integer)getIntent().getExtras().get(PASTA_EXTRA);

        String pastaName = Pasta.pastas[pastaNo].getName();
        TextView textView = (TextView)findViewById(R.id.pastaDetail_text);
        textView.setText(pastaName);

        int pastaImage = Pasta.pastas[pastaNo].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.pastaDetail_image);
        imageView.setImageDrawable(getResources().getDrawable(pastaImage));
        imageView.setContentDescription(pastaName);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        TextView textView = (TextView)findViewById(R.id.pastaDetail_text);
        CharSequence pastaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,pastaName );
        shareActionProvider.setShareIntent(intent);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
