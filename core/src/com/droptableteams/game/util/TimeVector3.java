package com.droptableteams.game.util;

import com.badlogic.gdx.math.Vector2;

public class TimeVector3 {
    private Vector2 _position;
    private long _time;

    public TimeVector3() {
        _position = new Vector2();
        _time = 0;
    }

    public TimeVector3(float x, float y, long time) {
        _position = new Vector2(x,y);
        _time = time;
    }

    public Vector2 getPosition() {
        return _position;
    }

    public void setPosition(Vector2 position) {
        _position = position;
    }

    public float getX() { return _position.x; }

    public float getY() { return _position.y; }

    public long getTime() {
        return _time;
    }

    public void setTime(long time) {
        _time = time;
    }
}
