package com.example.a1505197.mozilla10;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mozillaTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mozillaTextView= (TextView) findViewById(R.id.mozillaText);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"fonts/camp.ttf");
        mozillaTextView.setTypeface(customfont);
        Thread thread=new Thread()
        {
            public void run()
            {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();

    }
}
