package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class SpiralComponent implements IComponent {
    private int _id;
    private String _type;
    private float _deltaRadius;
    private float _deltaTheta;

    public SpiralComponent(int id, float deltaRadius, float deltaTheta) {
        _id = id;
        _type = "SpiralComponent";
        _deltaRadius = deltaRadius;
        _deltaTheta = deltaTheta;
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }


    public float getDeltaRadius() {
        return _deltaRadius;
    }

    public void setDeltaRadius(float deltaRadius) {
        _deltaRadius = deltaRadius;
    }

    public float getDeltaTheta() {
        return _deltaTheta;
    }

    public void setDeltaTheta(float deltaTheta) {
        _deltaTheta = deltaTheta;
    }
}
