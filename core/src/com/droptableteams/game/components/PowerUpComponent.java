package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.data.PowerUpData;

public class PowerUpComponent implements IComponent {
    private int _id;
    private String _type;
    private boolean _hasPowerUp;

    public PowerUpComponent(int id, boolean power){
        _id = id;
        _type = "PowerUpComponent";
        _hasPowerUp = power;
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
