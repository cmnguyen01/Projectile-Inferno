package com.droptableteams.game.factories.data;

/**
 * TODO: refactor to use string reference to BulletType, then remove all fields stored by BulletType class
 */
public class BulletData {
    public float direction;
    public float speed; // stored in BulletType TODO: remove
    public long delay;
    public float width; // stored in BulletType TODO: remove
    public float height;// stored in BulletType TODO: remove
    public float x;
    public float y;
    public String texture; // stored in BulletType TODO: remove

    public BulletData(float direction, float speed, long delay, float width, float height, float x, float y, String texture) {
        this.direction = direction;
        this.speed = speed;
        this.delay = delay;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.texture = texture;
    }
}
