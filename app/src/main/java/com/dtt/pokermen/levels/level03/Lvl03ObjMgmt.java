package com.dtt.pokermen.levels.level03;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dtt.pokermen.R;

import java.util.Random;

/**
 * Created by Zack on 2/9/15.
 */
public class Lvl03ObjMgmt {

    Activity a;

    ImageView img_player;
    ImageView img_doc;
    ImageView img_train01;
    TextView town_txt;
    Display display;

    int playerX;
    int playerY;
    int docX;
    int docY;
    int train01X;
    int train01Y;
    int screenX;
    int screenY;
    int event_id;
    int detect_protect;

    public Lvl03ObjMgmt(Activity x){
        a = x;
        findViews();
        getScreenDims();
        getCords();
        update_town_txt();
        set_npc_locatoin_lvl_3();
        detect_protect = 0;
        event_id = 0;
    }

    public int probe(){
        event_id = 0;
        detect_protect++;
        Log.i("DTT", "DP: " + detect_protect);
        getCords();
        docListener();     // 1
        train01Listener(); // 3
        wildListener();    // 2
        gateListenerTop();    // 4
        gateListenerBottom(); // 5

        Log.i("DTT","EID: " + event_id);

        if(detect_protect < 5)
            event_id = 0;
        if(event_id != 0)
            detect_protect = 0;

        return event_id;
    }

    // Generates random number
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void findViews(){
        img_player = (ImageView) a.findViewById(R.id.img_player);
        img_doc = (ImageView) a.findViewById(R.id.img_doc);
        img_train01 = (ImageView) a.findViewById(R.id.trainer_01);
        town_txt = (TextView) a.findViewById(R.id.town_txt);

    }

    public void getScreenDims(){
        display = a.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenX = size.x;
        screenY = size.y;
    }

    public void getCords(){
        playerY = img_player.getTop();
        playerX = img_player.getLeft();
        docY = img_doc.getTop();
        docX = img_doc.getLeft();
        train01Y = img_train01.getTop();
        train01X = img_train01.getLeft();
    }

    // ------------------------------------- //
    // -- LISTENER/DETECTORS --------------- //
    // ------------------------------------- //

    // DOC detector/listener
    public void docListener(){
        Log.i("DTT","playerX-docX="+(playerX-docX)+" docY-playerY="+(docY-playerY));

        if((playerX-docX)>50){
            if((playerX-docX)<110){
                if((docY-playerY)>-30){
                    if((docY-playerY)<30){
                        Log.i("DTT","DOC DETECT!");
                        event_id = 1;
                    }
                }
            }
        }
    }

    // listener for trainer 01 (in LVL 1)
    public void train01Listener(){
        Log.i("DTT","playerX-train01X="+(playerX-train01X)+" trainY-playerY="+(train01Y-playerY));

        if((playerX-train01X)>25){
            if((playerX-train01X)<45){
                if((train01Y-playerY)>-95){
                    if((train01Y-playerY)<-75){
                        Log.i("DTT","TRAIN01 DETECT!");
                        event_id = 3;
                    }
                }
            }
        }
    }

    // Wild area listener
    public void wildListener(){
        Log.i("DTT","WILD: Y: "+playerY+" X: "+playerX);

        if(playerX<(.30*screenX)){
            if(playerY<(.60*screenY)){
                Log.i("DTT","WILD DETECT!");
                int wild_chance = randInt(0, 100);
                if(wild_chance < 10){
                    event_id = 2;
                    Log.i("DTT","WILD ATTACK!");
                }
            }
        }
    }

    // To LEVEL 4 listener
    public void gateListenerTop(){
        if(playerX<(.50*screenX)){
            if(playerX>(.40*screenX)){
                if(playerY<(.04*screenY)){
                    event_id = 4;
                    Log.i("DTT","TOP GETE DETECT!");
                }
            }
        }
    }

    // To LEVEL 2 listener
    public void gateListenerBottom(){
        if(playerX<(.50*screenX)){
            if(playerX>(.40*screenX)){
                if(playerY>(.90*screenY)){
                    event_id = 5;
                    Log.i("DTT","BOTTOM GATE DETECT!");
                }
            }
        }
    }


    // ------------------------------------- //
    // -- PLACE OBJECTS -------------------- //
    // ------------------------------------- //

    // Sets the NPC's location for lvl 3
    public void set_npc_locatoin_lvl_3(){
        // doc
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) img_doc.getLayoutParams();
        lp.topMargin = (int) (.64*screenY);
        lp.leftMargin = (int) (.4*screenX);
        img_doc.setLayoutParams(lp);

        // trainer 01
        RelativeLayout.LayoutParams tp01 = (RelativeLayout.LayoutParams) img_train01.getLayoutParams();
        tp01.topMargin = (int) (.25*screenY);
        tp01.leftMargin = (int) (.8*screenX);
        img_train01.setLayoutParams(tp01);

        img_train01.setRotation(270);

        // trainer 02

    }

    // Updates town name text view
    public void update_town_txt(){
        town_txt.setText("3 - Cramp Forest");
    }



}
