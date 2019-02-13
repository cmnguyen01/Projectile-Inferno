package com.droptableteams.game.util.data;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import com.droptableteams.game.util.Spawnable;

public class WaveData implements Json.Serializable {
    public long startTime;
    public Array<Spawnable> spawnables;

    public WaveData() {
        startTime = 0;
        spawnables = new Array<Spawnable>();
    }

    @Override
    public void write(Json json) {
        json.writeValue("startTime", startTime);
        json.writeValue("spawnables", spawnables);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        startTime = jsonData.getLong("startTime");
        JsonValue spawnablesJson = jsonData.get("spawnables");
        spawnables = new Array<Spawnable>();
        for(JsonValue entry = spawnablesJson.child; entry != null; entry = entry.next) {
            spawnables.add(json.readValue(Spawnable.class, entry));
        }
    }
}
