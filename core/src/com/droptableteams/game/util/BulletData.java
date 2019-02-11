package com.droptableteams.game.util;

public class BulletData {
    public float direction;
    public float speed;
    public long delay;
    public float width;
    public float height;
    public float x;
    public float y;
    public String texture;

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
