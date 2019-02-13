package com.droptableteams.game.util.types;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.droptableteams.game.util.data.FirePatternData;

public class EnemyType implements IEntitySubtype, Json.Serializable {
    public String entityType;
    public String subtype;
    public String texture;
    public FirePatternData firePattern;
    public float width;
    public float height;
    public float speed;
    public boolean despawnOutOfBounds;
    public boolean loopDestinations;

    public EnemyType() {
        entityType = "none";
        subtype = "none";
        texture = "none";
        firePattern = null;
        width = 0;
        height = 0;
        speed = 0;
        despawnOutOfBounds = false;
        loopDestinations = false;
    }

    public EnemyType(String entityType, String subtype, FirePatternData firePattern, float width, float height, float speed, boolean despawnOutOfBounds, boolean loopDestinations, String texture) {
        this.entityType = entityType;
        this.subtype = subtype;
        this.firePattern = firePattern;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.despawnOutOfBounds = despawnOutOfBounds;
        this.loopDestinations = loopDestinations;
        this.texture = texture;
    }

    @Override
    public String getEntityType() {
        return entityType;
    }

    @Override
    public String getSubtype() {
        return subtype;
    }

    @Override
    public void write(Json json) {
        json.writeValue("entityType", entityType);
        json.writeValue("subtype", subtype);
        json.writeValue("texture", texture);
        json.writeValue("width", width);
        json.writeValue("height", height);
        json.writeValue("speed", speed);
        json.writeValue("despawnOutOfBounds",despawnOutOfBounds);
        json.writeValue("loopDestinations", loopDestinations);
        json.writeValue("firePattern", firePattern, FirePatternData.class);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        entityType = jsonData.getString("entityType");
        subtype = jsonData.getString("subtype");
        texture = jsonData.getString("texture");
        width = jsonData.getFloat("width");
        height = jsonData.getFloat("height");
        speed = jsonData.getFloat("speed");
        despawnOutOfBounds = jsonData.getBoolean("despawnOutOfBounds");
        loopDestinations = jsonData.getBoolean("loopDestinations");
        firePattern = json.readValue("firePattern", FirePatternData.class, jsonData);
    }
}
