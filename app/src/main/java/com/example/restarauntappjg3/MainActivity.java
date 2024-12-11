package com.example.restarauntappjg3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton foodFAB;
    FloatingActionButton mapFAB;
    Button siteBTN;
    Button mailingBTN;
    EditText emailET;

    static private final String URL = "https://www.baltimorecityschools.org/schools/405";
    static private final String EMAIL_ADDR = "yates.code@gmail.com";
    static private final String ADDRESS = "100 Kane Street, Baltimore, MD 21224";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodFAB = (FloatingActionButton) findViewById(R.id.food_image_FAB);
        mapFAB = (FloatingActionButton) findViewById(R.id.map_FAB);
        siteBTN = (Button) findViewById(R.id.website_bTN);
        mailingBTN = (Button) findViewById(R.id.mailing_list_BTN);
        emailET = (EditText) findViewById(R.id.email_ET);

        foodFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewFoodIntent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(viewFoodIntent);
            }
        });

        siteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                startActivity(viewSiteIntent);
            }
        });

        mapFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + ADDRESS));
                startActivity(viewMapIntent);
            }
        });

        mailingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = emailET.getText().toString();
                String emailMessage = getString(R.string.eml_msg_base) + userEmail;
                String emailSubj = getString(R.string.email_subj);
                String[] addresses = new String[]{EMAIL_ADDR};
                composeEmail(addresses, emailSubj, emailMessage);
            }
        });

    }

    // helper method to compose and send email, adapted from
    // https://developer.android.com/guide/components/intents-common
    private void composeEmail(String[] addresses, String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
