package com.example.rmaahmadov.tictactoe;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button buttonCustomerSelect;
    private Button btnBatman;
    private Button btnSuperman;
    private TextView textViewAfterAnime;
    private Button buttonAfterAnime;
    private LinearLayout linearLayout;
    private ConstraintLayout constraintLayout;
    //0is deactive 1 is active
    int activePlayer = 0;
    //2is played
    int[] gamePlayer = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPasissions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {1, 4, 7}, {2, 4, 6}, {0, 3, 6}, {2, 5, 8}};
    boolean startgame = false;

    public void ticTacToe(View view) {
        ImageView counter = (ImageView) view;
        int tabbedcounter = Integer.parseInt(counter.getTag().toString());
        constraintLayout.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        int customerSelectedPlayer;
        if (buttonCustomerSelect == btnBatman) {
            activePlayer = 0;
        } else if(buttonCustomerSelect==btnSuperman) {
            activePlayer = 1;
        }
        customerSelectedPlayer = activePlayer;



        while (startgame) {
            if (gamePlayer[tabbedcounter] == 2) {
                gamePlayer[tabbedcounter] = activePlayer;
                counter.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    counter.setImageResource(R.drawable.batman);
                    counter.animate().translationYBy(1000f).rotation(1080).setDuration(500);
                    activePlayer = 1;

            } else if (activePlayer == 1) {
                counter.setImageResource(R.drawable.superman);
                counter.animate().translationYBy(1000f).setDuration(500);
                activePlayer = 0;
                customerSelectedPlayer = activePlayer;
            }
            for (int[] winningposition : winningPasissions) {
                if (gamePlayer[winningposition[0]] == gamePlayer[winningposition[1]] &&
                        gamePlayer[winningposition[1]] == gamePlayer[winningposition[2]] &&
                        gamePlayer[winningposition[0]] != 2 && gamePlayer[winningposition[0]] == customerSelectedPlayer) {
                    linearLayout.setVisibility(View.VISIBLE);
                    textViewAfterAnime.setText("You Are Win!!!");
                    constraintLayout.setVisibility(View.INVISIBLE);
                } else {
                    textViewAfterAnime.setText("You Are Lose!Try again!");
                }

            }

        }
    }

}


    public void newGame(View view) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearlayout);
        constraintLayout = findViewById(R.id.constrainLayout);
        textViewAfterAnime = findViewById(R.id.textViewMessage);
        buttonAfterAnime = findViewById(R.id.newGameBtn);
        btnBatman.findViewById(R.id.startWithBatman);
        btnSuperman.findViewById(R.id.startWithSuperman);

    }
}
