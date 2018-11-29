package com.example.q489.patientappp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button openChatBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        openChatBttn = findViewById(R.id.signUpButton);
        openChatBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity();
            }
        });
    }
    public void openChatActivity(){
        Intent intent = new Intent(this, ChatScreen.class);
        startActivity(intent);
    }
}
