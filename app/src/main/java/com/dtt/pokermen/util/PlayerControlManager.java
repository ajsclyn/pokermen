package com.dtt.pokermen.util;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.dtt.pokermen.R;

/**
 * Created by Zack on 2/28/2016.
 */
public final class PlayerControlManager {

    private PlayerControlManager(){}

    private static Activity activity;

    private static Button txtBtn;
    private static Button btn_up;
    private static Button btn_down;
    private static Button btn_left;
    private static Button btn_right;

    private static Button save;
    private static Button pkrmn;
    private static Button items;
    private static Button player;

    public static void InitializePlayerControlManager(){
        txtBtn = (Button) activity.findViewById(R.id.txt_btn);
        btn_up = (Button) activity.findViewById(R.id.btn_up);
        btn_down = (Button) activity.findViewById(R.id.btn_down);
        btn_left = (Button) activity.findViewById(R.id.btn_left);
        btn_right = (Button) activity.findViewById(R.id.btn_right);

        save = (Button) activity.findViewById(R.id.save_btn);
        pkrmn = (Button) activity.findViewById(R.id.prkmn_btn);
        items = (Button) activity.findViewById(R.id.items_but);
        player = (Button) activity.findViewById(R.id.player_btn);
    }


    public static void HideControls(Activity a, Boolean showText){
        activity = a;
        InitializePlayerControlManager();
        if(showText)
            txtBtn.setVisibility(View.VISIBLE);
        btn_up.setVisibility(View.GONE);
        btn_down.setVisibility(View.GONE);
        btn_left.setVisibility(View.GONE);
        btn_right.setVisibility(View.GONE);
        save.setVisibility(View.GONE);
        pkrmn.setVisibility(View.GONE);
        items.setVisibility(View.GONE);
        player.setVisibility(View.GONE);
    }

    public static void RestoreControls(Activity a){
        activity = a;
        InitializePlayerControlManager();
        txtBtn.setVisibility(View.GONE);
        btn_up.setVisibility(View.VISIBLE);
        btn_down.setVisibility(View.VISIBLE);
        btn_left.setVisibility(View.VISIBLE);
        btn_right.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);
        pkrmn.setVisibility(View.VISIBLE);
        items.setVisibility(View.VISIBLE);
        player.setVisibility(View.VISIBLE);
    }


}
