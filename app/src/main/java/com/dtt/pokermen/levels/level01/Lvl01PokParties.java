package com.dtt.pokermen.levels.level01;

import android.util.Log;

import com.dtt.pokermen.object.PokObj;
import com.dtt.pokermen.object.PokerParty;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zack on 2/28/2016.
 */
public final class Lvl01PokParties {

    private Lvl01PokParties(){};


    public static PokerParty GetWildPok(){
        PokObj wildPok;
        Random rand = new Random();
        int pokint = rand.nextInt(6);
        rand = new Random();
        int lvl = rand.nextInt(2) + 1;
        switch (pokint) {
            case 0:
                wildPok = new PokObj(2, "Peevee", lvl, 4 + lvl,  4 + lvl, 5 + (lvl * 5), 0);
                break;
            case 1:
                wildPok = new PokObj(3, "Weenle", lvl, 2 + lvl,  2 + lvl, 5 + (lvl * 5), 0);
                break;
            case 2:
                wildPok = new PokObj(4, "Pudgie", lvl, 4 + lvl,  4 + lvl, 10 + (lvl * 5), 0);
                break;
            case 3:
                wildPok = new PokObj(5, "Tarduck", lvl, 2 + lvl,  2 + lvl, 5 + (lvl * 5), 0);
                break;
            case 4:
                wildPok = new PokObj(6, "Porkslow", lvl, 4 + lvl,  4 + lvl, 10 + (lvl * 5), 0);
                break;
            case 5:
                wildPok = new PokObj(7, "Hitmonler", lvl, 14 + lvl,  14 + lvl, 15 + (lvl * 5), 0);
                break;
            default:
                wildPok = new PokObj(2, "Peevee", lvl, 4 + lvl,  4 + lvl, 5 + (lvl * 5), 0);
        }

        ArrayList<PokObj> pl = new ArrayList<PokObj>();
        pl.add(wildPok);
        PokerParty pp = new PokerParty(pl);

        return pp;
    }


    public static PokerParty GetBettyburg() {
        int lvl = 1;
        PokObj pok = new PokObj(2, "Peevee", lvl, 2 + lvl,  4 + lvl, 5 + (lvl * 5), 0);
        ArrayList<PokObj> pl = new ArrayList<PokObj>();
        pl.add(pok);
        PokerParty pp = new PokerParty(pl, 1);
        return pp;

    }






}
