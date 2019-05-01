package com.droptableteams.game.util.constants;

import com.droptableteams.game.entities.LifeDisplayEntity;

/**
 * Contains a static array of system type strings,
 * in the order in which the systems should be updated.
 */
public class SystemUpdateOrder {
    private static String[] _systemUpdateOrder = {
            "HandleInputSystem",
            "SpawnerSystem",
            "FireControlSystem",
            "SpeedModifierSystem",
            "DirectionalMovementSystem",
            "DestinationMovementSystem",
            "UpdateLocationSystem",
            "RelativePositionSystem",
            "SetHitboxLocationSystem",
            "StopAtBoundarySystem",
            "BulletCollisionSystem",
            "CollisionDamageSystem",
            "RotateSpriteToDirectionSystem",
            "UpdateSpriteSystem",
            "DespawnOutOfBoundsSystem",
            "LifeUpdateSystem",
            "RespawnSystem",
            "EndGameSystem",
            "RenderSystem",
            "PowerUpCollisionSystem",

    };

    public static String[] get() { return _systemUpdateOrder; }
}
