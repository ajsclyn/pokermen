package com.dtt.pokermen.levels.level01;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dtt.pokermen.event.BattleEvent;
import com.dtt.pokermen.event.DocEvent;
import com.dtt.pokermen.levels.level02.Lvl02;
import com.dtt.pokermen.R;
import com.dtt.pokermen.menu.ShowItems;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.util.MusicManagment;
import com.dtt.pokermen.util.PlayerMovement;
import com.dtt.pokermen.menu.ShowPkrmn;


public class Lvl01 extends Activity {

	Lvl01ObjMgmt lvl01ObjMgmt;
	int currentEvent = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Set the content view for level 1 ========================================================
		setContentView(R.layout.activity_lvl01);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        // Set the level for activity / data =======================================================
        gameDat.set_game_lvl(1);

        // Get intent parameters ===================================================================
		Intent iin= getIntent();
        Bundle b = iin.getExtras();

        // Set up movement for activity ============================================================
        // Initialize layout ===========
        PlayerMovement.InitializeMovementControls(this);
        // Place player ================
        int starting_dir = 0;
        if(b!=null)
            starting_dir =(Integer) b.get("dir");
        if(starting_dir == 1)
            PlayerMovement.setToTop();
        else
            PlayerMovement.setToOrigin();

        // Set up objects on level =================================================================
        lvl01ObjMgmt = new Lvl01ObjMgmt(this);
	}
	
	// ON RESUME
	public void onResume() {
	    super.onResume();
        MusicManagment.PlayMusic(this, MusicManagment.Songs.PubleTown);
	}
	
	// ON PAUSE
	public void onPause() {
        super.onPause();
        MusicManagment.Stop();
    }

    // Save button listener
    public void save_btn_press(View theButton){
        gameDat.save_gameDat(this);
    }

	// ---------------------------------------------------------------------------------- //
	// -------------------- L E V E L  S P E C I F I C  D E T E C T O R S --------------- //
	// ---------------------------------------------------------------------------------- //
	// event root
	public void eventHandle(){
		int id = lvl01ObjMgmt.probe();
		Log.i("DTT","id from probe = " + id);
		if(id == 1){
			DocEvent.InitializeDocEvent(this);
			currentEvent = 1;
		}
        // wild attack
        if(id == 2){
			BattleEvent.InitializeBattleEven(this, 1);
            Log.i("DTT", "Going from LVL1 to wild Battle...");
			currentEvent = 2;
        }
		if(id == 4) {
            Intent change_lvl = new Intent(this, Lvl02.class);
            startActivity(change_lvl);
            // Clear instance
            lvl01ObjMgmt = null;
            finish();
            Log.i("DTT", "Going from LVL1 to LVL2...");
        }
	}
	
	public void sequence_driver_btn(View theButton){
		if(currentEvent == 1){
			DocEvent.sequenceDriver();
		}
        if(currentEvent == 2){
            BattleEvent.sequenceDriver();
        }
	}
	// ======================================================================================= //
	// ================= M O V E M E N T ==EVENT HANDLERS===================================== //
	// ======================================================================================= //
	// Down button action
	public void press_down(View v){
        PlayerMovement.down();
		eventHandle();
	}
	// Up button action
	public void press_up(View v){
        PlayerMovement.up();
		eventHandle();
	}
	// Right button action
	public void press_right(View v){
        PlayerMovement.right();
		eventHandle();
	}
	// Left button action
	public void press_left(View v){
        PlayerMovement.left();
		eventHandle();
	}
	// ======================================================================================= //
	// ================= P O K E R M E N  S C R E E N ======================================== //
	// ======================================================================================= //
	// opens the PRKMN screen
	public void show_pkrmn(View theButton){
        PlayerMovement.getLast();
		ShowPkrmn.InitializePokermenMenu(this);
	}
	// closes PKRMN screen
	public void close_pkrmn(View theButton){
		setContentView(R.layout.activity_lvl01);
        PlayerMovement.InitializeMovementControls(this);
        PlayerMovement.setLast();
		lvl01ObjMgmt.ReInitializeLevelScreen(this);
	}
	// listener for trash btn
	public void push_trash(View theButton){ ShowPkrmn.PushTrash(); }
	// listener for up1 btn
	public void push_up1(View theButton){
		ShowPkrmn.push_up1();
	}
	// listener for up2 btn
	public void push_up2(View theButton){
		ShowPkrmn.push_up2();
	}
	// listener for up3 btn
	public void push_up3(View theButton){
		ShowPkrmn.push_up3();
	}
	// listener for up4 btn
	public void push_up4(View theButton){
		ShowPkrmn.push_up4();
	}
	// listener for up5 btn
	public void push_up5(View theButton){
		ShowPkrmn.push_up5();
	}
	// listener for info1 btn
	public void push_info1(View theButton){
		ShowPkrmn.push_info1();
	}
	// listener for info2 btn
	public void push_info2(View theButton){
		ShowPkrmn.push_info2();
	}
	// listener for info3 btn
	public void push_info3(View theButton){
		ShowPkrmn.push_info3();
	}
	// listener for info4 btn
	public void push_info4(View theButton){
		ShowPkrmn.push_info4();
	}
	// listener for info5 btn
	public void push_info5(View theButton){
		ShowPkrmn.push_info5();
	}
	// listener for info6 btn
	public void push_info6(View theButton){
		ShowPkrmn.push_info6();
	}
	// ======================================================================================= //
	// ================= I T E M S        S C R E E N ======================================== //
	// ======================================================================================= //
	// opens the items screen
	public void show_items(View theButton){
        PlayerMovement.getLast();
		ShowItems.ShowItemsMenu(this);
    }

    // closes items screen
	public void close_items(View theButton){
		setContentView(R.layout.activity_lvl01);
        ShowPkrmn.ClosePokermenMenuCleanup();
        PlayerMovement.InitializeMovementControls(this);
        PlayerMovement.setLast();
        lvl01ObjMgmt.ReInitializeLevelScreen(this);
	}
}
	