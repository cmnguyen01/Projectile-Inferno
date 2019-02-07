package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class GameCheatsComponent implements IComponent {
    private int _id;
    private String _type;

    private float _speedMultiplier;
    private float _slowMultiplier;

    public GameCheatsComponent(int id, float slowMultiplier) {
        _id = id;
        _speedMultiplier = 1f;
        _slowMultiplier = slowMultiplier;
        _type = "GameCheatsComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public void toggleSpeedMultiplier(){
        if(_speedMultiplier == _slowMultiplier){
            _speedMultiplier = 1f;
        }else {
            _speedMultiplier = _slowMultiplier;
        }
    }

    public float getSpeedMultiplier() { return _speedMultiplier; }
}
