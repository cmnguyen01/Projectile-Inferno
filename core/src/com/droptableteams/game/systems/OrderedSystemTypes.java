package com.droptableteams.game.systems;

public class OrderedSystemTypes {
    private static String[] _orderedSystemTypes = {
        "HandleInputSystem",
        "UpdateLocationSystem",
        "UpdateSpriteSystem",
    };

    public static String[] get() { return _orderedSystemTypes; }
}
