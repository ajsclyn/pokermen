package com.dtt.pokermen.event;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;

import com.dtt.pokermen.R;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.util.PlayerControlManager;

import java.util.Random;

public final class DocEvent {
	
	private static Activity activity;

	private static int it;
	private static int randInt;

	private static Button txtBtn;
	
	private DocEvent(){}
	
	public static void InitializeDocEvent(Activity a){
		activity = a;
		it = 0;

		txtBtn = (Button) a.findViewById(R.id.txt_btn);

        PlayerControlManager.HideControls(activity, true);
		sequence();
	}

	private static void sequence(){
        randomizeMessage();
		Log.i("DTT","DocEvent says: seq it = " + it);
		switch(it){
			case 0:
				txtBtn.setText("uh hi");
				break;
			case 1:
                if(randInt==0){
                    txtBtn.setText("woah dude ur pokermen look sick and dead");
                }
                if(randInt==1){
                    txtBtn.setText("uh oh it looks like ur pokermen r all bleeding");
                }
                if(randInt==2){
                    txtBtn.setText("wow looks like u have maimed pokermen");
                }
				break;
			case 2:
				txtBtn.setText("im docter so i will make them better");
				break;
			case 3:
                if(randInt==0){
                    txtBtn.setText("there u go they are fixed but still ugly");
                }
                if(randInt==1){
                    txtBtn.setText("they are alive now but still want to be dead");
                }
                if(randInt==2){
                    txtBtn.setText("they will be ok now i have did this");
                }
				break;
			case 4:
				gameDat.PlayerPokerParty.HealAll();
				PlayerControlManager.RestoreControls(activity);
				break;
			}
	}
	
	public static void sequenceDriver(){
		it = it + 1;
		sequence();
	}

    public static void randomizeMessage(){
        Random rand = new Random();
        randInt = rand.nextInt(3);
    }
}
