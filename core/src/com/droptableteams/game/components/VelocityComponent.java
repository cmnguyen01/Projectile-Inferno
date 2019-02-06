package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class VelocityComponent implements IComponent {
    private int _id;
    private String _type;
    private float _baseSpeed;
    private float _speedMultiplier;
    private float _dx;
    private float _dy;
    private float _slow;
    private float _normal;

    public VelocityComponent(int id, float baseSpeed) {
        _id = id;
        _baseSpeed = baseSpeed;
        _slow = 0.5f;
        _normal = 1;
        _speedMultiplier = _normal;
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

    public float get_speedMultiplier(){ return _speedMultiplier; }

    public void set_speedMultiplier(){
        if(_speedMultiplier == _slow){
            _speedMultiplier = _normal;
        }else {
            _speedMultiplier = _slow;
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
