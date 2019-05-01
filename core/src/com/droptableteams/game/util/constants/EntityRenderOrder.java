package com.droptableteams.game.util.constants;

import com.droptableteams.game.entities.LifeDisplayEntity;

public class EntityRenderOrder {
    private static final String[] ENTITY_RENDER_ORDER = {
            "EnemyEntity",
            "BulletEntity",
            "PlayerEntity",
            "VisibleHitboxEntity",
<<<<<<< HEAD
            "BossEntity"
=======
            "ShieldEntity",
            "LifeDisplayEntity",
>>>>>>> a4d8822b835d5bdf348f7f7de84c09800408bcda
    };

    public static String[] get() {
        return ENTITY_RENDER_ORDER;
    }
}
