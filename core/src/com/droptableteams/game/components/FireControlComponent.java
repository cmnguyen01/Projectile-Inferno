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
}
