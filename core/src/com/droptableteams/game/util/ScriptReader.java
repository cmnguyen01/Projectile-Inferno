package com.droptableteams.game.util;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.Gdx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import static java.lang.System.err;

public class ScriptReader {
    public  static ArrayList<Wave> readWaves(String filename){
        Json json = new Json();
        String filePath = "scripts/levels/" + filename;

        try
        {
            ArrayList<Wave> level = json.fromJson(ArrayList.class, Wave.class, Gdx.files.internal(filePath));
            return  level;
        }
        catch (Exception e){
            err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }

    }
    public static ArrayList<ArrayList<Spawnable>> readLevel(String filename) {
        ArrayList<ArrayList<Spawnable>> result = new ArrayList<ArrayList<Spawnable>>();
        for (Wave x: readWaves(filename)) {
            String filePath = "scripts/levels/" + x.waveLocation;
            try
            {
                Json json = new Json();
                result.add( json.fromJson(ArrayList.class, Spawnable.class, Gdx.files.internal(filePath)));
            }
            catch (Exception e){
                err.format("Exception occurred trying to read '%s'.", filePath);
                e.printStackTrace();
                return null;
            }
        }
/*        try
        {
            Array spawnArray = null;
            ArrayList<Spawnable> spawnList = new ArrayList<Spawnable>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Json json = new Json();
            spawnArray = json.fromJson(Array.class, reader);
            reader.close();
            for(Object item : spawnArray) {
                if(item.getClass() == Spawnable.class) {
                    spawnList.add((Spawnable)item);
                }
            }
            return spawnList;
        }
        catch (Exception e)
        {
            err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }*/
        return result;
    }
}
