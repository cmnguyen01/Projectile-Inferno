package com.droptableteams.game.util.constants;

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
            "RotateSpriteToDirectionSystem",
            "UpdateSpriteSystem",
            "DespawnOutOfBoundsSystem",
            "RenderSystem",
    };

    public static String[] get() { return _systemUpdateOrder; }
}
