package com.dtt.pokermen.object;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by Zack on 2/28/2016.
 */
public class Trainer {

    private String name;
    private ArrayList<String> introText;
    private ArrayList<String> postBattleText;

    public Trainer(String Name, ArrayList<String> IntroText,
                   ArrayList<String> PostBattleText){
        name = Name;
        introText = IntroText;
        postBattleText = PostBattleText;
    }

    public String GetTrainerName(){return name; }
    public ArrayList<String> GetIntroText(){ return introText; }
    public ArrayList<String> GetPostBattleText(){ return postBattleText; }

}
