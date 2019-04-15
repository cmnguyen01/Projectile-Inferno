package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class FireControllerEntity implements IEntity {
    int _id;
    String _type;

    public FireControllerEntity(int id) {
        _id = id;
        _type = "FireControllerEntity";
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
