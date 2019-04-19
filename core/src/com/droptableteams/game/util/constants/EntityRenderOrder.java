package com.droptableteams.game.util.constants;

import com.droptableteams.game.entities.LifeDisplayEntity;

public class EntityRenderOrder {
    private static final String[] ENTITY_RENDER_ORDER = {
            "EnemyEntity",
            "BulletEntity",
            "PlayerEntity",
            "VisibleHitboxEntity",
            "LifeDisplayEntity",
    };

    public static String[] get() {
        return ENTITY_RENDER_ORDER;
    }
}
