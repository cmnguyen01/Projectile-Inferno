package com.droptableteams.game.systems.game;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.game.GameTimeComponent;
import com.droptableteams.game.components.game.SpawnListComponent;
import com.droptableteams.game.factories.data.EnemyData;
import com.droptableteams.game.util.Spawnable;

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
        SpawnListComponent slc = (SpawnListComponent)_cm.getComponent(_id, "SpawnListComponent");
        GameTimeComponent gtc = (GameTimeComponent)_cm.getComponent(_id, "GameTimeComponent");
        for (Spawnable spawnable : slc.getSpawnList()) {
            if(gtc.getTimeInMillis() >= spawnable.timeInMillis) {
                if("EnemyEntity" == spawnable.entityType) {
                    spawnEnemy(spawnable);
                }
            }
        }
    }

    private void spawnEnemy(Spawnable spawnable) {
        EnemyData ed = (EnemyData)spawnable.args;
    }
}
