package com.example.filetimofey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
Button button;
TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =findViewById(R.id.butt);
        tV = findViewById(R.id.tV);


        button.setOnClickListener(new View.OnClickListener() {
            Resources resources = getResources();
            InputStream path = resources.openRawResource(R.raw.map);
            @Override
            public void onClick(View v) {
                InputStreamReader isr = new InputStreamReader(path, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String info = "";
                while (true) {
                    try {
                        if (br.readLine()==null) break;

                        info = info + (char) br.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                tV.setText(info);
            }
        });

    }
}