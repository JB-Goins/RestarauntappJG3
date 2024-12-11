package com.example.restarauntappjg3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FoodActivity extends AppCompatActivity {
EditText qtyET;
Button salBTN;
TextView subTV;
TextView taxTV;
TextView totalTV;
Button atoBTN;
CheckBox shrimpCB;
CheckBox chickCB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        qtyET = findViewById(R.id.qtyET);
        subTV = findViewById(R.id.subTV);
        taxTV = findViewById(R.id.taxTV);
        totalTV = findViewById(R.id.totalTV);
        salBTN = findViewById(R.id.salBTN);
        atoBTN = findViewById(R.id.atoBTN);
        shrimpCB =  findViewById(R.id.shrimpCB);
        chickCB = findViewById(R.id.chickCB);

        salBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtyET.setVisibility(View.VISIBLE);
                atoBTN.setVisibility(View.VISIBLE);
                shrimpCB.setVisibility(View.VISIBLE);
                chickCB.setVisibility(View.VISIBLE);
            }
        });
    }


}
