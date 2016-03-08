package com.dtt.pokermen.main;

import com.dtt.pokermen.R;
import com.dtt.pokermen.R.string;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Zachary on 2/8/2015.
 */
public class IntroSequence {

    public MainActivity a;
    public String playerName;
    public String rivalName;
    public String pokName;
    public int counter;
    public boolean finished = false;
    public Button txtBtn;
    public ImageView img;

    // constructor
    public IntroSequence(MainActivity mainActivity) {
        counter = 1;
        a = mainActivity;
        pokName = "Pikrchu";
        playerName = "NO NAME BUTT FACE";
        rivalName = "NULL NULL NULL";
    }

    // opens the new game layout
    public void setLayout(){
        a.setContentView(R.layout.new_game);
        txtBtn = (Button) a.findViewById(R.id.txt_btn);
        img = (ImageView) a.findViewById(R.id.img_prof);
        event();
    }

    public void startSeq() {
        // set layout
        setLayout();
    }

    public void iterate(){
        counter = counter + 1;
    }

    public void goBack(){
        counter = counter - 1;
    }

    public int getIt(){
        return counter;
    }

    public boolean getFin(){
        return finished;
    }

    public String retName(){
        return playerName;
    }
    public String retRival(){
        return rivalName;
    }
    public String retPokName(){
        return pokName;
    }

    public void event(){
        Log.i("DTT", "Intro sequence counter: " + counter);
        switch (counter){
            case 1:
                txtBtn.setText("[tap the text area to proceed the text]");
                break;
            case 2:
                txtBtn.setText("...");
                break;
            case 3:
                txtBtn.setText("who r u get out of here u wank");
                shakeImg();
                break;
            case 4:
                ImageView img_prof = (ImageView) a.findViewById(R.id.img_prof);
                img_prof.setImageResource(R.drawable.prof_front);
                txtBtn.setText("oh! sorry i dint realize it was u.");
                break;
            case 5:
                txtBtn.setText("i am pokermen professor beefmuncher, but u can call me browan");
                break;
            case 6:
                txtBtn.setText("do u hav a name or no");
                break;
            case 7:
                txtBtn.setText("what is ur name");
                getName();
                break;
            case 8:
                new AlertDialog.Builder(a)
                    .setTitle("Warning:")
                    .setMessage("Is the name: " + playerName + " correct? You can't change this later.")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("yes my name " + playerName, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            iterate();
                        }})
                    .setNegativeButton(string.no_change,new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            goBack();
                            event();
                        }})
                    .show();
                txtBtn.setText("is that right??");
                goBack();
                break;
            case 9:
                txtBtn.setText("ok so ur name is " + playerName +"...");
                break;
            case 10:
                txtBtn.setText("no offense but that name sucks");
                break;
            case 11:
                txtBtn.setText("anyway. welcome to the world of pokermen");
                break;
            case 12:
                txtBtn.setText("i understand u want to be a pokermen mastr");
                break;
            case 13:
                txtBtn.setText("well so does everyone else u dummy");
                break;
            case 14:
                txtBtn.setText("i have a son who hates u so much. what is my sons name");
                shakeImg();
                break;
            case 15:
                txtBtn.setText("i ferget what it is");
                getRivalName();
                break;
            case 16:
                new AlertDialog.Builder(a)
                    .setTitle("Warning:")
                    .setMessage("Is the name: " + rivalName + " correct? You can't change this later.")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("yes thats him i hate " + rivalName, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            iterate();
                        }})
                    .setNegativeButton("wait no um it is other name",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            goBack();
                            event();
                        }})
                    .show();
                txtBtn.setText("is that right??");
                goBack();
                break;
            case 17:
                txtBtn.setText("ok so his name is " + rivalName +"...");
                break;
            case 18:
                txtBtn.setText("now that name is frickin sick man im genius when i named him");
                break;
            case 19:
                txtBtn.setText("well one thing i no for sure is that u r poor and have no pokermen");
                break;
            case 20:
                txtBtn.setText("i have this one used pokerman u can use and u can have my change from lunch");
                break;
            case 21:
                txtBtn.setText(playerName + " recieved Pikrchu and $92!");
                img.setImageResource(R.drawable.pikrchu_front);
                break;
            case 22:
                txtBtn.setText("do u want to rename Pikrchu?");
                getPokName();
                break;
            case 23:
                new AlertDialog.Builder(a)
                    .setTitle("Warning:")
                    .setMessage("Is the name: " + pokName + " correct? You can't change this later.")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("yes this is good name", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            iterate();
                        }})
                    .setNegativeButton("i am change mind",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            goBack();
                        }})
                    .show();
                goBack();
                txtBtn.setText("is that right??");
                break;
            case 24:
                img.setImageResource(R.drawable.prof_front);
                txtBtn.setText("i think u r ready. get out of my lab please");
                break;
            default:
                finished=true;
                break;
        }
    }

    // Dialog that gets users name
    public void getName(){
        AlertDialog.Builder alert = new AlertDialog.Builder(a);
        alert.setTitle("Name entry");
        alert.setMessage("Enter your name:");
        // Set an EditText view to get user input
        final EditText input = new EditText(a);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String user_entry = input.getText().toString();
                playerName = user_entry;
            }
        });
        alert.show();
    }

    // Dialog that gets rivals name
    public void getRivalName(){
        AlertDialog.Builder alert = new AlertDialog.Builder(a);

        alert.setTitle("Name entry");
        alert.setMessage("Enter his name:");

        // Set an EditText view to get user input
        final EditText input = new EditText(a);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String user_entry = input.getText().toString();
                rivalName = user_entry;
            }
        });

        alert.show();
    }

    // Dialog that gets pokermens name
    public void getPokName(){
        new AlertDialog.Builder(a)
            .setTitle("Warning:")
            .setMessage("Rename " + pokName + "?")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int whichButton) {
                    getPokName2();
                }})
            .setNegativeButton(android.R.string.no, null).show();
    }

    // Dialog that gets pokermens name (2)
    public void getPokName2(){
        AlertDialog.Builder alert2 = new AlertDialog.Builder(a);
        alert2.setTitle("Name entry");
        alert2.setMessage("Enter pokermen name:");

        // Set an EditText view to get user input
        final EditText input = new EditText(a);
        alert2.setView(input);

        alert2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String user_entry = input.getText().toString();
                pokName = user_entry;
            }});
        alert2.show();
    }

    public void shakeImg(){
        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 20);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(100);  // animation duration
        animation.setRepeatCount(10);  // animation repeat count
        animation.setRepeatMode(1);   // repeat animation (left to right, right to left )
        animation.setFillAfter(true);
        img.startAnimation(animation);  // start animation
    }

}
