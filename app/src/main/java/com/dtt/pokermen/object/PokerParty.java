package com.dtt.pokermen.object;

import android.util.Log;

import java.util.ArrayList;
import com.dtt.pokermen.data.trainerDat;

/**
 * Created by Zack on 2/28/2016.
 */
public class PokerParty {

    private ArrayList<PokObj> pokrParty = new ArrayList<PokObj>();

    private int trainerId = 0;

    public PokerParty(ArrayList<PokObj> poks){
        pokrParty = poks;
        sortPokermen();
    }

    public PokerParty(ArrayList<PokObj> poks, int TrainerId){
        pokrParty = poks;
        trainerId = TrainerId;
        sortPokermen();
    }

    public Boolean AreAllPokDead(){
        for (PokObj p : pokrParty)
        {
            if(!p.isDead())
                return false;
        }
        return true;
    }

    public PokObj GetNextAlivePokermen(){
        for (PokObj p : pokrParty)
        {
            if(!p.isDead())
                return p;
        }
        return null;
    }

    public int GetNumberOfPokInParty(){
        return pokrParty.size();
    }

    public int GetNumberOfAlivePok(){
        int counter = 0;
        for (PokObj p : pokrParty)
        {
            if(!p.isDead())
                counter++;
        }
        return counter;
    }

    public Trainer GetPartyTrainer(){
        return trainerDat.GetTrainerWithID(trainerId);
    }


    public void HealAll(){
        for (PokObj p : pokrParty){
            p.setHp(p.getHpMax());
        }
    }

    public void DeleteFirstPokermen(){
        pokrParty.remove(0);
        sortPokermen();
    }

    public void SwapSlotUp(int slotToMoveUp){
        PokObj temp;
        switch (slotToMoveUp){
            case 2:
                temp = pokrParty.get(0);
                pokrParty.set(0, pokrParty.get(1));
                pokrParty.set(1, temp);
            case 3:
                temp = pokrParty.get(1);
                pokrParty.set(1, pokrParty.get(2));
                pokrParty.set(2, temp);
            case 4:
                temp = pokrParty.get(2);
                pokrParty.set(2, pokrParty.get(3));
                pokrParty.set(3, temp);
            case 5:
                temp = pokrParty.get(3);
                pokrParty.set(3, pokrParty.get(4));
                pokrParty.set(4, temp);
            case 6:
                temp = pokrParty.get(4);
                pokrParty.set(4, pokrParty.get(5));
                pokrParty.set(5, temp);
        }
        sortPokermen();
    }

    // Non-Zero index; actual slot numbers
    public PokObj GetPokermenInSlot(int slot){
        if(pokrParty.size()>=slot)
            return pokrParty.get(slot-1);
        else
            return new PokObj(0);
    }

    // This is a dangerous method that pushes the new pokermen to the 0 index. Pokermen 7+ will be forgotten
    public void AddPokermenToParty(PokObj p){
        pokrParty.add(0, p);
        int k = pokrParty.size();
        if ( k > 6 )
            pokrParty.subList(6, k).clear();
        sortPokermen();
    }

    // alive pokermen
    // dead pokermen
    // empty slots
    private void sortPokermen(){

        ArrayList<PokObj> alive = new ArrayList<PokObj>();
        ArrayList<PokObj> dead = new ArrayList<PokObj>();

        for (PokObj p : pokrParty){
            // alive or dead
            if(p.getHp() != 0)
                alive.add(alive.size(),p);
            else
                dead.add(dead.size(), p);
        }

        alive.addAll(dead);

        // pad
        for(int x = alive.size(); x < 6; x++){
            pokrParty.add(alive.size(), new PokObj(0));
        }

        pokrParty = alive;
    }

    public void EmptyPokerParty(){
        pokrParty = null;
        pokrParty = new ArrayList<PokObj>();
    }

}
