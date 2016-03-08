package com.dtt.pokermen.event;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;

import com.dtt.pokermen.R;
import com.dtt.pokermen.battles.BattleActivity;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.util.MusicManagment;
import com.dtt.pokermen.util.PlayerControlManager;

import java.util.Random;

/**
 * Created by Zack on 2/28/2016.
 */
public final class BattleEvent {


    private static Activity activity;

    private static int it;
    private static int randInt;
    private static Button txtBtn;
    private static int battleCode;

    private BattleEvent(){}

    // Level side ==================================================================================

    public static void InitializeBattleEven(Activity a, int BattleCode){
        activity = a;
        it = 0;
        battleCode = BattleCode;

        MusicManagment.PlayMusic(activity, MusicManagment.Songs.AttackTheme);

        txtBtn = (Button) a.findViewById(R.id.txt_btn);

        PlayerControlManager.HideControls(activity, true);
        sequence();
    }

    private static void sequence(){
        randomizeMessage();
        switch(it){
            case 0:
                txtBtn.setText("oh no pokermen attack!!");
                break;
            case 1:
                if(randInt==0){
                    txtBtn.setText("lets crush this  punk!!!");
                }
                if(randInt==1){
                    txtBtn.setText("lets murder this thing!!!");
                }
                if(randInt==2){
                    txtBtn.setText("time 4 this thing 2 die!!");
                }
                break;
            case 2:
                Intent startBattle = new Intent(activity,BattleActivity.class);
                startBattle.putExtra("battleCode", battleCode);
                activity.startActivity(startBattle);
                activity.finish();
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















    // Battle side =================================================================================


}
