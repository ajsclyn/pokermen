package com.dtt.pokermen.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dtt.pokermen.R;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.levels.level01.Lvl01;
import com.dtt.pokermen.levels.level02.Lvl02;
import com.dtt.pokermen.levels.level03.Lvl03;
import com.dtt.pokermen.levels.level04.Lvl04;
import com.dtt.pokermen.object.PokObj;
import com.dtt.pokermen.util.MusicManagment;

public class MainActivity extends Activity {

	MediaPlayer player;
	IntroSequence intro = new IntroSequence(this);
   
	// Global variables declared to be used in activity
	public static class Global {
	    public static int action_seq = 1;
	}
	    
	// Orientation helper
	public class ActivityHelper {
	    public void initialize(Activity activity) {
	        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    }
	}
	
	// ON CREATE
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// set orientation 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
		// initialize screen
		initialize();
		
	}
	
	// ON RESUME
	public void onResume() {
	    super.onResume();
	    // resume music
	    MusicManagment.PlayMusic(this, MusicManagment.Songs.PokermenTheme);
	}
	
	// ON PAUSE
	public void onPause() {
        super.onPause();
        // stop music
		MusicManagment.Stop();
    }
	
	// initialize main menu
	public void initialize(){
		// load gameDat
		gameDat.load_gameDat(this);
		// set the availability of the start button
		set_startBtn();
	}
	
	// set start button enabled/disabled
	public void set_startBtn(){
		Button startBtn = (Button) findViewById(R.id.start_btn);
		if(gameDat.get_saved_game_stat() == 1){
			startBtn.setEnabled(true);
		}	
	}

	//Actions that take place when the start button is pressed
	public void startButton_press(View theButton){
		int lvl = gameDat.get_game_lvl();
		Intent start_game = new Intent(this,Lvl01.class);
		if(lvl == 2)
			start_game = new Intent(this,Lvl02.class);
        if(lvl == 3)
            start_game = new Intent(this,Lvl03.class);
        if(lvl == 4)
            start_game = new Intent(this,Lvl04.class);


		startActivity(start_game);
		finish();
		Log.i("DTT","MainActivity finished. Lvl1 started.");
	}
	
	
	
	
	// Actions that take place when new game button is pressed
	public void newGame_press(View theButton){
		if(gameDat.get_saved_game_stat() == 1){
			new AlertDialog.Builder(this)
			.setTitle("Warning:")
			.setMessage("Are you sure you want to start a new game? This will erase all previous efforts.")
			.setIcon(android.R.drawable.ic_dialog_alert)
			.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

			    public void onClick(DialogInterface dialog, int whichButton) {
			        resetGame();
			        newGameSetup();
			    }})
			 .setNegativeButton(android.R.string.no, null).show();
		}
		else{
			newGameSetup();
		}
		
	}
	
	// resets game data
	public void resetGame(){
		gameDat.reset_gameDat(this);
		gameDat.PlayerPokerParty.EmptyPokerParty();
		Toast.makeText(MainActivity.this, "Game reset.", Toast.LENGTH_SHORT).show();
	}
	
	// the intro sequence for a new game
	public void newGameSetup(){
		intro.startSeq();
	}
	
	// Progresses when new game text is pressed
	public void textButtonProg(View theButton){
        intro.iterate();
        intro.event();
        if(intro.getFin()==true){
            gameDat.set_player_name(intro.retName());
            gameDat.set_game_lvl(1);
            gameDat.set_numBadges(0);
            gameDat.set_rival_name(intro.retRival());
            gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(1, intro.retPokName(), 1, 10, 10, 20, 0));
            gameDat.set_player_money(92);
            gameDat.set_saveGameStat(1);
            gameDat.save_gameDat(this);
            Intent start_game = new Intent(this,Lvl01.class);
            start_game.putExtra("dir", 0);
            startActivity(start_game);
            finish();
            Log.i("DTT","MainActivity finished. Lvl1 started.");
        }
	}
	
	// ===================================================================================== //
	// ================================= DEV STATE FUNCTIONS =============================== //
	// ===================================================================================== //
	
	
	public void devState1(View theButton){
		resetGame();
		
		gameDat.set_saveGameStat(1);

		gameDat.set_player_name("Ash");
		gameDat.set_game_lvl(1);
		gameDat.set_numBadges(0);
		gameDat.set_rival_name("Gary");

		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(1, "Pikrchu", 1, 10, 10, 10, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(1).setHp(5);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj());
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj());
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj());
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj());
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj());

		gameDat.set_player_money(227);

		gameDat.save_gameDat(this);
		set_startBtn();
		Toast.makeText(MainActivity.this, "DEV STATE 1 SET", Toast.LENGTH_SHORT).show();
	}
	public void devState2(View theButton){
		resetGame();
		
		gameDat.set_saveGameStat(1);

		gameDat.set_player_name("Ash");
		gameDat.set_game_lvl(1);
		gameDat.set_numBadges(0);
		gameDat.set_rival_name("Gary");

		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(1, "Pikrchu", 3, 15, 15, 20, 0));
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(2, "Peevee", 4, 15, 15, 25, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(2).setHp(15);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(3, "Weenle", 2, 15, 15, 22, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(3).setHp(8);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(4, "Pudgie", 5, 15, 15, 21, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(4).setHp(10);
		
		gameDat.set_player_money(1500);

		gameDat.save_gameDat(this);
		set_startBtn();
		Toast.makeText(MainActivity.this, "DEV STATE 2 SET", Toast.LENGTH_SHORT).show();	
	}
	public void devState3(View theButton){
		resetGame();
		
		gameDat.set_saveGameStat(1);

		gameDat.set_player_name("Ash");
		gameDat.set_game_lvl(1);
		gameDat.set_numBadges(0);
		gameDat.set_rival_name("Gary");

		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(1, "Pikrchu", 63, 50, 50, 200, 0));
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(2, "Peevee", 4, 15, 15, 25, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(2).setHp(15);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(6, "Pokrslow", 70, 60, 06, 180, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(3).setHp(8);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(8, "Tentacool", 15, 25, 25, 51, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(4).setHp(42);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(7, "Hitmonler", 10, 15, 15, 88, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(5).setHp(72);
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj(10, "Jaquinx", 11, 15, 15, 43, 0));
		gameDat.PlayerPokerParty.GetPokermenInSlot(6).setHp(10);
		
		gameDat.set_player_money(9999);

		gameDat.save_gameDat(this);
		set_startBtn();
		Toast.makeText(MainActivity.this, "DEV STATE 3 SET", Toast.LENGTH_SHORT).show();	
		
		
	}
	public void devState4(View theButton){
		
		
		
	}
	public void devState5(View theButton){
		
		
		
	}
	
	// ======================================== END ======================================== //
	// ================================= DEV STATE FUNCTIONS =============================== //
	// ===================================================================================== //
	
	
	
}
