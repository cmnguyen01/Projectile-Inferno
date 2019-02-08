package com.droptableteams.game.util.constants;

public class EntityRenderOrder {
    public static final String[] ENTITY_RENDER_ORDER = {
            "EnemyEntity",
            "BulletEntity",
            "PlayerEntity",
    };

    @Deprecated
    public static String[] get() {
        return ENTITY_RENDER_ORDER;
    }
}
