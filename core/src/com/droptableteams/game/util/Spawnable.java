package com.droptableteams.game.util;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.droptableteams.game.util.data.EnemyData;

/**
 * TODO: fields of type 'Object' may be difficult to serialize:
 * If enemies are the only 'Spawnable' to be listed in level script
 * then we can replace 'Object data' with 'EnemyData ed'...
 */
public class Spawnable implements Json.Serializable {
    public long spawnTime;
    public String entityType;
    public Object data;

    public Spawnable() {
        spawnTime = 0;
        entityType = "UnknownType";
        data = null;
    }

    /**
     *  Constructor
     * @param spawnTime time in millis since beginning of level
     * @param entityType type of entity to spawn
     * @param data detailed information about the entity to spawn
     */
    public Spawnable(long spawnTime, String entityType, Object data) {
        this.spawnTime = spawnTime;
        this.entityType = entityType;
        this.data = data;
    }

    @Override
    public void write(Json json) {
        json.writeValue("spawnTime", spawnTime);
        json.writeValue("entityType", entityType);
        if("EnemyEntity" == entityType) {
            json.writeValue("data", data, EnemyData.class);
        }
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        spawnTime = jsonData.getLong("spawnTime", 0);
        entityType = jsonData.getString("entityType", "UnknownEntity");
        data = json.readValue("data", EnemyData.class, jsonData);
    }
}
