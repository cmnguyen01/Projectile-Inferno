package com.droptableteams.game.util.types;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class BulletType implements IEntitySubtype, Serializable {
    public float speed;
    public float width;
    public float height;
    public int damage;
    public String texture;
    public String subtype;
    public String entityType;

    public BulletType() {
        speed = 0;
        width = 0;
        height = 0;
        damage = 0;
        texture = "none";
        entityType = "none";
        subtype = "none";
    }


    public BulletType(String entityType, String subtype, float speed, float width, float height, int damage, String texture) {
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.damage = damage;
        this.texture = texture;
        this.entityType = entityType;
        this.subtype = subtype;
    }

    @Override
    public String getSubtype() {
        return subtype;
    }

    @Override
    public String getEntityType() {
        return entityType;
    }

    @Override
    public void write(Json json) {
        json.writeValue("speed", speed);
        json.writeValue("width", width);
        json.writeValue("height", height);
        json.writeValue("damage", damage);
        json.writeValue("entityType", entityType);
        json.writeValue("subtype", subtype);
        json.writeValue("texture", texture);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        speed = jsonData.getFloat("speed");
        width = jsonData.getFloat("width");
        height = jsonData.getFloat("height");
        damage = jsonData.getInt("damage");
        entityType = jsonData.getString("entityType");
        subtype = jsonData.getString("subtype");
        texture = jsonData.getString("texture");
    }
}
