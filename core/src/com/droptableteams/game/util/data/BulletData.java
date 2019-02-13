package com.droptableteams.game.util.data;

/**
 * TODO: refactor to use string reference to BulletType, then remove all fields stored by BulletType class
 */
public class BulletData {
    public float direction;
    public long delay;
    public float x;
    public float y;
    public int ownerId;
    public String bulletType;

    public BulletData() {
        direction = 0;
        delay = 0;
        x = 0;
        y = 0;
        ownerId = -1;
        bulletType = "none";
    }

    public BulletData(float direction, long delay, float x, float y, int ownerId, String bulletType) {
        this.direction = direction;
        this.delay = delay;
        this.x = x;
        this.y = y;
        this.ownerId = ownerId;
        this.bulletType = bulletType;
    }
}
