package com.dtt.pokermen.object;

public class PokObj {
	
	private int id;
	private String name;
	private int lvl;
	private int atk;
	private int def;
	private int hp;
	private int hp_max;
	private int es; // effect stat   0 -         1 -      2 -       3 -
	
	public PokObj(){
		id = 0;
		name = "";
		lvl = 0;
		atk = 0;
		def = 0;
		hp = 0;
		hp_max = 0;
		es = 0;
	}
	
	public PokObj(int set_id, String set_name, int set_lvl, int set_atk, int set_def, int set_hp, int set_es){
		id = set_id;
		name = set_name;
		lvl = set_lvl;
		atk = set_atk;
		def = set_def;
		hp = set_hp;
		hp_max = set_hp;
		es = set_es;
	}

	// null pokermen
	public PokObj(int set_id){
		id = set_id;
		name = "null pokermen";
	}

	
	// get member functions
	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLvl(){
		return lvl;
	}
	
	public int getAtk(){
		return atk;
	}
	
	public int getDef(){
		return def;
	}
	
	public int getHp(){
		return hp;
	}
	
	public int getHpMax(){
		return hp_max;
	}
	public int getEs(){
		return es;
	}

	public Boolean isDead(){ if(hp==0) return true; else return false;}
	
	// set member functions
	public void setId(int x){
		id = x;
	}
	
	public void setName(String x){
		name = x;
	}
	
	public void setLvl(int x){
		lvl = x;
	}
	
	public void setAtk(int x){
		atk = x;
	}
	
	public void setDef(int x){
		def = x;
	}
	
	public void setHp(int x){
		hp = x;
	}
	
	public void setHpMax(int x){
		hp_max = x;
	}
	public void setEs(int x){
		es = x;
	}
	
	public void heal(){
		es = 0;
		hp = hp_max;
	}
}

