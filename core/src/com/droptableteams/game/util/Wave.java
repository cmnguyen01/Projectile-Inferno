package com.droptableteams.game.util;

import java.util.ArrayList;

public class Wave{
    public String waveLocation;
    //Possibly add modifiers to this class in the future, to increase
    //customization options when creating level scripts.
    public Wave(String file){
        waveLocation = file;
    }
    public Wave(){
        waveLocation = "";
    }
}
