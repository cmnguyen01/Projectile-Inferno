package com.droptableteams.game.statics;

public class EntityRenderOrder {
    private static String[] _entityRenderOrder = {
            "EnemyEntity",
            "PlayerBulletEntity",
            "PlayerEntity",
    };

    public static String[] get() {
        return _entityRenderOrder;
    }
}
