package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class VelocityComponent implements IComponent {
    private int _id;
    private String _type;
    private float _baseSpeed;
    private float _speedMultiplier;
    private float _slowMultiplier;
    private float _dx;
    private float _dy;

    public VelocityComponent(int id, float baseSpeed, float slowMultiplier) {
        _id = id;
        _baseSpeed = baseSpeed;
        _slowMultiplier = slowMultiplier;
        _speedMultiplier = 1;
        _type = "VelocityComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }


    public float getBaseSpeed() {
        return _baseSpeed;
    }

    public void setBaseSpeed(float baseSpeed) {
        _baseSpeed = baseSpeed;
    }

    public float getSpeedMultiplier(){ return _speedMultiplier; }

    public void toggleSpeedMultiplier(){
        if(_speedMultiplier == _slowMultiplier){
            _speedMultiplier = 1;
        }else {
            _speedMultiplier = _slowMultiplier;
        }
    }

    public float getDx() {
        return _dx;
    }

    public void setDx(float dx) {
        _dx = dx;
    }

    public float getDy() {
        return _dy;
    }

    public void setDy(float dy) {
        _dy = dy;
    }
}
