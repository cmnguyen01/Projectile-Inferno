package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class GameEntity implements IEntity {
    private int _id;
    private String _type;

    public GameEntity(int id) {
        _id = id;
        _type = "GameEntity";
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
