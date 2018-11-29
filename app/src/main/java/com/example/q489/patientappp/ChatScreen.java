package com.example.q489.patientappp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChatScreen extends AppCompatActivity {

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        final TextView messageLog = findViewById(R.id.messageLog);

        databaseReference = FirebaseDatabase.getInstance().getReference("Message");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                messageLog.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                messageLog.setText("ERROR: MESSAGE NOT SENT");
            }
        })
    }

    public void sendMessage(View view){
        EditText editText = findViewById(R.id.editText);

        databaseReference.push().setValue(editText.getText().toString());
        editText.setText("");

    }
}
