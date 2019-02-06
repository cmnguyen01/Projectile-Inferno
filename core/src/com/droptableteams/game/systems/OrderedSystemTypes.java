package com.droptableteams.game.systems;

/**
 * Contains a static array of system type strings,
 * in the order in which the systems should be updated.
 */
public class OrderedSystemTypes {
    private static String[] _orderedSystemTypes = {
            "HandleInputSystem",
            "UpdateLocationSystem",
            "UpdateSpriteSystem",
            "DrawSystem",
    };

    public static String[] get() { return _orderedSystemTypes; }
}
