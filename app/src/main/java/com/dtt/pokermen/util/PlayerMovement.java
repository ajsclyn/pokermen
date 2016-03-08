package com.dtt.pokermen.util;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dtt.pokermen.R;

public final class PlayerMovement {
	
	private static Activity currentActivity;
	
	private static ImageView img_player;
	
	private static RelativeLayout.LayoutParams lp;

	private static Button btn_up;
	private static Button btn_down;
	private static Button btn_left;
	private static Button btn_right;

	private static boolean walk = false; // t - right f - left

	private static int last_x;
	private static int last_y;
	private static int last_dir; // 0 up , 1 right, 2 down , 3 left
	
	
	private PlayerMovement(){}


	public static void InitializeMovementControls(Activity a){

		currentActivity = a;

		img_player = (ImageView) a.findViewById(R.id.img_player);
		
		btn_up = (Button) a.findViewById(R.id.btn_up);
		btn_down = (Button) a.findViewById(R.id.btn_down);
		btn_left = (Button) a.findViewById(R.id.btn_left);
		btn_right = (Button) a.findViewById(R.id.btn_right);
	}
	
	// Shows directional buttons
	public static void showButs(){
		btn_up.setVisibility(View.VISIBLE);
		btn_down.setVisibility(View.VISIBLE);
		btn_left.setVisibility(View.VISIBLE);
		btn_right.setVisibility(View.VISIBLE);
	}
	
	// Hides directional buttons
	public static void hideButs(){
		btn_up.setVisibility(View.GONE);
		btn_down.setVisibility(View.GONE);
		btn_left.setVisibility(View.GONE);
		btn_right.setVisibility(View.GONE);
	}
	
	public static void setToTop(){
        lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();
        
        Display display = currentActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        lp.topMargin = (50); 
        lp.leftMargin = (width/2)-30;
        img_player.setLayoutParams(lp);
        
		img_player.setRotation(180);

		Log.i("DTT","Player placed at top.");
	}
	
	public static void setToOrigin(){
        lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();
        
        Display display = currentActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        
        lp.topMargin = (height - 250); 
        lp.leftMargin = (width/2)-30;
        img_player.setLayoutParams(lp);

		Log.i("DTT","Player placed at origin.");
	}
	
	public static void getLast(){
		last_x = img_player.getLeft();
		last_y = img_player.getTop();
		
	}
	
	public static void setLast(){
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();

        lp.topMargin = last_y; 
        lp.leftMargin = last_x;

        img_player.setLayoutParams(lp);
        
        if(last_dir == 0)
        	img_player.setRotation(0);
        if(last_dir == 1)
        	img_player.setRotation(90);
        if(last_dir == 2)
        	img_player.setRotation(180);
        if(last_dir == 3)
        	img_player.setRotation(270);
	}
	
	
	// ====================== D I R E C T I O N S ========================================================= //
	
	public static void right(){
    	last_dir = 1;
		// Rotate player up
		img_player.setRotation(90);
		
    	int left = img_player.getLeft();
    	
        lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();
        
        Display display = currentActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        
        //int len_from_right = width - left;
        
        //Log.i("DTT","left: " + left);
        //Log.i("DTT","width: " + (width-120));
        
        if(left>(width-120)){
        	lp.leftMargin = width-100; 
        }
        else{
        	lp.leftMargin = 30 + left;
        }

		TranslateAnimation animation = new TranslateAnimation(0, 10, 0, 0);  //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
	    animation.setDuration(100);  // animation duration 
	    animation.setRepeatCount(0);  // animation repeat count
	    animation.setRepeatMode(0);   // repeat animation (left to right, right to left )
	    animation.setFillAfter(false);
	    animation.setAnimationListener(new Animation.AnimationListener(){
	        @Override
	        public void onAnimationStart(Animation arg0) {
	    	    if(walk == true){
	    	    	img_player.setImageResource(R.drawable.player1);
	    	    	walk = false;
	    	    }
	    	    else{
	    	    	img_player.setImageResource(R.drawable.player2);
	    	    	walk = true;
	    	    }
	        }           
	        @Override
	        public void onAnimationRepeat(Animation arg0) {
	        }           
	        @Override
	        public void onAnimationEnd(Animation arg0) {
	        	img_player.setImageResource(R.drawable.player0);
	        	img_player.setLayoutParams(lp);
	        }
	    });
        

	    
	    img_player.startAnimation(animation);  // start animation 
	    
		//Log.i("DTT","Right pressed. left: "+left+" right: "+len_from_right+" width: "+width);
	}
	
	
	public static void down(){
    	last_dir = 2;
		img_player.setRotation(180);
		
		// Moves player image down 
    	int top = img_player.getTop();
    	
        lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();
        
        Display display = currentActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        
        //Log.i("DTT","Top: " + top);
        //Log.i("DTT","Height: " + (height-175));
        if(top>(height-175)){
        	lp.topMargin = (height-200); 
        }
        else{
        	lp.topMargin = 35 + top;
        }
        
		TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 10);  //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
	    animation.setDuration(100);  // animation duration 
	    animation.setRepeatCount(0);  // animation repeat count
	    animation.setRepeatMode(0);   // repeat animation (left to right, right to left )
	    animation.setFillAfter(false);
	    animation.setAnimationListener(new Animation.AnimationListener(){
	        @Override
	        public void onAnimationStart(Animation arg0) {
	    	    if(walk == true){
	    	    	img_player.setImageResource(R.drawable.player1);
	    	    	walk = false;
	    	    }
	    	    else{
	    	    	img_player.setImageResource(R.drawable.player2);
	    	    	walk = true;
	    	    }
	        }           
	        @Override
	        public void onAnimationRepeat(Animation arg0) {
	        }           
	        @Override
	        public void onAnimationEnd(Animation arg0) {
	        	img_player.setImageResource(R.drawable.player0);
	        	img_player.setLayoutParams(lp);
	        }
	    });
	    img_player.startAnimation(animation);  // start animation 
	    
		Log.i("DTT","Down pressed.");
	}
	
	public static void left(){
    	last_dir = 3;
		// Rotate player up
		img_player.setRotation(270);
    	
    	int left = img_player.getLeft();
    	
        lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();
        
        Display display = currentActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        //int width = size.x;
        
        if(left<20){
        	lp.leftMargin = 20; 
        }
        else{
        	lp.leftMargin = left-30;
        }
        
		TranslateAnimation animation = new TranslateAnimation(0, -10, 0, 0);  //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
	    animation.setDuration(100);  // animation duration 
	    animation.setRepeatCount(0);  // animation repeat count
	    animation.setRepeatMode(0);   // repeat animation (left to right, right to left )
	    animation.setFillAfter(false);
	    animation.setAnimationListener(new Animation.AnimationListener(){
	        @Override
	        public void onAnimationStart(Animation arg0) {
	    	    if(walk == true){
	    	    	img_player.setImageResource(R.drawable.player1);
	    	    	walk = false;
	    	    }
	    	    else{
	    	    	img_player.setImageResource(R.drawable.player2);
	    	    	walk = true;
	    	    }
	        }           
	        @Override
	        public void onAnimationRepeat(Animation arg0) {
	        }           
	        @Override
	        public void onAnimationEnd(Animation arg0) {
	        	img_player.setImageResource(R.drawable.player0);
	        	img_player.setLayoutParams(lp);
	        }
	    });
	    img_player.startAnimation(animation);  // start animation 

		//Log.i("DTT","Left pressed. left: "+left+" width: "+width);
	}
	
	public static void up(){
    	last_dir = 0;
		// Rotate player up
		img_player.setRotation(0);
		
    	int top = img_player.getTop();
    	
        lp = (RelativeLayout.LayoutParams) img_player.getLayoutParams();
        
        if(top>30){
        	lp.topMargin = top-30; 
        }
        else{
        	lp.topMargin = 60 - top;
        }
        
		TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -10);  //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
	    animation.setDuration(100);  // animation duration 
	    animation.setRepeatCount(0);  // animation repeat count
	    animation.setRepeatMode(0);   // repeat animation (left to right, right to left )
	    animation.setFillAfter(false);
	    animation.setAnimationListener(new Animation.AnimationListener(){
	        @Override
	        public void onAnimationStart(Animation arg0) {
	    	    if(walk == true){
	    	    	img_player.setImageResource(R.drawable.player1);
	    	    	walk = false;
	    	    }
	    	    else{
	    	    	img_player.setImageResource(R.drawable.player2);
	    	    	walk = true;
	    	    }
	        }           
	        @Override
	        public void onAnimationRepeat(Animation arg0) {
	        }           
	        @Override
	        public void onAnimationEnd(Animation arg0) {
	        	img_player.setImageResource(R.drawable.player0);
	        	img_player.setLayoutParams(lp);
	        }
	    });
	    img_player.startAnimation(animation);  // start animation 
	   
	    
		Log.i("DTT","Up pressed. top: "+top);
		
	}
	
	// ========== E N D ========= D I R E C T I O N S ========================================================= //
}
