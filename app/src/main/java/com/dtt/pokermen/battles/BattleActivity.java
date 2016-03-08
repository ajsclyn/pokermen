package com.dtt.pokermen.battles;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dtt.pokermen.R;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.levels.level01.Lvl01PokParties;
import com.dtt.pokermen.object.PokObj;
import com.dtt.pokermen.object.PokerParty;
import com.dtt.pokermen.util.MusicManagment;
import com.dtt.pokermen.util.PlayerMovement;
import com.dtt.pokermen.util.ResourceManager;

import java.util.ArrayList;

public class BattleActivity extends Activity {

    public ImageView opPokImg;
    public ImageView playerPokImg;
    public Button attackBtn;
    public Button bagBtn;
    public Button runBtn;
    public TextView txtOpName;
    public TextView txtOpLvl;
    public ProgressBar opProg;
    public TextView txtOpMax;
    public TextView txtOpHp;
    public TextView txtPokLvl;
    public TextView txtPokName;
    public ProgressBar pokProg;
    public TextView txtPokHp;
    public TextView txtPokMax;
    public Button butAtk1;
    public Button butAtk2;
    public Button butAtk3;
    public Button butAtk4;
    public Button txt_btn;

    public int battleCode;

    public PokerParty oppParty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        // Get intent parameters ===================================================================
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        battleCode = (Integer) b.get("battleCode");

        // Start music
        MusicManagment.PlayMusic(this, MusicManagment.Songs.AttackTheme);

        // Get the opposing pokermen party
        initializeBattleWithCode(battleCode);

        // Find the elements on the screen
        findViews();

        // Refresh HMI
        refreshHMI();


    }

    private void findViews(){
        opPokImg = (ImageView) findViewById(R.id.opPokImg);
        playerPokImg = (ImageView) findViewById(R.id.playerPokImg);
        attackBtn = (Button) findViewById(R.id.attackBtn);
        bagBtn = (Button) findViewById(R.id.bagBtn);
        runBtn = (Button) findViewById(R.id.runBtn);
        txtOpName = (TextView) findViewById(R.id.txtOpName);
        txtOpLvl = (TextView) findViewById(R.id.txtOpLvl);
        opProg = (ProgressBar) findViewById(R.id.opProg);
        txtOpMax = (TextView) findViewById(R.id.txtOpMax);
        txtOpHp = (TextView) findViewById(R.id.txtOpHp);
        txtPokLvl = (TextView) findViewById(R.id.txtPokLvl);
        txtPokName = (TextView) findViewById(R.id.txtPokName);
        pokProg = (ProgressBar) findViewById(R.id.pokProg);
        txtPokHp = (TextView) findViewById(R.id.txtPokHp);
        txtPokMax = (TextView) findViewById(R.id.txtPokMax);
        butAtk1 = (Button) findViewById(R.id.butAtk1);
        butAtk2 = (Button) findViewById(R.id.butAtk2);
        butAtk3 = (Button) findViewById(R.id.butAtk3);
        butAtk4 = (Button) findViewById(R.id.butAtk4);
        txt_btn = (Button) findViewById(R.id.txt_btn);
    }

    private void initializeBattleWithCode(int code){

        // Wild level 1 pokermen
        switch (code)
        {
            case 1:
                oppParty = Lvl01PokParties.GetWildPok();
        }
    }


    private void refreshHMI(){
        // Refresh Player
        RefreshPlayer();
        // Refresh Opp
        RefreshOpp();
    }

    private void RefreshOpp(){
        PokObj currentPok = oppParty.GetNextAlivePokermen();

        txtOpName.setText(currentPok.getName());
        txtOpHp.setText((Integer.toString(currentPok.getHp())));
        txtOpMax.setText((Integer.toString(currentPok.getHpMax())));
        txtOpLvl.setText((Integer.toString(currentPok.getLvl())));
        opPokImg.setImageResource(ResourceManager.GetPokermenImageFrontById(currentPok.getId()));
        opProg.setMax(currentPok.getHpMax());
        opProg.setProgress(currentPok.getHp());
        currentPok = null;
    }

    private void RefreshPlayer(){
        PokObj currentPok = gameDat.PlayerPokerParty.GetNextAlivePokermen();

        txtPokName.setText(currentPok.getName());
        txtPokHp.setText((Integer.toString(currentPok.getHp())));
        txtPokMax.setText((Integer.toString(currentPok.getHpMax())));
        txtPokLvl.setText((Integer.toString(currentPok.getLvl())));
        playerPokImg.setImageResource(ResourceManager.GetPokermenImageBackById(currentPok.getId()));
        pokProg.setMax(currentPok.getHpMax());
        pokProg.setProgress(currentPok.getHp());

        currentPok = null;
    }


}
