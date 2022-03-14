package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class endScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        String msg= intent.getStringExtra("winner");
        setContentView(R.layout.activity_end_screen);
        TextView textView = findViewById(R.id.declareWinner);
        Button button= findViewById(R.id.play_again);
        if("0".equals(msg))
        {
            textView.setText("O is the winner");
        }
        else if("1".equals(msg))
        {
            textView.setText("X is the winner");
        }
        else if("2".equals(msg))
        {
            textView.setText("Its a draw");
        }
        Intent goBack = new Intent(this,Game.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goBack);
            }
        });
    }
    public void onBackPressed() {
        Intent goBack = new Intent(this,Game.class);
        startActivity(goBack);
    }
}