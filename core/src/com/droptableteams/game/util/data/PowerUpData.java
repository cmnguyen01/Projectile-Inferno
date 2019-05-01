package com.droptableteams.game.util.data;

public class PowerUpData {
    public float direction =  4.71239f;
    public long delay;
    public float x;
    public float y;
    public String powerUpType;
    public float height;
    public float width;
    public String texture;
    public String subtype;
    public String entityType;
    public float speed;

    public PowerUpData() {
    }

    public PowerUpData(float direction, long delay, float x, float y, String powerUpType){
        this.direction = direction;
        this.delay = delay;
        this.x = x;
        this.y = y;
        this.powerUpType = powerUpType;
    }
}

