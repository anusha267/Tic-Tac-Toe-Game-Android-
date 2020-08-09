package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int x=1;
    String winner="";
    int win=0;
    int[][] win_state={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int[] game_state={2,2,2,2,2,2,2,2,2};
    public void play(View view)
    {
        winner="";
        win=0;
        x=1;
        Button button=(Button) findViewById(R.id.button2);
        TextView te=(TextView) findViewById(R.id.textView4);
        button.setVisibility(View.INVISIBLE);
        te.setVisibility(View.INVISIBLE);
        ImageView i1=(ImageView) findViewById(R.id.imageView1);
        ImageView i2=(ImageView) findViewById(R.id.imageView2);
        ImageView i3=(ImageView) findViewById(R.id.imageView3);
        ImageView i4=(ImageView) findViewById(R.id.imageView4);
        ImageView i5=(ImageView) findViewById(R.id.imageView5);
        ImageView i6=(ImageView) findViewById(R.id.imageView6);
        ImageView i7=(ImageView) findViewById(R.id.imageView7);
        ImageView i8=(ImageView) findViewById(R.id.imageView8);
        ImageView i9=(ImageView) findViewById(R.id.imageView9);
        i1.setImageDrawable(null);
        i2.setImageDrawable(null);
        i3.setImageDrawable(null);
        i4.setImageDrawable(null);
        i5.setImageDrawable(null);
        i6.setImageDrawable(null);
        i7.setImageDrawable(null);
        i8.setImageDrawable(null);
        i9.setImageDrawable(null);

        for(int i=0; i<9; i++)
        {
            game_state[i]=2;
        }
    }
    public boolean draw()
    {
        boolean d=true;
        for(int i=0;i<9;i++)
        {
            if(game_state[i]==2)
            {
                d=false;
                break;
            }
        }
        return d;
    }
    public void click(View view)
    {
        //X=0; O=1; Empty=2;
        ImageView c = (ImageView) view;
        int t=Integer.parseInt(c.getTag().toString());
        int a,b,d;

        if (x==1 && game_state[t]==2) {
            c.setImageResource(R.drawable.xxx);
            c.animate().alpha(1).setDuration(500);
            x=0;
            game_state[t]=0;
        }
        else if(x==0 && game_state[t]==2)
        {
            c.setImageResource(R.drawable.ooo);
            c.animate().alpha(1).setDuration(500);
            x=1;
            game_state[t]=1;
        }
        else if(game_state[t]==3)
        {
            Toast.makeText(this, "Game over. Play Again!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Space Full! Try Another Box!", Toast.LENGTH_SHORT).show();
        }
        Log.i("state", Arrays.toString(game_state));

        for(int i=0;i<8;i++)
        {
            a=win_state[i][0];
            b=win_state[i][1];
            d=win_state[i][2];
            if((game_state[a]==0 && game_state[b]==0 && game_state[d]==0) || (game_state[a]==1 && game_state[b]==1 && game_state[d]==1))
            {
                if (game_state[a]==0) {
                    winner="Player 1";
                }
                else{
                    winner="Player 2";
                }
                for(int j=0;j<9;j++)
                {
                    game_state[j]=3;
                }
                win=1;
                Button button=(Button) findViewById(R.id.button2);
                TextView te=(TextView) findViewById(R.id.textView4);
                button.setVisibility(View.VISIBLE);
                winner=winner+" has won";
                te.setText(winner);
                te.setVisibility(View.VISIBLE);
            }
            if(draw()==true && win==0)
            {
                Button button=(Button) findViewById(R.id.button2);
                TextView te=(TextView) findViewById(R.id.textView4);
                button.setVisibility(View.VISIBLE);
                winner="DRAW! Play Again!";
                te.setText(winner);
                te.setVisibility(View.VISIBLE);
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}