package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.data.FireControlData;
import com.droptableteams.game.util.constants.Enums.*;

public class FireControlComponent implements IComponent {
    private int _id;
    private String _type;
    public boolean _firing;
    public long _lastFired = 0;
    public float _rateOfFire;
    public float initialRadius;
    public float deltaRadius;
    public float initialAngle;
    public float deltaAngle;
    public DurationType durationType;
    public float rateOfFire;
    public FireDirectionType fireDirectionType;
    public float fireAngle;

    public FireControlComponent(int id, float rateOfFire, boolean firing) {
        _id = id;
        _firing = firing;
        _rateOfFire = rateOfFire;
        _type = "FireControlComponent";
        fireDirectionType = FireDirectionType.ANGLE;
    }

    public FireControlComponent(int id, FireControlData fireControlData) {
        _id = id;
        _type = "FireControlComponent";
        _firing = true;
        _lastFired = 0;
        initialRadius = fireControlData.initialRadius;
        deltaRadius = fireControlData.deltaRadius;
        initialAngle = fireControlData.initialAngle;
        deltaAngle = fireControlData.deltaAngle;
        durationType = fireControlData.durationType;
        rateOfFire = fireControlData.rateOfFire;
        fireDirectionType = fireControlData.fireDirectionType;
        fireAngle = fireControlData.fireAngle;
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
