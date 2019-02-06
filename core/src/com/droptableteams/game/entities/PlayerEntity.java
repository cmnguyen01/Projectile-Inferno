package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class PlayerEntity implements IEntity {
    private int _id;
    private String _type;

    public PlayerEntity(int id) {
        _id = id;
        _type = "PlayerEntity";
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
