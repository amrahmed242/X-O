package com.amrprogs.x_o;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //x=0 o=1
    int activrPlayer=0;

    int gamestate[]={2,2,2,2,2,2,2,2,2};

    int[][]winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public  void click(View view){

        ImageView counter=(ImageView) view;
        int tappedCounter=Integer.parseInt(counter.getTag().toString());


        if(gamestate[tappedCounter]==2) {
            gamestate[tappedCounter]=activrPlayer;
            counter.setTranslationY(-1000f);

            if (activrPlayer == 0) {
                counter.setImageResource(R.drawable.x);
                activrPlayer = 1;
            } else {
                counter.setImageResource(R.drawable.o);
                activrPlayer = 0;}


            counter.animate().translationYBy(1000f).setDuration(300);

            String winner;
            for (int[] winningPosition : winningPositions){

                if (gamestate[winningPosition[0]]==gamestate[winningPosition[1]] && gamestate[winningPosition[1]]==gamestate[winningPosition[2]] && gamestate[winningPosition[0]] !=2)
                {
                 winner="O  WON";
                    if((gamestate[winningPosition[0]]==0)){
                    winner="X  WON";
                }



                    TextView winnerMessage=(TextView)findViewById(R.id.winner);
                    winnerMessage.setText(winner);
                    LinearLayout layout=(LinearLayout)findViewById(R.id.resultLayout);
                    layout.setVisibility(View.VISIBLE);

                }else{
                    boolean gio=true;

                    for (int stateCounter:gamestate){

                        if (stateCounter==2)
                        {gio=false;}
                    }
                    if (gio==true) {
                        winner = "DRAW";
                        TextView winnerMessage = (TextView) findViewById(R.id.winner);
                        winnerMessage.setText(winner);
                        LinearLayout layout = (LinearLayout) findViewById(R.id.resultLayout);
                        layout.setVisibility(View.VISIBLE);
                    }

                    }



            }

        }

    }

    public void again(View view){
        int activrPlayer=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        LinearLayout layout=(LinearLayout)findViewById(R.id.resultLayout);
        layout.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.g);
        for (int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
