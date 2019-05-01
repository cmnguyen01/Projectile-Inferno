package com.droptableteams.game.util;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.Gdx;
import com.droptableteams.game.util.data.EnemyData;
<<<<<<< HEAD
import com.droptableteams.game.util.data.BossData;
=======
import com.droptableteams.game.util.types.IEntitySubtype;
import com.droptableteams.game.util.types.SubtypeManager;
>>>>>>> a4d8822b835d5bdf348f7f7de84c09800408bcda

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import static java.lang.System.err;

public class ScriptReader {

    public static void readTypeData(String filename, Class<?> classType) {
        Json json = new Json();
        String path = "scripts/types/" + filename;

        try {
            IEntitySubtype subtype = (IEntitySubtype) json.fromJson(classType, Gdx.files.internal(path));
            SubtypeManager.getInstance().addSubtype(subtype);
        }
        catch(Exception e) {
            err.format("Exception occurred trying to read '%s'.", path);
            e.printStackTrace();
        }
    }

    public static ArrayList<Wave> readLevel(String filename) {
        Json json = new Json();
        String filePath = "scripts/levels/" + filename;

        try {
            ArrayList<Wave> level = json.fromJson(ArrayList.class, Wave.class, Gdx.files.internal(filePath));

            for (Wave x : level)
            {
                x.GetEnemies();
                for (Spawnable y : x.enemies)
                {
                    if(y.entityType.equals("BossEntity")) {
                        ((BossData) y.data).x += x.xOffset;
                        ((BossData) y.data).y += x.yOffset;
                        y.spawnTime += x.timeOffset;
                    }
                    else{
                        ((EnemyData)y.data).x += x.xOffset;
                        ((EnemyData)y.data).y += x.yOffset;
                        y.spawnTime += x.timeOffset;
                    }
                }
            }
            return  level;
        }
        catch (Exception e){
            err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
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
    }
}
