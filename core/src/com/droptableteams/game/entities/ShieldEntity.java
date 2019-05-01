package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class ShieldEntity implements IEntity {

    private int _id;
    private String _type = "ShieldEntity";

    public ShieldEntity(int id){
        _id = id;
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
