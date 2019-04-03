package com.droptableteams.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.droptableteams.game.util.data.EnemyData;

import java.util.ArrayList;

import static java.lang.System.err;

public class Wave{
    public String waveLocation;
    public int timeOffset;
    public int xOffset;
    public int yOffset;
    public ArrayList<Spawnable> enemies;
    //Possibly add modifiers to this class in the future, to increase
    //customization options when creating level scripts.
    public Wave(String file, int time, int x, int y){
        waveLocation = file;
        timeOffset = time;
        xOffset = x;
        yOffset = y;
        GetEnemies();
    }
    public Wave(){
        waveLocation = "";
        timeOffset = 0;
        xOffset = 0;
        yOffset = 0;
    }
    public void GetEnemies(){
        try
        {
            Json json = new Json();
            enemies = json.fromJson(ArrayList.class, Spawnable.class, Gdx.files.internal( "scripts/levels/" + waveLocation));

        }
        catch (Exception e){
            err.format("Exception occurred trying to read '%s'.", waveLocation);
            e.printStackTrace();
        }
    }
}
