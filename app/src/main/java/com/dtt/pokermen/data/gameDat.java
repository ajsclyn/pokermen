package com.dtt.pokermen.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.dtt.pokermen.object.PokObj;
import com.dtt.pokermen.object.PokerParty;

import java.util.ArrayList;

public final class gameDat {
	
	private static int game_lvl = 0;
	private static int battle_wins = 0;
	private static int battle_losses = 0;
	private static int badges = 0;
	private static int saved_game_stat = 0;
	private static String player_name = "";
	private static String rival_name = "";
	private static int player_money = 0;

	public static PokerParty PlayerPokerParty;
	
	// constructor =================================================================================
	private gameDat() {}

	// get member functions ========================================================================
	public static int get_saved_game_stat(){
		return saved_game_stat;
	}
	public static int get_badges(){
		return badges;
	}
	public static int get_player_money(){
		return player_money;
	}
	public static int get_game_lvl(){
		return game_lvl;
	}

	// set member functions ========================================================================
	public static void set_game_lvl(int x){
		game_lvl = x;
	}
	public static void set_numBadges(int x){
		badges = x;
	}
	public static void set_saveGameStat(int x){
		saved_game_stat = x;
	}
	public static void set_player_name(String x){
		player_name = x;
	}
	public static void set_rival_name(String x){
		rival_name = x;
	}
	public static void set_player_money(int x){
		player_money = x;
	}

	// LOAD SAVE RESET =============================================================================
	// loads all game data from DB
	public static void load_gameDat(Context x){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(x);

		PokObj pok1 = new PokObj();
		PokObj pok2 = new PokObj();
		PokObj pok3 = new PokObj();
		PokObj pok4 = new PokObj();
		PokObj pok5 = new PokObj();
		PokObj pok6 = new PokObj();

		game_lvl = preferences.getInt("game_lvl", game_lvl);
		battle_wins = preferences.getInt("battle_wins", battle_wins);
		battle_losses = preferences.getInt("battle_losses", battle_losses);
		badges = preferences.getInt("badges", badges);
		
		saved_game_stat = preferences.getInt("saved_game_stat", saved_game_stat);
		player_name = preferences.getString("player_name", player_name);
		rival_name = preferences.getString("rival_name", rival_name);
		player_money = preferences.getInt("player_money", player_money);
		
		// load pokermen party
		pok1.setId(preferences.getInt("pok1_id", 0));
		pok1.setName(preferences.getString("pok1_name", ""));
		pok1.setLvl(preferences.getInt("pok1_lvl", 0));
		pok1.setAtk(preferences.getInt("pok1_atk", 0));
		pok1.setDef(preferences.getInt("pok1_def", 0));
		pok1.setHp(preferences.getInt("pok1_hp", 0));
		pok1.setHpMax(preferences.getInt("pok1_hp_max", 0));
		pok1.setEs(preferences.getInt("pok1_es", 0));
		
		pok2.setId(preferences.getInt("pok2_id", 0));
		pok2.setName(preferences.getString("pok2_name", ""));
		pok2.setLvl(preferences.getInt("pok2_lvl", 0));
		pok2.setAtk(preferences.getInt("pok2_atk", 0));
		pok2.setDef(preferences.getInt("pok2_def", 0));
		pok2.setHp(preferences.getInt("pok2_hp", 0));
		pok2.setHpMax(preferences.getInt("pok2_hp_max", 0));
		pok2.setEs(preferences.getInt("pok2_es", 0));
		
		pok3.setId(preferences.getInt("pok3_id", 0));
		pok3.setName(preferences.getString("pok3_name", ""));
		pok3.setLvl(preferences.getInt("pok3_lvl", 0));
		pok3.setAtk(preferences.getInt("pok3_atk", 0));
		pok3.setDef(preferences.getInt("pok3_def", 0));
		pok3.setHp(preferences.getInt("pok3_hp", 0));
		pok3.setHpMax(preferences.getInt("pok3_hp_max", 0));
		pok3.setEs(preferences.getInt("pok3_es", 0));
		
		pok4.setId(preferences.getInt("pok4_id", 0));
		pok4.setName(preferences.getString("pok4_name", ""));
		pok4.setLvl(preferences.getInt("pok4_lvl", 0));
		pok4.setAtk(preferences.getInt("pok4_atk", 0));
		pok4.setDef(preferences.getInt("pok4_def", 0));
		pok4.setHp(preferences.getInt("pok4_hp", 0));
		pok4.setHpMax(preferences.getInt("pok4_hp_max", 0));
		pok4.setEs(preferences.getInt("pok4_es", 0));
		
		pok5.setId(preferences.getInt("pok5_id", 0));
		pok5.setName(preferences.getString("pok5_name", ""));
		pok5.setLvl(preferences.getInt("pok5_lvl", 0));
		pok5.setAtk(preferences.getInt("pok5_atk", 0));
		pok5.setDef(preferences.getInt("pok5_def", 0));
		pok5.setHp(preferences.getInt("pok5_hp", 0));
		pok5.setHpMax(preferences.getInt("pok5_hp_max", 0));
		pok5.setEs(preferences.getInt("pok5_es", 0));
		
		pok6.setId(preferences.getInt("pok6_id", 0));
		pok6.setName(preferences.getString("pok6_name", ""));
		pok6.setLvl(preferences.getInt("pok6_lvl", 0));
		pok6.setAtk(preferences.getInt("pok6_atk", 0));
		pok6.setDef(preferences.getInt("pok6_def", 0));
		pok6.setHp(preferences.getInt("pok6_hp", 0));
		pok6.setHpMax(preferences.getInt("pok6_hp_max", 0));
		pok6.setEs(preferences.getInt("pok6_es", 0));

		ArrayList<PokObj> pl = new ArrayList<PokObj>();
		if(pok1.getId() != 0)
			pl.add(pok1);
		if(pok2.getId() != 0)
			pl.add(pok2);
		if(pok3.getId() != 0)
			pl.add(pok3);
		if(pok4.getId() != 0)
			pl.add(pok4);
		if(pok5.getId() != 0)
			pl.add(pok5);
		if(pok6.getId() != 0)
			pl.add(pok6);
		PlayerPokerParty = new PokerParty(pl);

		Toast.makeText(x, "Game DAT loaded.", Toast.LENGTH_SHORT).show();
		itemDat.load(x);
		Log.i("DTT","load_gameDat finished.");
	}
	
	// saves all game data to DB
	public static void save_gameDat(Context x){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(x);
		SharedPreferences.Editor editor = preferences.edit();
		
		editor.putInt("game_lvl", game_lvl);
		editor.putInt("battle_wins", battle_wins);
		editor.putInt("battle_losses", battle_losses);
		editor.putInt("badges", badges);
		
		editor.putInt("saved_game_stat", saved_game_stat);
		editor.putString("player_name", player_name);
		editor.putString("rival_name", rival_name);
		editor.putInt("player_money", player_money);

		PokObj temp;

		// save pokermen party
		temp = PlayerPokerParty.GetPokermenInSlot(1);
		editor.putInt("pok1_id",temp.getId());
		editor.putString("pok1_name", temp.getName());
		editor.putInt("pok1_lvl", temp.getLvl());
		editor.putInt("pok1_atk",  temp.getAtk());
		editor.putInt("pok1_def", temp.getDef());
		editor.putInt("pok1_hp",  temp.getHp());
		editor.putInt("pok1_hp_max", temp.getHpMax());
		editor.putInt("pok1_es",  temp.getEs());

		temp = PlayerPokerParty.GetPokermenInSlot(2);
		editor.putInt("pok2_id",  temp.getId());
		editor.putString("pok2_name", temp.getName());
		editor.putInt("pok2_lvl", temp.getLvl());
		editor.putInt("pok2_atk", temp.getAtk());
		editor.putInt("pok2_def", temp.getDef());
		editor.putInt("pok2_hp", temp.getHp());
		editor.putInt("pok2_hp_max", temp.getHpMax());
		editor.putInt("pok2_es", temp.getEs());

		temp = PlayerPokerParty.GetPokermenInSlot(3);
		editor.putInt("pok3_id", temp.getId());
		editor.putString("pok3_name", temp.getName());
		editor.putInt("pok3_lvl", temp.getLvl());
		editor.putInt("pok3_atk", temp.getAtk());
		editor.putInt("pok3_def", temp.getDef());
		editor.putInt("pok3_hp", temp.getHp());
		editor.putInt("pok3_hp_max", temp.getHpMax());
		editor.putInt("pok3_es", temp.getEs());

		temp = PlayerPokerParty.GetPokermenInSlot(4);
		editor.putInt("pok4_id", temp.getId());
		editor.putString("pok4_name", temp.getName());
		editor.putInt("pok4_lvl", temp.getLvl());
		editor.putInt("pok4_atk", temp.getAtk());
		editor.putInt("pok4_def", temp.getDef());
		editor.putInt("pok4_hp", temp.getHp());
		editor.putInt("pok4_hp_max", temp.getHpMax());
		editor.putInt("pok4_es", temp.getEs());

		temp = PlayerPokerParty.GetPokermenInSlot(5);
		editor.putInt("pok5_id", temp.getId());
		editor.putString("pok5_name", temp.getName());
		editor.putInt("pok5_lvl", temp.getLvl());
		editor.putInt("pok5_atk", temp.getAtk());
		editor.putInt("pok5_def", temp.getDef());
		editor.putInt("pok5_hp", temp.getHp());
		editor.putInt("pok5_hp_max", temp.getHpMax());
		editor.putInt("pok5_es", temp.getEs());

		temp = PlayerPokerParty.GetPokermenInSlot(6);
		editor.putInt("pok6_id", temp.getId());
		editor.putString("pok6_name", temp.getName());
		editor.putInt("pok6_lvl", temp.getLvl());
		editor.putInt("pok6_atk", temp.getAtk());
		editor.putInt("pok6_def", temp.getDef());
		editor.putInt("pok6_hp", temp.getHp());
		editor.putInt("pok6_hp_max", temp.getHpMax());
		editor.putInt("pok6_es", temp.getEs());

		temp = null;
		editor.commit();
		// save items
		//itemDat.save(this);
		Toast.makeText(x, "Game DAT saved.", Toast.LENGTH_SHORT).show();
		Log.i("DTT","save_gameDat finished.");
	}
	
	// Resets gameDat
	public static void reset_gameDat(Context x){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(x);
		SharedPreferences.Editor editor = preferences.edit();
		
		editor.clear();
		editor.commit();
	}

	// future DB methods ===========================================================================
    public static void saveDB(Context x){
        //PokObjectSQLiteHandler db = new PokObjectSQLiteHandler(this);

    }
	
}
