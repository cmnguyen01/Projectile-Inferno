package com.droptableteams.game.util.types;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class PowerUpType implements IEntitySubtype, Json.Serializable {
    public float speed;
    public float width;
    public float height;
    public String texture;
    public String subtype;
    public String entityType;


    public PowerUpType() {
        speed = 0;
        width = 0;
        height = 0;
        texture = "none";
        entityType = "none";
        subtype = "none";
    }

    public PowerUpType(String entityType, String subtype, float speed, float width, float height, String texture) {
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.entityType = entityType;
        this.subtype = subtype;
    }


    @Override
    public String getEntityType(){ return entityType;}
    @Override
    public String getSubtype(){ return subtype;}


    @Override
    public void write(Json json)
    {
        json.writeValue("entityType", entityType);
        json.writeValue("subtype", subtype);
        json.writeValue("texture", texture);
        json.writeValue("width", width);
        json.writeValue("height", height);
        json.writeValue("speed", speed);
    }

    @Override
    public void read(Json json, JsonValue jsonData)
    {
        entityType = jsonData.getString("entityType");
        subtype = jsonData.getString("subtype");
        texture = jsonData.getString("texture");
        width = jsonData.getFloat("width");
        height = jsonData.getFloat("height");
        speed = jsonData.getFloat("speed");
    }
}
