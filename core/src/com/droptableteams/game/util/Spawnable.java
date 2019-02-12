package com.droptableteams.game.util;

/**
 * TODO: fields of type 'Object' may be difficult to serialize:
 * If enemies are the only 'Spawnable' to be listed in level script
 * then we can replace 'Object args' with 'EnemyData ed'...
 */
public class Spawnable {
    public long timeInMillis;
    public String entityType;
    public String subtype;
    public Object args;
}
