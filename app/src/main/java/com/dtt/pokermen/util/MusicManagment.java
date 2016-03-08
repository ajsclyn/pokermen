package com.dtt.pokermen.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import com.dtt.pokermen.R;

/**
 * Created by Zack on 2/28/2016.
 */
public final class MusicManagment {

    private static MediaPlayer musicPlayer = null;

    public enum Songs{
        PokermenTheme,
        AttackTheme,
        PubleTown,
        HipHopCity,
        CrampForest,
        DongCave,
        Nutterville,
        SnatchLake,
        BubeDunes,
        PokermenMastersFortress
    }

    private MusicManagment() {};

    public static void PlayMusic(Context c, Songs song){

        Stop();

        switch (song){
            case PokermenTheme:
                musicPlayer = MediaPlayer.create(c, R.raw.pokermen_theme);
                break;
            case AttackTheme:
                musicPlayer = MediaPlayer.create(c, R.raw.attack_theme);
                break;
            case PubleTown:
                musicPlayer = MediaPlayer.create(c, R.raw.puble_town);
                break;
            case HipHopCity:
                musicPlayer = MediaPlayer.create(c, R.raw.hip_hop_city);
                break;
            case CrampForest:
                musicPlayer = MediaPlayer.create(c, R.raw.cramp_forest);
                break;
            case DongCave:
                musicPlayer = MediaPlayer.create(c, R.raw.dong_cave);
                break;
            case Nutterville:
                musicPlayer = MediaPlayer.create(c, R.raw.nutterville);
                break;
            default:
                Toast.makeText(c, "Unable to load requested music.", Toast.LENGTH_SHORT).show();
                return;
        }
        musicPlayer.setLooping(true);
        musicPlayer.setVolume(100, 100);
        musicPlayer.start();
        Log.i("DTT", "Music started. Playing song: " + song.toString());
    }

    public static void Stop(){
        if(musicPlayer != null) {
            musicPlayer.stop();
            musicPlayer.release();
        }
        musicPlayer = null;
        Log.i("DTT", "Music stopped.");
    }








}
