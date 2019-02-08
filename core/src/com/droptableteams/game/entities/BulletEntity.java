package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class BulletEntity implements IEntity {
    private int _id;
    private String _type;

    public BulletEntity(int id) {
        _id = id;
        _type = "BulletEntity";
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
