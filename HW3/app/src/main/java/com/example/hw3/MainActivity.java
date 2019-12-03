package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mGameButtons[] = new Button[9];
    Game mGame = new Game();
    TextView mGameStatus;
    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGameButtons[0] = findViewById(R.id.button1);
        mGameButtons[1] = findViewById(R.id.button2);
        mGameButtons[2] = findViewById(R.id.button3);
        mGameButtons[3] = findViewById(R.id.button4);
        mGameButtons[4] = findViewById(R.id.button5);
        mGameButtons[5] = findViewById(R.id.button6);
        mGameButtons[6] = findViewById(R.id.button7);
        mGameButtons[7] = findViewById(R.id.button8);
        mGameButtons[8] = findViewById(R.id.button9);


        mGameStatus =  findViewById(R.id.gameStatus);

        Button mNewGame = findViewById(R.id.newGame);
        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNewGameClick();
            }
        });

        turn = 0;

        for(int i =0; i<mGameButtons.length;i++)
        {
            final int finalI = i;
            mGameButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayButtonClick(finalI);
                }
            });
        }

    }

    public void onPlayButtonClick(int index)
    {
        mGame.setPlayerMove(index);
        mGameButtons[index].setTextColor(Color.RED);
        mGameButtons[index].setText("X");
        mGameButtons[index].setClickable(false);
        turn++;
        if(!isGameOver())
        {
            int computerMove = mGame.getComputerMove();
            mGameButtons[computerMove].setTextColor(Color.BLUE);
            mGameButtons[computerMove].setText("O");
            mGameButtons[computerMove].setClickable(false);
            turn++;
            isGameOver();
        }

    }

    public boolean isGameOver()
    {
        int results = mGame.checkForWinner();
        if(results<0)
        {
            mGameStatus.setText("Computer Wins");
            disableButtons();
            return true;
        }
        else if(results>0)
        {
            mGameStatus.setText("User Wins!");
            disableButtons();
            return true;
        }
        else if(turn==mGameButtons.length)
        {
            mGameStatus.setText("Draw");
            disableButtons();
            return true;
        }
        else
        {
            return false;
        }

    }

    public void onNewGameClick()
    {
        mGame.newGame();
        mGameStatus.setText("GAME STATUS");
        turn=0;
        for(int i =0; i<mGameButtons.length;i++)
        {
            mGameButtons[i].setClickable(true);
            mGameButtons[i].setText("");
        }
    }

    public void disableButtons()
    {
        for(int i =0; i<mGameButtons.length;i++)
        {
            mGameButtons[i].setClickable(false);
        }
    }
}
