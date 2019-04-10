package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class PowerUpEntity implements IEntity {

    private int _id;
    private String _type;

    public PowerUpEntity(int id){
        _id = id;
        _type = "PowerUpEntity";
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
