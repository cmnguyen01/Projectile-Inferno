package com.droptableteams.game.util;

public class Utils {
    public static long nanosToMillis(long nanos) {
        Double result = (nanos/Math.pow(10,6));
        return result.longValue();
    }

    public static float atan(float x, float y) {
        return -1f*(float)(Math.atan2(x, y) - Math.PI/2);
    }
}
