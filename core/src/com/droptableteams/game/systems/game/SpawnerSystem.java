package com.droptableteams.game.systems.game;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.builders.BossEntityBuilder;
import com.droptableteams.game.components.game.AssetManagerComponent;
import com.droptableteams.game.components.game.GameTimeComponent;
import com.droptableteams.game.components.game.SpawnListComponent;
import com.droptableteams.game.builders.EnemyEntityBuilder;
import com.droptableteams.game.builders.BossEntityBuilder;
import com.droptableteams.game.util.Wave;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.util.data.BossData;
import com.droptableteams.game.util.data.EnemyData;
import com.droptableteams.game.util.data.BossData;
import com.droptableteams.game.util.Spawnable;

import java.util.ArrayList;

public class SpawnerSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public SpawnerSystem(int id) {
        _id = id;
        _type = "SpawnerSystem";
        _cm = ComponentManager.getInstance();
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void update() {
        SpawnListComponent slc = (SpawnListComponent) _cm.getComponent(_id, "SpawnListComponent");
        GameTimeComponent gtc = (GameTimeComponent) _cm.getComponent(_id, "GameTimeComponent");
        AssetManagerComponent amc = (AssetManagerComponent) _cm.getComponent(_id, "AssetManagerComponent");
        ECSEngine engine = ECSEngine.getInstance(SystemUpdateOrder.get());
<<<<<<< HEAD
        EnemyEntityBuilder builder = EnemyEntityBuilder.getInstance(amc.getAssetManager());
        BossEntityBuilder builder2 = BossEntityBuilder.getInstance(amc.getAssetManager());
=======
        EnemyEntityBuilder enemyBuilder = EnemyEntityBuilder.getInstance(amc.getAssetManager());
        BossEntityBuilder bossBuilder = BossEntityBuilder.getInstance(amc.getAssetManager());
>>>>>>> a4d8822b835d5bdf348f7f7de84c09800408bcda
        ArrayList<Spawnable> flaggedForRemoval = new ArrayList<Spawnable>();
        ArrayList<Spawnable> currentWave;
        currentWave = slc.getSpawnList();
        for (Spawnable spawnable : currentWave) {
            if (gtc.getTimeInMillis() >= spawnable.spawnTime) {
                if (spawnable.entityType.equals("BossEntity")) {
                    flaggedForRemoval.add(spawnable);
                    builder2.setBuildData((BossData) spawnable.data);
                    engine.addEntity(builder2);
                }
                else
                {
                    flaggedForRemoval.add(spawnable);
                    enemyBuilder.setBuildData((EnemyData) spawnable.data);
                    engine.addEntity(enemyBuilder);
                }
                else if(spawnable.entityType.equals("BossEntity")) {
                    flaggedForRemoval.add(spawnable);
                    bossBuilder.setBuildData((BossData) spawnable.data);
                }
            }
        }
        for (Spawnable flagged : flaggedForRemoval) {
            slc.getSpawnList().remove(flagged);
        }
    }
}
