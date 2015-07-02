package com.koma.lmkcount;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.textView);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        TextView text3 = (TextView) findViewById(R.id.textView3);

        String msg, msg2, msg3;

        Process p;
        try {
            p = Runtime.getRuntime().exec("cat /sys/module/lowmemorykiller/parameters/lmkcount");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));


            while ((msg = br.readLine()) != null) {
                Log.d("Log", msg);
                text.setText(msg);
            }

            p = Runtime.getRuntime().exec("cat /sys/module/lowmemorykiller/parameters/oomcount");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getInputStream()));


            while ((msg2 = br2.readLine()) != null) {
                Log.d("Log", msg2);
                text2.setText(msg2);
            }

            p = Runtime.getRuntime().exec("uptime");
            BufferedReader br3 = new BufferedReader(new InputStreamReader(p.getInputStream()));


            while ((msg3 = br3.readLine()) != null) {
                Log.d("Log", msg3);
                text3.setText(msg3);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
