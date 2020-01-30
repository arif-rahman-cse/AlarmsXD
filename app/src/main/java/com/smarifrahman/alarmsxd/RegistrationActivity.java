package com.smarifrahman.alarmsxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.smarifrahman.alarmsxd.activity.HomeActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistrationActivity extends AppCompatActivity {

    CircleImageView homeButton, backLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        backLoginButton = findViewById(R.id.arrow_left);
        homeButton = findViewById(R.id.arrow_right);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}
