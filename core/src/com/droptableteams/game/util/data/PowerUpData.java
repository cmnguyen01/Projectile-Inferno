package com.droptableteams.game.util.data;

public class PowerUpData {
    public float direction;
    public long delay;
    public float x;
    public float y;
    public String powerUpType;

    public PowerUpData() {
        direction = 0;
        delay = 0;
        x = 0;
        y = 0;
        powerUpType = "none";
    }

    public PowerUpData(float direction, long delay, float x, float y, String powerUpType){
        this.direction = direction;
        this.delay = delay;
        this.x = x;
        this.y = y;
        this.powerUpType = powerUpType;
    }
}

