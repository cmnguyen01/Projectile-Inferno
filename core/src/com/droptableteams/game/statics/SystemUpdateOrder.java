package com.droptableteams.game.statics;

/**
 * Contains a static array of system type strings,
 * in the order in which the systems should be updated.
 */
public class SystemUpdateOrder {
    private static String[] _systemUpdateOrder = {
            "HandleInputSystem",
            "FireControlSystem",
            "EnemyMovementSystem",
            "DirectionalMovementSystem",
            "SpeedModifierSystem",
            "UpdateLocationSystem",
            "StopAtBoundarySystem",
            "UpdateSpriteSystem",
            "DespawnOutOfBoundsSystem",
            "RenderSystem",
    };

    public static String[] get() { return _systemUpdateOrder; }
}
