package com.dtt.pokermen.levels.level02;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dtt.pokermen.event.DocEvent;
import com.dtt.pokermen.levels.level03.Lvl03;
import com.dtt.pokermen.R;
import com.dtt.pokermen.menu.ShowItems;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.levels.level01.Lvl01;
import com.dtt.pokermen.util.MusicManagment;
import com.dtt.pokermen.util.PlayerMovement;
import com.dtt.pokermen.menu.ShowPkrmn;

public class Lvl02 extends Activity {

	Lvl02ObjMgmt obs;
	int current_event = 0;
    int starting_dir = 0;

	// Orientation helper
	public class ActivityHelper {
	    public void initialize(Activity activity) {
	        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    }
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lvl02);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            starting_dir =(Integer) b.get("dir");
        }
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
		initialize();
	}
	
	
	// ON RESUME
	public void onResume() {
	    super.onResume();
		MusicManagment.PlayMusic(this, MusicManagment.Songs.HipHopCity);
	}
	
	// ON PAUSE
	public void onPause() {
        super.onPause();
		MusicManagment.Stop();
    }
	
	public void initialize(){
		gameDat.set_game_lvl(2);
		obs = new Lvl02ObjMgmt(this);
		PlayerMovement.InitializeMovementControls(this);
        if(starting_dir == 1){
            PlayerMovement.setToTop();
        }
        else
			PlayerMovement.setToOrigin();
	}
	
	// ---------------------------------------------------------------------------------- //
	// -------------------- L E V E L  S P E C I F I C  D E T E C T O R S --------------- //
	// ---------------------------------------------------------------------------------- //

	// event root
	public void eventHandle(){
		Log.i("DTT","eventHandle called.");
		int id = obs.probe();
		Log.i("DTT","id from probe = " + id);
		if(id == 1){
			DocEvent.InitializeDocEvent(this);
			current_event = 1;
		}
        if(id == 4){
            Intent change_lvl = new Intent(this,Lvl03.class);
            startActivity(change_lvl);
            finish();
            Log.i("DTT","Going from LVL2 to LVL3...");
        }
		if(id == 5){
			Intent change_lvl = new Intent(this,Lvl01.class);
			change_lvl.putExtra("dir", 1);
			startActivity(change_lvl);
			finish();
			Log.i("DTT","Going from LVL2 to LVL1...");
		}
		
	}
	
	public void sequence_driver_btn(View theButton){
		if(current_event == 1){
			DocEvent.sequenceDriver();
		}
	}
	


	// Save button listener
	public void save_btn_press(View theButton){
		gameDat.save_gameDat(this);
	}
	
	
	// ======================================================================================= //
	// ================= M O V E M E N T ===================================================== //
	// ======================================================================================= //

	public void setPlayerOrigin(){
		PlayerMovement.setToOrigin();
	}
	
	// Down button action

	public void press_down(View theButton){
		PlayerMovement.down();
		eventHandle();
	}
	
	// Actions for pressing up button
	// Up button action

	public void press_up(View theButton){
		PlayerMovement.up();
		eventHandle();
	}
	

	// Right button action
	public void press_right(View theButton){
		PlayerMovement.right();
		eventHandle();
	}
	
	// Left button action
	public void press_left(View theButton){
		PlayerMovement.left();
		eventHandle();
	}
	
	
	// ======================== E N D ======================================================== //
	// ================= M O V E M E N T ===================================================== //
	// ======================================================================================= //
	
	//-----------------------------------------------------------------------------------------//
	
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
		obs.findViews();
		obs.set_npc_locatoin_lvl_2();
		obs.update_town_txt();
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
	// ========== E N D  P O K E R M E N  S C R E E N ======================================== //
	// ======================================================================================= //
	
	//-----------------------------------------------------------------------------------------//
	
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
		setContentView(R.layout.activity_lvl02);
		PlayerMovement.InitializeMovementControls(this);
		PlayerMovement.setLast();
		obs.findViews();
		obs.set_npc_locatoin_lvl_2();
		obs.update_town_txt();
	}
	
	
	
	
	// ======================================================================================= //
	// ========== E N D  I T E M S        S C R E E N ======================================== //
	// ======================================================================================= //
}
	

