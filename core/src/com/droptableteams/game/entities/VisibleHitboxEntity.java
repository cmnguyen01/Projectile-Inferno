package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class VisibleHitboxEntity implements IEntity {
    private int _id;
    private String _type;

    public VisibleHitboxEntity(int id) {
        _id = id;
        _type = "VisibleHitboxEntity";
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
