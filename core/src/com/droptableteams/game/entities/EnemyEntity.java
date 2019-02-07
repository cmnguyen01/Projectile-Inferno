package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class EnemyEntity implements IEntity {
    private int _id;
    private String _type;

    public EnemyEntity(int id){
        _id = id;
        _type = "EnemyEntity";
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
