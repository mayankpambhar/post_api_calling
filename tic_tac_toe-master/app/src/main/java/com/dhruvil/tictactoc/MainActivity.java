package com.dhruvil.tictactoc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button reset;
    int ope = 0;
    int i1, i2, i3, i4, i5, i6, i7, i8, i9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        reset = findViewById(R.id.reset);

        i1 = i2 = i3 = i4 = i5 = i6 = i7 = i8 = i9 = 0;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i1 == 0){
                    if (ope % 2 == 0) {
                        b1.setImageResource(R.drawable.cross);
                    } else {
                        b1.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i1++;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i2 == 0){
                    if (ope % 2 == 0) {
                        b2.setImageResource(R.drawable.cross);
                    } else {
                        b2.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i2++;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i3 == 0){
                    if (ope % 2 == 0) {
                        b3.setImageResource(R.drawable.cross);
                    } else {
                        b3.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i3++;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i4 == 0){
                    if (ope % 2 == 0) {
                        b4.setImageResource(R.drawable.cross);
                    } else {
                        b4.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i4++;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i5 == 0){
                    if (ope % 2 == 0) {
                        b5.setImageResource(R.drawable.cross);
                    } else {
                        b5.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i5++;
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i6 == 0){
                    if (ope % 2 == 0) {
                        b6.setImageResource(R.drawable.cross);
                    } else {
                        b6.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i6++;
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i7 == 0){
                    if (ope % 2 == 0) {
                        b7.setImageResource(R.drawable.cross);
                    } else {
                        b7.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i7++;
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i8 == 0){
                    if (ope % 2 == 0) {
                        b8.setImageResource(R.drawable.cross);
                    } else {
                        b8.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i8++;
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i9 == 0){
                    if (ope % 2 == 0) {
                        b9.setImageResource(R.drawable.cross);
                    } else {
                        b9.setImageResource(R.drawable.circle);
                    }
                    ope++;
                }
                i9++;
            }
        });

    }
}