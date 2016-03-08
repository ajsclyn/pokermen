package com.dtt.pokermen.util;

import com.dtt.pokermen.R;

/**
 * Created by Zack on 2/28/2016.
 */
public final class ResourceManager {

    private ResourceManager(){}



    public static int GetPokermenImageFrontById(int id){

        switch (id){
            case 0:
                return R.drawable.empty_img;
            case 1:
                return R.drawable.pikrchu_front;
            case 2:
                return R.drawable.peevee_front;
            case 3:
                return R.drawable.weenle_front;
            case 4:
                return R.drawable.pudgie_front;
            case 5:
                return R.drawable.tarduck_front;
            case 6:
                return R.drawable.pokrslow_front;
            case 7:
                return R.drawable.hitmonler_front;
            case 8:
                return R.drawable.tentacool_front;
            case 9:
                return R.drawable.empty_img;
            case 10:
                return R.drawable.jaquinx_front;
            default:
                return R.drawable.empty_img;

        }

    }


    public static int GetPokermenImageBackById(int id){

        switch (id){
            case 0:
                return R.drawable.empty_img;
            case 1:
                return R.drawable.pikrchu_back;
            case 2:
                return R.drawable.peevee_back;
            case 3:
                return R.drawable.weenle_back;
            case 4:
                return R.drawable.pudgie_back;
            case 5:
                return R.drawable.tarduck_back;
            case 6:
                return R.drawable.pokrslow_back;
            case 7:
                return R.drawable.hitmonler_back;
            case 8:
                return R.drawable.tentacool_back;
            case 9:
                return R.drawable.empty_img;
            case 10:
                return R.drawable.jaquinx_back;
            default:
                return R.drawable.empty_img;

        }

    }


}
