package com.droptableteams.game.statics;

public class EntityRenderOrder {
    public static final String[] ENTITY_RENDER_ORDER = {
            "EnemyEntity",
            "PlayerBulletEntity",
            "PlayerEntity",
    };

    @Deprecated
    public static String[] get() {
        return ENTITY_RENDER_ORDER;
    }
}
