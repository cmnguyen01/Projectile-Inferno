package com.droptableteams.game.factories.data;

/**
 * TODO: refactor to use string reference to BulletType, then remove all fields stored by BulletType class
 */
public class BulletData {
    public float direction;
    public long delay; // possibly move to type?
    public float x;
    public float y;
    public String bulletType;

    public BulletData() {
        direction = 0;
        delay = 0;
        x = 0;
        y = 0;
        bulletType = "unknown";
    }

    public BulletData(float direction, long delay, float x, float y, String bulletType) {
        this.direction = direction;
        this.delay = delay;
        this.x = x;
        this.y = y;
        this.bulletType = bulletType;
    }
}
