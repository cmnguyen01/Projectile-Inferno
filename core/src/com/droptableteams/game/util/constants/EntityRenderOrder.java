package com.droptableteams.game.util.constants;

public class EntityRenderOrder {
    private static final String[] ENTITY_RENDER_ORDER = {
            "EnemyEntity",
            "BulletEntity",
            "PlayerEntity",
    };

    public static String[] get() {
        return ENTITY_RENDER_ORDER;
    }
}
