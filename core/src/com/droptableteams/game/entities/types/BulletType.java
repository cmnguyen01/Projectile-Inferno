package com.droptableteams.game.entities.types;

public class BulletType implements IEntitySubtype {
    public final float speed;
    public final float width;
    public final float height;
    public final int damage;
    public final String texture;
    public final String subtype;
    public final String entityType;


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
}
