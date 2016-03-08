package com.dtt.pokermen.data;

import com.dtt.pokermen.object.Trainer;

import java.util.ArrayList;

/**
 * Created by Zack on 2/28/2016.
 */
public final class trainerDat {

    private trainerDat(){};

    private static Trainer bettyBerg = new Trainer("Pokermen Trainer Berryberg",
            new ArrayList<String>() {{
            add("omg!!!!! u r cute like child or baby mule let us battle!!!");
            add("u r cute like child or baby mule");
            add("let us battle!!!");
            }},
            new ArrayList<String>() {{
                add("wow.... u beat me");
                add("that is so rude");
            }});





    public static Trainer GetTrainerWithID(int id){

        switch (id){
            case 1:
                return bettyBerg;
            default:
                return null;
        }
    }


}
