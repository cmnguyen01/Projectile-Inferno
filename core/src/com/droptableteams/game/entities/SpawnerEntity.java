package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class SpawnerEntity implements IEntity {
    private int _id;
    private String _type;


    public SpawnerEntity(int id) {
        _id = id;
        _type = "SpawnerEntity";

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
