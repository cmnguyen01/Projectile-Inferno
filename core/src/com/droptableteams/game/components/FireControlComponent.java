package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class FireControlComponent implements IComponent {
    private int _id;
    private String _type;
    private float _rateOfFire;
    private boolean _firing;
    private long _lastFired = 0;

    public FireControlComponent(int id, float rateOfFire, boolean firing) {
        _id = id;
        _firing = firing;
        _rateOfFire = rateOfFire;
        _type = "FireControlComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }


    public float getRateOfFire() {
        return _rateOfFire;
    }

    public void setRateOfFire(float rateOfFire) {
        _rateOfFire = rateOfFire;
    }

    public long getLastFired() {
        return _lastFired;
    }

    public void setLastFired(long lastFired) {
        _lastFired = lastFired;
    }

    public boolean isFiring() {
        return _firing;
    }

    public void setFiring(boolean firing) {
        _firing = firing;
    }
}
