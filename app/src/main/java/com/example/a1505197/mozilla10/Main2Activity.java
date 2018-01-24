package com.example.a1505197.mozilla10;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar;
    TextView  screen;
    String display="",currentoperator="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.etcontactToolbar);
        screen= (TextView) findViewById(R.id.screen);
        screen.setText(display);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MOZILLA CALCULATOR");
        getSupportActionBar().setElevation(10f);

    }
    public void updateScreen()
    {
        screen.setText(display);
    }
    public void onClickNumber(View view)
    {
        Button b=(Button)view;
        display+=b.getText();
        updateScreen();
    }
    public  void onClickOperator(View view)
    {
        Button b=(Button)view;
        display+=b.getText();
        currentoperator=b.getText().toString();
        updateScreen();
    }
    private double operateArithmetic(String a,String b,String op)
    {
        switch(op)
        {
            case "+":
                return(Double.valueOf(a)+Double.valueOf(b));
            case "-":
                return(Double.valueOf(a)-Double.valueOf(b));
            case "*":
                return(Double.valueOf(a)*Double.valueOf(b));
            case "/":
                try
                {
                    return(Double.valueOf(a)/Double.valueOf(b));
                }
                catch (Exception e)
                {

                }
                default:
                    return -1;


        }
    }
    public  void onClickEqual(View view)
    {
        String[] operation=display.split(Pattern.quote(currentoperator));
        Double result;
        if(operation.length>1)
        {
            result=operateArithmetic(operation[0],operation[1],currentoperator);
            screen.setText(display+"\n"+String.valueOf(result));
        }
    }
    public void clear()
    {
        display="";
        currentoperator="";

    }
    public void onClickScreen(View view)
    {
        clear();
        updateScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
      if(item.getItemId()==R.id.aboutus)
      {
          View layout = getLayoutInflater().inflate(R.layout.aboutus, (ViewGroup) findViewById(R.id.customtoast));
          Toast toast=new Toast(getApplicationContext());
          toast.setDuration(Toast.LENGTH_LONG);
          toast.setGravity(119, 0, 0);
          toast.setView(layout);
          toast.show();

      }
      else if(item.getItemId()==R.id.setting)
          {
              Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
              startActivity(settingsIntent);
          }
          else if(item.getItemId()==R.id.share)
      {
          Intent shareIntent = new Intent(Intent.ACTION_SEND);
          shareIntent.setType("text/plain");
          startActivity(shareIntent);
      }
      else if(item.getItemId()==R.id.email)
      {
          Intent intent=new Intent(Intent.ACTION_SEND);
          intent.setData(Uri.parse("Mailto:"));
          String [] to={"ashutoshrai181094@gmail.com"};
          intent.putExtra(Intent.EXTRA_EMAIL,to);
          intent.putExtra(Intent.EXTRA_SUBJECT,"Hi this was sent from my app");
          intent.putExtra(Intent.EXTRA_TEXT,"Hey whats up what are u doing");
          intent.setType("text/html");
          startActivity(Intent.createChooser(intent, "Send Email"));
      }
      else if(item.getItemId()==R.id.sharesingle)
      {
          Uri imageUri=Uri.parse("android.resource://com.example.a1505197.mozilla10/drawable/"+R.drawable.mozillaicon);
          Intent intent=new Intent(Intent.ACTION_SEND);
          intent.setType("image/*");
          intent.putExtra(Intent.EXTRA_STREAM,imageUri);
          intent.putExtra(Intent.EXTRA_TEXT,"Hey I am attending Mozilla Session");
          startActivity(Intent.createChooser(intent,"Send Image"));
      }
      else
      {
          Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
          startActivity(intent);
      }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.create();
        builder.setTitle("Exit");
        builder.setMessage("Are you Sure?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                return;
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }
}
