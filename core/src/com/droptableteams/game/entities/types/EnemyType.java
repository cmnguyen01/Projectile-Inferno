package com.droptableteams.game.entities.types;

import com.droptableteams.game.factories.data.FirePatternData;

public class EnemyType implements IEntitySubtype {
    public final String entityType;
    public final String subtype;
    public final String texture;
    public final FirePatternData firePattern;
    public final float width;
    public final float height;
    public final float speed;
    public final boolean despawnOutOfBounds;
    public final boolean loopDesinations;

    public EnemyType(String entityType, String subtype, FirePatternData firePattern, float width, float height, float speed, boolean despawnOutOfBounds, boolean loopDestinations, String texture) {
        this.entityType = entityType;
        this.subtype = subtype;
        this.firePattern = firePattern;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.despawnOutOfBounds = despawnOutOfBounds;
        this.loopDesinations = loopDestinations;
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
}
