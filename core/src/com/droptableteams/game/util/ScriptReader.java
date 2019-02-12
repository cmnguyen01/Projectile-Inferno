package com.droptableteams.game.util;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import sun.java2d.pipe.SpanClipRenderer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ScriptReader {
    public static ArrayList<Spawnable> readLevel(String levelName) {
        String filePath = "scripts/levels/" + levelName + ".json";
        try
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
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }
}
