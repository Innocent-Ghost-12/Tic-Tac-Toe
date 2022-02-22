package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int[][] winconditions = { {0,1,2} , {3,4,5} ,{6,7,8},
                                              {0,3,6} , {1,4,7} ,{2,5,8},
                                              {0,4,8} , {2,4,6} };
    private int[] state = { 2, 2, 2, 2, 2, 2, 2, 2, 2};
    private boolean gameStatus = true;
    private int currentPlayer = 0;

    public void clicked(View screen){
        ImageView img = (ImageView) screen;
        int ind = Integer.parseInt(img.getTag().toString());
        state[ind] = currentPlayer;
        TextView status = findViewById(R.id.status);
        if(!gameStatus){
            for (int i = 0; i<9; i++){
                state[i] = 2;
            }
            status.setText("Please input 0");
            ((ImageView )findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView )findViewById(R.id.imageView8)).setImageResource(0);
            gameStatus = true;
        }
    if(currentPlayer == 0){
        img.setImageResource(R.drawable.o);
        currentPlayer = 1;
        status.setText("Next player's turn" +
                        "\n Please input X");
    }
    else if(currentPlayer == 1){
        img.setImageResource(R.drawable.x);
        currentPlayer = 0;
        status.setText("Next player's turn" +
                         "\n Please input 0");
    }
    else{
        status.setText("Cannot override" +
                "\n Please input 0");
    }
        for (int[] condition :
                winconditions) {
            if (state[condition[0]] == state[condition[1]] && state[condition[1]] == state[condition[2]] && state[condition[0]] != 2){
                if (state[condition[2]] == 0){
                    status.setText("Player with 0 won game");
                }
                else{
                    status.setText("Player with X won game");
                }
                gameStatus = false;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}