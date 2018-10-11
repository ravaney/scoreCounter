package com.example.lewis.scorecounter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testactivity extends AppCompatActivity {

    private TextView win, tally;
    private Button call, map, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testactivity);

        android.content.Intent intent = getIntent();

        final String winner = intent.getStringExtra(Activity2.EXTRA_TEXT);
        final int winby = intent.getIntExtra(Activity2.EXTRA_NUM,0);
        final int lose = intent.getIntExtra(Activity2.EXTRA_NUM2,0);

         win = (TextView) findViewById(R.id.winner);
         call = findViewById(R.id.call);
         map = findViewById(R.id.map);
         text = findViewById(R.id.text);
        // tally = (TextView) findViewById(R.id.winner);
         win.setText("Congratulations team "+winner+", you won by "+winby+"-" +lose);
         final String message = ("Congratulations team "+winner+", you have won by "+winby+" "+lose);


         call.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 android.content.Intent call = new android.content.Intent(Intent.ACTION_DIAL, Uri.parse("tel:8888888888"));
                 Intent chooser = Intent.createChooser(call, "Make a call with");
                 if (call.resolveActivity(getPackageManager()) != null) {
                     startActivity(chooser);
                 }
                 startActivity(chooser);

             }
         });

         text.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent text = new Intent(Intent.ACTION_SEND);
                 text.setType("text/plain");
                 text.putExtra(Intent.EXTRA_TEXT,message);
                 Intent chooser = Intent.createChooser(text,"Send a text");

                 startActivity(chooser);
                 //startActivity(Intent.createChooser(text,getResources().getString(R.String.share_using)));
             }
         });

         map.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent map = new Intent(Intent.ACTION_VIEW,Uri.parse("geo: 0,0?q=Soccer stadiums near me"));
                 //map.setType("text/plain");
                 map.putExtra(Intent.EXTRA_TEXT,"Soccer stadiums near me");
                 //map.putExtra(Intent.EXTRA_TEXT,)
                 Intent chooser = Intent.createChooser(map, "Select a map App");
                 startActivity(chooser);


             }
         });





    }
}
