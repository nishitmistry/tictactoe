package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity  implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_layout);
        ImageView box_1 = findViewById(R.id.box1);
        ImageView box_2 = findViewById(R.id.box2);
        ImageView box_3 = findViewById(R.id.box3);
        ImageView box_4 = findViewById(R.id.box4);
        ImageView box_5 = findViewById(R.id.box5);
        ImageView box_6 = findViewById(R.id.box6);
        ImageView box_7 = findViewById(R.id.box7);
        ImageView box_8 = findViewById(R.id.box8);
        ImageView box_9 = findViewById(R.id.box9);
        box_1.setOnClickListener(this);
        box_2.setOnClickListener(this);
        box_3.setOnClickListener(this);
        box_4.setOnClickListener(this);
        box_5.setOnClickListener(this);
        box_6.setOnClickListener(this);
        box_7.setOnClickListener(this);
        box_8.setOnClickListener(this);
        box_9.setOnClickListener(this);
    }
    // 0 --- O
    // 1 --- X
    // 2 --- EMPTY
    int player=0;
    int [] boardState={2,2,2,2,2,2,2,2,2};
    int [][] winPosition ={ {1,2,3} ,{4,5,6},{7,8,9},{1,5,9},{3,5,7},{1,4,7},{2,5,8},{3,6,9}};
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(this,endScreen.class);
        ImageView img = (ImageView)view;
        TextView textview = findViewById(R.id.currentPlayer);
        int tag = Integer.parseInt(img.getTag().toString());
        if(boardState[tag-1]==2) {
            if (player == 0) {
                img.setImageResource(R.drawable.o);
                boardState[tag - 1] = 0;
                player = 1;
                textview.setText("X's Turn");
            }
            else {
                img.setImageResource(R.drawable.x);
                boardState[tag - 1] = 1;
                player = 0;
                textview.setText("O's Turn");
            }
            int count = 0;
            for (int i = 0; i < 9; i++) {
                if (boardState[i] != 2) {
                    count++;
                }
            }
            if (count == 9) {
                intent.putExtra("winner", "2");
                startActivity(intent);
            }

           for(int [] winpositions:winPosition )
           {
               if(boardState[winpositions[0]-1]==boardState[winpositions[1]-1]&&
                       boardState[winpositions[1]-1]==boardState[winpositions[2]-1]&&
                       boardState[winpositions[0]-1]!=2)
               {
                   if (boardState[winpositions[0]-1]==0) {
                       intent.putExtra("winner", "0");
                       startActivity(intent);
                   }
                   if (boardState[winpositions[0]-1]==1) {
                       intent.putExtra("winner", "1");
                       startActivity(intent);
                   }
               }
           }


        }
    }
//    public int winChecker()
//    {
//        // count1 for o player
//        // count2 for x player
//        int count1=0;
//        int count2=0;
//        for(int i=0;i<8;i++)
//        {
//            count1=0;
//            count2=0;
//            for(int j=0;j<3;j++) {
//                if(boardState[winPosition[i][j]-1]==0)
//                {
//                    count1++;
//                }
//                if(boardState[winPosition[i][j]-1]==1)
//                {
//                    count2++;
//                }
//            }
//            if(count1==3)
//            {
//                return 0;
//            }
//            if(count2==3)
//            {
//                return 1;
//            }
//        }
//        return 2;
//    }

}