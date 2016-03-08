package com.dtt.pokermen.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dtt.pokermen.object.PokObj;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Van on 10/10/2014.
 */
public class PokObjectSQLiteHandler extends SQLiteOpenHelper {
    private static final String TABLE_POKOBJECTS = "pokobjects";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ATK = "atk";
    private static final String COLUMN_DEF = "def";
    private static final String COLUMN_HP = "hp";
    private static final String COLUMN_ES = "es";

    public static final String[] COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_ATK, COLUMN_DEF, COLUMN_HP, COLUMN_ES};

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PokObjectDB";

    public PokObjectSQLiteHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_POK_TABLE = "CREATE TABLE " + TABLE_POKOBJECTS + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "atk INTEGER, " +
                "def INTEGER, " +
                "hp INTEGER, " +
                "es INTEGER)";

        Log.e("POOP", "POOP");

        db.execSQL(CREATE_POK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS pokobjects");
        this.onCreate(db);
    }

    public void insertPok(PokObj po){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, po.getId());
        cv.put(COLUMN_NAME, po.getName());
        cv.put(COLUMN_ATK, po.getAtk());
        cv.put(COLUMN_DEF, po.getDef());
        cv.put(COLUMN_HP, po.getHp());
        cv.put(COLUMN_ES, po.getEs());

        db.insert(TABLE_POKOBJECTS, null, cv);
        db.close();
    }

    public PokObj getPokObject(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_POKOBJECTS, COLUMNS, String.valueOf(id), null, null, null, null);
        if(c != null)
            c.moveToFirst();
        PokObj po = new PokObj();
        po.setId(Integer.parseInt(c.getString(0)));
        po.setName(c.getString(1));
        po.setAtk(Integer.parseInt(c.getString(2)));
        po.setDef(Integer.parseInt(c.getString(3)));
        po.setHp(Integer.parseInt(c.getString(4)));
        po.setEs(Integer.parseInt(c.getString(5)));

        return po;
    }

    public int updatePokObject(PokObj po){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, po.getId());
        cv.put(COLUMN_NAME, po.getName());
        cv.put(COLUMN_ATK, po.getAtk());
        cv.put(COLUMN_DEF, po.getDef());
        cv.put(COLUMN_HP, po.getHp());
        cv.put(COLUMN_ES, po.getEs());

        int i = db.update(TABLE_POKOBJECTS, cv, COLUMN_ID+"= ?", new String[] {String.valueOf(po.getId())});

        db.close();

        return i;
    }

    public List<PokObj> getAllPokObjects(){
        List<PokObj> pokObjects = new LinkedList<PokObj>();

        String query = "SELECT * FROM " + TABLE_POKOBJECTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        PokObj po = null;
        if(c.moveToFirst()){
            while(c.isAfterLast() == false){
                po = new PokObj();
                po.setId(Integer.parseInt(c.getString(0)));
                po.setName(c.getString(1));
                po.setAtk(Integer.parseInt(c.getString(2)));
                po.setDef(Integer.parseInt(c.getString(3)));
                po.setHp(Integer.parseInt(c.getString(4)));
                po.setEs(Integer.parseInt(c.getString(5)));
                pokObjects.add(po);
                c.moveToNext();
            }
        }


        return pokObjects;
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_POKOBJECTS, null, null);
    }

}
