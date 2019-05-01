package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class StaticSpriteEntity implements IEntity {
    private  int _id;
    private  String _type;

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }
    public StaticSpriteEntity(int id){
        _id = id;
        _type = "StaticSpriteEntity";
    }
}
