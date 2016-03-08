package com.dtt.pokermen.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dtt.pokermen.R;
import com.dtt.pokermen.data.gameDat;
import com.dtt.pokermen.object.PokObj;
import com.dtt.pokermen.util.ResourceManager;


public final class ShowPkrmn {

	private static Activity _activity = null;

	private static TextView pok01_name;
	private static TextView pok01_lvl;
	private static TextView pok01_hp;
	private static TextView pok01_hp_total;

	private static TextView pok02_name;
	private static TextView pok02_lvl;
	private static TextView pok02_hp;
	private static TextView pok02_hp_total;

	private static TextView pok03_name;
	private static TextView pok03_lvl;
	private static TextView pok03_hp;
	private static TextView pok03_hp_total;

	private static TextView pok04_name;
	private static TextView pok04_lvl;
	private static TextView pok04_hp;
	private static TextView pok04_hp_total;

	private static TextView pok05_name;
	private static TextView pok05_lvl;
	private static TextView pok05_hp;
	private static TextView pok05_hp_total;

	private static TextView pok06_name;
	private static TextView pok06_lvl;
	private static TextView pok06_hp;
	private static TextView pok06_hp_total;

	private static ImageView pok1_img;
	private static ImageView pok2_img;
	private static ImageView pok3_img;
	private static ImageView pok4_img;
	private static ImageView pok5_img;
	private static ImageView pok6_img;

	private static ProgressBar bar1;
	private static ProgressBar bar2;
	private static ProgressBar bar3;
	private static ProgressBar bar4;
	private static ProgressBar bar5;
	private static ProgressBar bar6;

	private static Button trash;
	private static Button up1;
	private static Button up2;
	private static Button up3;
	private static Button up4;
	private static Button up5;
	private static Button info1;
	private static Button info2;
	private static Button info3;
	private static Button info4;
	private static Button info5;
	private static Button info6;

	public ShowPkrmn(){}

	public static void InitializePokermenMenu(Activity a){
		_activity = a;

		a.setContentView(R.layout.pokermen_screen);

		pok01_name = (TextView) a.findViewById(R.id.txt_pok01_name);
		pok01_lvl = (TextView) a.findViewById(R.id.txt_pok01_lvl);
		pok01_hp = (TextView) a.findViewById(R.id.txt_pok01_hp);
		pok01_hp_total = (TextView) a.findViewById(R.id.txt_pok01_hp_total);

		pok02_name = (TextView) a.findViewById(R.id.txt_pok02_name);
		pok02_lvl = (TextView) a.findViewById(R.id.txt_pok02_lvl);
		pok02_hp = (TextView) a.findViewById(R.id.txt_pok02_hp);
		pok02_hp_total = (TextView) a.findViewById(R.id.txt_pok02_hp_total);

		pok03_name = (TextView) a.findViewById(R.id.txt_pok03_name);
		pok03_lvl = (TextView) a.findViewById(R.id.txt_pok03_lvl);
		pok03_hp = (TextView) a.findViewById(R.id.txt_pok03_hp);
		pok03_hp_total = (TextView) a.findViewById(R.id.txt_pok03_hp_total);

		pok04_name = (TextView) a.findViewById(R.id.txt_pok04_name);
		pok04_lvl = (TextView) a.findViewById(R.id.txt_pok04_lvl);
		pok04_hp = (TextView) a.findViewById(R.id.txt_pok04_hp);
		pok04_hp_total = (TextView) a.findViewById(R.id.txt_pok04_hp_total);

		pok05_name = (TextView) a.findViewById(R.id.txt_pok05_name);
		pok05_lvl = (TextView) a.findViewById(R.id.txt_pok05_lvl);
		pok05_hp = (TextView) a.findViewById(R.id.txt_pok05_hp);
		pok05_hp_total = (TextView) a.findViewById(R.id.txt_pok05_hp_total);

		pok06_name = (TextView) a.findViewById(R.id.txt_pok06_name);
		pok06_lvl = (TextView) a.findViewById(R.id.txt_pok06_lvl);
		pok06_hp = (TextView) a.findViewById(R.id.txt_pok06_hp);
		pok06_hp_total = (TextView) a.findViewById(R.id.txt_pok06_hp_total);

		pok1_img = (ImageView) a.findViewById(R.id.img_pok01);
		pok2_img = (ImageView) a.findViewById(R.id.img_pok02);
		pok3_img = (ImageView) a.findViewById(R.id.img_pok03);
		pok4_img = (ImageView) a.findViewById(R.id.img_pok04);
		pok5_img = (ImageView) a.findViewById(R.id.img_pok05);
		pok6_img = (ImageView) a.findViewById(R.id.img_pok06);

		bar1 = (ProgressBar) a.findViewById(R.id.prog_pok01);
		bar2 = (ProgressBar) a.findViewById(R.id.prog_pok02);
		bar3 = (ProgressBar) a.findViewById(R.id.prog_pok03);
		bar4 = (ProgressBar) a.findViewById(R.id.prog_pok04);
		bar5 = (ProgressBar) a.findViewById(R.id.prog_pok05);
		bar6 = (ProgressBar) a.findViewById(R.id.prog_pok06);

		trash = (Button) a.findViewById(R.id.but_trash);
		up1 = (Button) a.findViewById(R.id.but_up1);
		up2 = (Button) a.findViewById(R.id.but_up2);
		up3 = (Button) a.findViewById(R.id.but_up3);
		up4 = (Button) a.findViewById(R.id.but_up4);
		up5 = (Button) a.findViewById(R.id.but_up5);
		info1 = (Button) a.findViewById(R.id.but_info1);
		info2 = (Button) a.findViewById(R.id.but_info2);
		info3 = (Button) a.findViewById(R.id.but_info3);
		info4 = (Button) a.findViewById(R.id.but_info4);
		info5 = (Button) a.findViewById(R.id.but_info5);
		info6 = (Button) a.findViewById(R.id.but_info6);

		refreshScreen();
	}

	public static void ClosePokermenMenuCleanup(){
		pok01_name = null;
		pok01_lvl = null;
		pok01_hp = null;
		pok01_hp_total = null;
		pok02_name = null;
		pok02_lvl = null;
		pok02_hp = null;
		pok02_hp_total = null;
		pok03_name = null;
		pok03_lvl = null;
		pok03_hp = null;
		pok03_hp_total = null;
		pok04_name = null;
		pok04_lvl = null;
		pok04_hp = null;
		pok04_hp_total = null;
		pok05_name = null;
		pok05_lvl = null;
		pok05_hp = null;
		pok05_hp_total = null;
		pok06_name = null;
		pok06_lvl = null;
		pok06_hp = null;
		pok06_hp_total = null;
		pok1_img = null;
		pok2_img = null;
		pok3_img = null;
		pok4_img = null;
		pok5_img = null;
		pok6_img = null;
		bar1 = null;
		bar2 = null;
		bar3 = null;
		bar4 = null;
		bar5 = null;
		bar6 = null;
		trash = null;
		up1 = null;
		up2 = null;
		up3 = null;
		up4 = null;
		up5 = null;
		info1 = null;
		info2 = null;
		info3 = null;
		info4 = null;
		info5 = null;
		info6 = null;
		_activity = null;
	}

	private static void updateFieldInfo(){

		pok01_name.setText(gameDat.PlayerPokerParty.GetPokermenInSlot(1).getName());
		pok01_lvl.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(1).getLvl()));
		pok01_hp.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(1).getHp()));
		pok01_hp_total.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(1).getHpMax()));
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getId() != 0){
			pok02_name.setText(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getName());
			pok02_lvl.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getLvl()));
			pok02_hp.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getHp()));
			pok02_hp_total.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getHpMax()));
		}
		else{
			pok02_name.setText("empty slot");
			pok02_lvl.setText(" -");
			pok02_hp.setText(" ");
			pok02_hp_total.setText(" ");
		}

		if(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getId() != 0){
			pok03_name.setText(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getName());
			pok03_lvl.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getLvl()));
			pok03_hp.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getHp()));
			pok03_hp_total.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getHpMax()));
		}
		else{
			pok03_name.setText("empty slot");
			pok03_lvl.setText(" -");
			pok03_hp.setText(" ");
			pok03_hp_total.setText(" ");
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getId() != 0){
			pok04_name.setText(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getName());
			pok04_lvl.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getLvl()));
			pok04_hp.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getHp()));
			pok04_hp_total.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getHpMax()));
		}
		else{
			pok04_name.setText("empty slot");
			pok04_lvl.setText(" -");
			pok04_hp.setText(" ");
			pok04_hp_total.setText(" ");
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getId() != 0){
			pok05_name.setText(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getName());
			pok05_lvl.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getLvl()));
			pok05_hp.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getHp()));
			pok05_hp_total.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getHpMax()));
		}
		else{
			pok05_name.setText("empty slot");
			pok05_lvl.setText(" -");
			pok05_hp.setText(" ");
			pok05_hp_total.setText(" ");
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getId() != 0){
			pok06_name.setText(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getName());
			pok06_lvl.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getLvl()));
			pok06_hp.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getHp()));
			pok06_hp_total.setText(Integer.toString(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getHpMax()));
		}
		else{
			pok06_name.setText("empty slot");
			pok06_lvl.setText(" -");
			pok06_hp.setText(" ");
			pok06_hp_total.setText(" ");
		}
	}

	private static void refreshScreen(){
		updateImg();
		updateBar();
		updateBtns();
		updateFieldInfo();
	}
	
	private static void updateImg(){
		pok1_img.setImageResource(ResourceManager.GetPokermenImageFrontById(gameDat.PlayerPokerParty.GetPokermenInSlot(1).getId()));
		pok2_img.setImageResource(ResourceManager.GetPokermenImageFrontById(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getId()));
		pok3_img.setImageResource(ResourceManager.GetPokermenImageFrontById(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getId()));
		pok4_img.setImageResource(ResourceManager.GetPokermenImageFrontById(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getId()));
		pok5_img.setImageResource(ResourceManager.GetPokermenImageFrontById(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getId()));
		pok6_img.setImageResource(ResourceManager.GetPokermenImageFrontById(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getId()));
	}
	
	public static void updateBar(){
		float percent = 0;
		
		percent = ((float) gameDat.PlayerPokerParty.GetPokermenInSlot(1).getHp())/((float) gameDat.PlayerPokerParty.GetPokermenInSlot(1).getHpMax());
		bar1.setProgress((int) (percent*100));
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getId() != 0){
			percent = ((float) gameDat.PlayerPokerParty.GetPokermenInSlot(2).getHp())/((float) gameDat.PlayerPokerParty.GetPokermenInSlot(2).getHpMax());
			bar2.setProgress((int) (percent*100));
		}
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getId() != 0){
			percent = ((float) gameDat.PlayerPokerParty.GetPokermenInSlot(3).getHp())/((float) gameDat.PlayerPokerParty.GetPokermenInSlot(3).getHpMax());
			bar3.setProgress((int) (percent*100));
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getId() != 0){
			percent = ((float) gameDat.PlayerPokerParty.GetPokermenInSlot(4).getHp())/((float) gameDat.PlayerPokerParty.GetPokermenInSlot(4).getHpMax());
			bar4.setProgress((int) (percent*100));
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getId() != 0){
			percent = ((float) gameDat.PlayerPokerParty.GetPokermenInSlot(5).getHp())/((float) gameDat.PlayerPokerParty.GetPokermenInSlot(5).getHpMax());
			bar5.setProgress((int) (percent*100));
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getId() != 0){
			percent = ((float) gameDat.PlayerPokerParty.GetPokermenInSlot(6).getHp())/((float) gameDat.PlayerPokerParty.GetPokermenInSlot(6).getHpMax());
			bar6.setProgress((int) (percent*100));
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getId() == 0){
			bar2.setProgress(0);
		}
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getId() == 0){
			bar3.setProgress(0);
		}
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getId() == 0){
			bar4.setProgress(0);
		}
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getId() == 0){
			bar5.setProgress(0);
		}
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getId() == 0){
			bar6.setProgress(0);
		}
	}
	
	public static void updateBtns(){
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(2).getId() == 0){
			trash.setEnabled(false);
			trash.setBackgroundColor(0);
			
			up1.setEnabled(false);
			up1.setBackgroundColor(0);
			info2.setEnabled(false);
			info2.setBackgroundColor(0);
		}
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(3).getId() == 0){
			up2.setEnabled(false);
			up2.setBackgroundColor(0);
			info3.setEnabled(false);
			info3.setBackgroundColor(0);
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(4).getId() == 0){
			up3.setEnabled(false);
			up3.setBackgroundColor(0);
			info4.setEnabled(false);
			info4.setBackgroundColor(0);
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(5).getId() == 0){
			up4.setEnabled(false);
			up4.setBackgroundColor(0);
			info5.setEnabled(false);
			info5.setBackgroundColor(0);
		}
		
		if(gameDat.PlayerPokerParty.GetPokermenInSlot(6).getId() == 0){
			up5.setEnabled(false);
			up5.setBackgroundColor(0);
			info6.setEnabled(false);
			info6.setBackgroundColor(0);
		}
		
	}
	
	private static void PerformTrash(){
		gameDat.PlayerPokerParty.DeleteFirstPokermen();
		gameDat.PlayerPokerParty.AddPokermenToParty(new PokObj());
		refreshScreen();
	}
	public static void push_up1(){
		gameDat.PlayerPokerParty.SwapSlotUp(2);
		refreshScreen();
	}
	public static void push_up2(){
		gameDat.PlayerPokerParty.SwapSlotUp(3);
		refreshScreen();
	}
	public static void push_up3(){
		gameDat.PlayerPokerParty.SwapSlotUp(4);
		refreshScreen();
	}
	public static void push_up4(){
		gameDat.PlayerPokerParty.SwapSlotUp(5);
		refreshScreen();
	}
	public static void push_up5(){
		gameDat.PlayerPokerParty.SwapSlotUp(6);
		refreshScreen();
	}
	public static void push_info1(){
		

	}
	public static void push_info2(){
		

	}
	public static void push_info3(){
		

	}
	public static void push_info4(){
		

	}
	public static void push_info5(){
		

	}
	public static void push_info6(){
		

	}

	public static void PushTrash(){
		new AlertDialog.Builder(_activity)
				.setTitle("DANGER!!!")
				.setMessage("YOU ARE BOUT TO RELEASE THIS POKERMEN FOREVER! ARE YOU FOR REAL???")
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton("heck yeah this turd sucks!", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {
						ConfirmTrash();
					}})
				.setNegativeButton("abort!!1", null).show();

	}
	private static void ConfirmTrash(){
		new AlertDialog.Builder(_activity)
				.setTitle("RLY THO??")
				.setMessage("BUT I MEAN R U 5SURE?? If you let it go it will die from starvatoin or stray bullets!!")
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton("im ready lets do this", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {
						ShowPkrmn.PerformTrash();
					}})
				.setNegativeButton("uh ok never mind whatever", null).show();
	}

}
