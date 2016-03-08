package com.dtt.pokermen.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

//   !!!   REFRENCE : https://docs.google.com/spreadsheets/d/1Kjl3hf8j7KJCeW4w6av2XOFl-UVQ0orYqMeULr78WYc/edit#gid=660416447

public final class itemDat {

	public static int i01;
	public static int i02;
	public static int i03;
	public static int i04;
	public static int i05;
	public static int i06;
	public static int i07;
	public static int i08;
	public static int i09;
	public static int i10;
	public static int i11;
	public static int i12;
	public static int i13;
	public static int i14;
	public static int i15;
	public static int i16;
	public static int i17;
	public static int i18;
	public static int i19;
	public static int i20;
	public static int i21;
	public static int i22;
	public static int i23;
	public static int i24;
	public static int i25;
	public static int i26;
	public static int i27;
	public static int i28;
	public static int i29;
	public static int i30;
	public static int i31;
	public static int i32;
	public static int i33;
	public static int i34;
	public static int i35;
	public static int i36;
	public static int i37;
	public static int i38;
	public static int i39;
	public static int i40;
	
	private itemDat(){
		i01 = 0;
		i02 = 0;
		i03 = 0;
		i04 = 0;
		i05 = 0;
		i06 = 0;
		i07 = 0;
		i08 = 0;
		i09 = 0;
		i10 = 0;
		i11 = 0;
		i12 = 0;
		i13 = 0;
		i14 = 0;
		i15 = 0;
		i16 = 0;
		i17 = 0;
		i18 = 0;
		i19 = 0;
		i20 = 0;
		i21 = 0;
		i22 = 0;
		i23 = 0;
		i24 = 0;
		i25 = 0;
		i26 = 0;
		i27 = 0;
		i28 = 0;
		i29 = 0;
		i30 = 0;
		i31 = 0;
		i32 = 0;
		i33 = 0;
		i34 = 0;
		i35 = 0;
		i36 = 0;
		i37 = 0;
		i38 = 0;
		i39 = 0;
		i40 = 0;
	}
	
	public static void load(Context x){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(x);

		i01 = preferences.getInt("i01", i01);
		i02 = preferences.getInt("i02", i02);
		i03 = preferences.getInt("i03", i03);
		i04 = preferences.getInt("i04", i04);
		i05 = preferences.getInt("i05", i05);
		i06 = preferences.getInt("i06", i06);
		i07 = preferences.getInt("i07", i07);
		i08 = preferences.getInt("i08", i08);
		i09 = preferences.getInt("i09", i09);
		i10 = preferences.getInt("i10", i10);
		i11 = preferences.getInt("i11", i11);
		i12 = preferences.getInt("i12", i12);
		i13 = preferences.getInt("i13", i13);
		i14 = preferences.getInt("i14", i14);
		i15 = preferences.getInt("i15", i15);
		i16 = preferences.getInt("i16", i16);
		i17 = preferences.getInt("i17", i17);
		i18 = preferences.getInt("i18", i18);
		i19 = preferences.getInt("i19", i19);
		i20 = preferences.getInt("i20", i20);
		i21 = preferences.getInt("i21", i21);
		i22 = preferences.getInt("i22", i22);
		i23 = preferences.getInt("i23", i23);
		i24 = preferences.getInt("i24", i24);
		i25 = preferences.getInt("i25", i25);
		i26 = preferences.getInt("i26", i26);
		i27 = preferences.getInt("i27", i27);
		i28 = preferences.getInt("i28", i28);
		i29 = preferences.getInt("i29", i29);
		i30 = preferences.getInt("i30", i30);
		i31 = preferences.getInt("i31", i31);
		i32 = preferences.getInt("i32", i32);
		i33 = preferences.getInt("i33", i33);
		i34 = preferences.getInt("i34", i34);
		i35 = preferences.getInt("i35", i35);
		i36 = preferences.getInt("i36", i36);
		i37 = preferences.getInt("i37", i37);
		i38 = preferences.getInt("i38", i38);
		i39 = preferences.getInt("i39", i39);
		i40 = preferences.getInt("i40", i40);
		
		Log.i("DTT","itemDat loaded.");
	}
	
	public static void save(Context x){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(x);
		SharedPreferences.Editor editor = preferences.edit();
		
		editor.putInt("i01", i01);
		editor.putInt("i02", i02);
		editor.putInt("i03", i03);
		editor.putInt("i04", i04);
		editor.putInt("i05", i05);
		editor.putInt("i06", i06);
		editor.putInt("i07", i07);
		editor.putInt("i08", i08);
		editor.putInt("i09", i09);
		editor.putInt("i10", i10);
		editor.putInt("i11", i11);
		editor.putInt("i12", i12);
		editor.putInt("i13", i13);
		editor.putInt("i14", i14);
		editor.putInt("i15", i15);
		editor.putInt("i16", i16);
		editor.putInt("i17", i17);
		editor.putInt("i18", i18);
		editor.putInt("i19", i19);
		editor.putInt("i20", i20);
		editor.putInt("i21", i21);
		editor.putInt("i22", i22);
		editor.putInt("i23", i23);
		editor.putInt("i24", i24);
		editor.putInt("i25", i25);
		editor.putInt("i26", i26);
		editor.putInt("i27", i27);
		editor.putInt("i28", i28);
		editor.putInt("i29", i29);
		editor.putInt("i30", i30);
		editor.putInt("i31", i31);
		editor.putInt("i32", i32);
		editor.putInt("i33", i33);
		editor.putInt("i34", i34);
		editor.putInt("i35", i35);
		editor.putInt("i36", i36);
		editor.putInt("i37", i37);
		editor.putInt("i38", i38);
		editor.putInt("i39", i39);
		editor.putInt("i40", i40);

		editor.commit();
		
		Log.i("DTT","itemDat saved.");
		
	}
	
	public static int getQty(int id_num){
		int qty = 0;
		
		if(id_num == 1){
			qty = i01;
		}
		if(id_num == 2){
			qty = i02;
		}
		if(id_num == 3){
			qty = i03;
		}
		if(id_num == 4){
			qty = i04;
		}
		if(id_num == 5){
			qty = i05;
		}
		if(id_num == 6){
			qty = i06;
		}
		if(id_num == 7){
			qty = i07;
		}
		if(id_num == 8){
			qty = i08;
		}
		if(id_num == 9){
			qty = i09;
		}
		if(id_num == 10){
			qty = i10;
		}
		if(id_num == 11){
			qty = i11;
		}
		if(id_num == 12){
			qty = i12;
		}
		if(id_num == 13){
			qty = i13;
		}
		if(id_num == 14){
			qty = i14;
		}
		if(id_num == 15){
			qty = i15;
		}
		if(id_num == 16){
			qty = i16;
		}
		if(id_num == 17){
			qty = i17;
		}
		if(id_num == 18){
			qty = i18;
		}
		if(id_num == 19){
			qty = i19;
		}
		if(id_num == 20){
			qty = i20;
		}
		if(id_num == 21){
			qty = i21;
		}
		if(id_num == 22){
			qty = i22;
		}
		if(id_num == 23){
			qty = i23;
		}
		if(id_num == 24){
			qty = i24;
		}
		if(id_num == 25){
			qty = i25;
		}
		if(id_num == 26){
			qty = i26;
		}
		if(id_num == 27){
			qty = i27;
		}
		if(id_num == 28){
			qty = i28;
		}
		if(id_num == 29){
			qty = i29;
		}
		if(id_num == 30){
			qty = i30;
		}
		if(id_num == 31){
			qty = i31;
		}
		if(id_num == 32){
			qty = i32;
		}
		if(id_num == 33){
			qty = i33;
		}
		if(id_num == 34){
			qty = i34;
		}
		if(id_num == 35){
			qty = i35;
		}
		if(id_num == 36){
			qty = i36;
		}
		if(id_num == 37){
			qty = i37;
		}
		if(id_num == 38){
			qty = i38;
		}
		if(id_num == 39){
			qty = i39;
		}
		if(id_num == 40){
			qty = i40;
		}
		
		return qty;
	}
	
	public static String getName(int id_num){
		String name = "";
		
		if(id_num == 1){
			name = "Nutter Key 1";
		}
		if(id_num == 2){
			name = "Nutter Key 2";
		}
		if(id_num == 3){
			name = "Nutter Key 3";
		}
		if(id_num == 4){
			name = "Potion-";
		}
		if(id_num == 5){
			name = "Potion+";
		}
		if(id_num == 6){
			name = "Potion++";
		}
		if(id_num == 7){
			name = "Potion+++";
		}
		if(id_num == 8){
			name = "Reviver";
		}
		if(id_num == 9){
			name = "PP Restore";
		}
		if(id_num == 10){
			name = "pokerball";
		}
		if(id_num == 11){
			name = "good pokerball";
		}
		if(id_num == 12){
			name = "rly good pokerball";
		}
		if(id_num == 13){
			name = "very rly good pokerball";
		}
		if(id_num == 14){
			name = "";
		}
		if(id_num == 15){
			name = "";
		}
		if(id_num == 16){
			name = "";
		}
		if(id_num == 17){
			name = "";
		}
		if(id_num == 18){
			name = "";
		}
		if(id_num == 19){
			name = "";
		}
		if(id_num == 20){
			name = "";
		}
		if(id_num == 21){
			name = "";
		}
		if(id_num == 22){
			name = "";
		}
		if(id_num == 23){
			name = "";
		}
		if(id_num == 24){
			name = "";
		}
		if(id_num == 25){
			name = "";
		}
		if(id_num == 26){
			name = "";
		}
		if(id_num == 27){
			name = "";
		}
		if(id_num == 28){
			name = "";
		}
		if(id_num == 29){
			name = "";
		}
		if(id_num == 30){
			name = "";
		}
		if(id_num == 31){
			name = "";
		}
		if(id_num == 32){
			name = "";
		}
		if(id_num == 33){
			name = "";
		}
		if(id_num == 34){
			name = "";
		}
		if(id_num == 35){
			name = "";
		}
		if(id_num == 36){
			name = "";
		}
		if(id_num == 37){
			name = "";
		}
		if(id_num == 38){
			name = "";
		}
		if(id_num == 39){
			name = "";
		}
		if(id_num == 40){
			name = "";
		}
		
		return name;
	}

	public static String getInfo(int id_num){
		String inf = "";
		
		if(id_num == 1){
			inf = "This is the key 1 of 3 of the Nutterville gate.";
		}
		if(id_num == 2){
			inf = "This is the key 2 of 3 of the Nutterville gate.";
		}
		if(id_num == 3){
			inf = "This is the key 3 of 3 of the Nutterville gate.";
		}
		if(id_num == 4){
			inf = "Hurts 50 HP";
		}
		if(id_num == 5){
			inf = "Potion+";
		}
		if(id_num == 6){
			inf = "Potion++";
		}
		if(id_num == 7){
			inf = "Potion+++";
		}
		if(id_num == 8){
			inf = "Reviver";
		}
		if(id_num == 9){
			inf = "PP Restore";
		}
		if(id_num == 10){
			inf = "pokerball";
		}
		if(id_num == 11){
			inf = "good pokerball";
		}
		if(id_num == 12){
			inf = "rly good pokerball";
		}
		if(id_num == 13){
			inf = "very rly good pokerball";
		}
		if(id_num == 14){
			inf = "";
		}
		if(id_num == 15){
			inf = "";
		}
		if(id_num == 16){
			inf = "";
		}
		if(id_num == 17){
			inf = "";
		}
		if(id_num == 18){
			inf = "";
		}
		if(id_num == 19){
			inf = "";
		}
		if(id_num == 20){
			inf = "";
		}
		if(id_num == 21){
			inf = "";
		}
		if(id_num == 22){
			inf = "";
		}
		if(id_num == 23){
			inf = "";
		}
		if(id_num == 24){
			inf = "";
		}
		if(id_num == 25){
			inf = "";
		}
		if(id_num == 26){
			inf = "";
		}
		if(id_num == 27){
			inf = "";
		}
		if(id_num == 28){
			inf = "";
		}
		if(id_num == 29){
			inf = "";
		}
		if(id_num == 30){
			inf = "";
		}
		if(id_num == 31){
			inf = "";
		}
		if(id_num == 32){
			inf = "";
		}
		if(id_num == 33){
			inf = "";
		}
		if(id_num == 34){
			inf = "";
		}
		if(id_num == 35){
			inf = "";
		}
		if(id_num == 36){
			inf = "";
		}
		if(id_num == 37){
			inf = "";
		}
		if(id_num == 38){
			inf = "";
		}
		if(id_num == 39){
			inf = "";
		}
		if(id_num == 40){
			inf = "";
		}
		
		return inf;
	}
}
