package com.example.a1505197.mozilla10;

import java.util.ArrayList;

/**
 * Created by 1505197 on 1/20/2018.
 */

public class MyData
{
    static int position;

    public static void getposition(int pos)
    {
        position=pos;
    }
    public static ArrayList<information> getdata()
    {
        ArrayList<information> data = new ArrayList<>();
        int images[]={
                R.drawable.green,
                R.drawable.shutter,
                R.drawable.palawan,
                R.drawable.shutter,
                R.drawable.island,
        };
        String[] Categories = new String[]{"sanantonio", "Destination", "Germany", "Hill", "Island"};
        for (int i = 0; i < images.length; i++) {
            information current = new information();
            current.title = Categories[i];
            current.imageId = images[i];
            data.add(current);

        }
        return data;
    }
}

