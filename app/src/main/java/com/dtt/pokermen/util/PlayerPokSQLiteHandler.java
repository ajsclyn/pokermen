package com.dtt.pokermen.util;

/**
 * Created by Van on 10/17/2014.
 */
/**
public class PlayerPokSQLiteHandler  extends SQLiteOpenHelper {
}



  private static final String TABLE_PLAYERS = "players";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PID = "pid";
    private static final String COLUMN_LVL = "lvl";
    private static final String COLUMN_ATK = "atk";
    private static final String COLUMN_DEF = "def";
    private static final String COLUMN_HP = "hp";
    private static final String COLUMN_HP_MAX = "hpmax";
    private static final String COLUMN_ES = "es";
    private static final String COLUMN_EXP = "exp";

    public static final String[] COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_PID, COLUMN_LVL,  COLUMN_ATK, COLUMN_DEF, COLUMN_HP, COLUMN_HP_MAX, COLUMN_ES, COLUMN_EXP};

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PlayerDB";

    public PlayerPokSQLiteHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_POK_TABLE = "CREATE TABLE " + TABLE_PLAYERS + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "pid INTEGER, " +
                "lvl INTEGER, " +
                "atk INTEGER, " +
                "def INTEGER, " +
                "hp INTEGER, " +
                "hpmax INTEGER, " +
                "es INTEGER, " +
                "exp INTEGER)";

        db.execSQL(CREATE_POK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS players");
        this.onCreate(db);
    }

    public void insertPlayerPok(PlayerPok po){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, po.getId());
        cv.put(COLUMN_NAME, po.getName());
        cv.put(COLUMN_PID, po.getLvl());
        cv.put(COLUMN_LVL, po.getLvl());
        cv.put(COLUMN_ATK, po.getAtk());
        cv.put(COLUMN_DEF, po.getDef());
        cv.put(COLUMN_HP, po.getHp());
        cv.put(COLUMN_HP_MAX, po.getHp_max());
        cv.put(COLUMN_ES, po.getEs());
        cv.put(COLUMN_EXP, po.getExp());

        db.insert(TABLE_PLAYERS, null, cv);
        db.close();
    }

    public PlayerPok getPlayerPok(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_PLAYERS, COLUMNS, String.valueOf(id), null, null, null, null);
        if(c != null)
            c.moveToFirst();
        PlayerPok po = new PlayerPok();
        po.setId(Integer.parseInt(c.getString(0)));
        po.setName(c.getString(1));
        po.setPid(Integer.parseInt(c.getString(2)));
        po.setLvl(Integer.parseInt(c.getString(3)));
        po.setAtk(Integer.parseInt(c.getString(4)));
        po.setDef(Integer.parseInt(c.getString(5)));
        po.setHp(Integer.parseInt(c.getString(6)));
        po.setHp_max(Integer.parseInt(c.getString(7)));
        po.setEs(Integer.parseInt(c.getString(8)));
        po.setExp(Integer.parseInt(c.getString(9)));

        return po;
    }

    public int updatePlayerPok(PlayerPok po){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, po.getId());
        cv.put(COLUMN_NAME, po.getName());
        cv.put(COLUMN_PID, po.getLvl());
        cv.put(COLUMN_LVL, po.getLvl());
        cv.put(COLUMN_ATK, po.getAtk());
        cv.put(COLUMN_DEF, po.getDef());
        cv.put(COLUMN_HP, po.getHp());
        cv.put(COLUMN_HP_MAX, po.getHp_max());
        cv.put(COLUMN_ES, po.getEs());
        cv.put(COLUMN_EXP, po.getExp());

        int i = db.update(TABLE_PLAYERS, cv, COLUMN_ID+"= ?", new String[] {String.valueOf(po.getId())});

        db.close();

        return i;
    }

    public List<PlayerPok> getAllPokObjects(){
        List<PlayerPok> PlayerPoks = new LinkedList<PlayerPok>();

        String query = "SELECT * FROM " + TABLE_PLAYERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        /**PlayerPok po = null;
        if(c.moveToFirst()){
            while(c.isAfterLast() == false){
                po = new PlayerPok();
                po.setId(Integer.parseInt(c.getString(0)));
                po.setName(c.getString(1));
                po.setPid(Integer.parseInt(c.getString(2)));
                po.setLvl(Integer.parseInt(c.getString(3)));
                po.setAtk(Integer.parseInt(c.getString(4)));
                po.setDef(Integer.parseInt(c.getString(5)));
                po.setHp(Integer.parseInt(c.getString(6)));
                po.setHp_max(Integer.parseInt(c.getString(7)));
                po.setEs(Integer.parseInt(c.getString(8)));
                po.setExp(Integer.parseInt(c.getString(9)));
                PlayerPoks.add(po);
                c.moveToNext();
            }
        }


        return PlayerPoks;
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLAYERS, null, null);
    }
**/

