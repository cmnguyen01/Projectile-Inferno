package com.droptableteams.game.util.constants;

import com.droptableteams.game.entities.LifeDisplayEntity;

/**
 * Contains a static array of system type strings,
 * in the order in which the systems should be updated.
 */
public class SystemUpdateOrder {
    private static String[] _systemUpdateOrder = {
            "DurationSystem",
            "HandleInputSystem",
            "SpawnerSystem",
            "TargetPlayerSystem",
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
            "LifeUpdateSystem",
            "RespawnSystem",
            "DespawnWithDurationSystem",
            "DespawnOutOfBoundsSystem",
            "DestroyOnOwnerDeathSystem",
            "RenderSystem",
    };

    public static String[] get() { return _systemUpdateOrder; }
}
