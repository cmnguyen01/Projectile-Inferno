package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class LocationComponent implements IComponent {
    private int _id;
    private String _type;
    private float _x;
    private float _y;

    public LocationComponent(int id, float x, float y) {
        _id = id;
        _x = x;
        _y = y;
        _type = "LocationComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public float getX() {
        return _x;
    }
    public void setX(float x) { _x = x; }

    public float getY() {
        return _y;
    }
    public void setY(float y) { _y = y; }
}
