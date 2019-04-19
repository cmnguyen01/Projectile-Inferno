package com.droptableteams.game.entities;

import com.droptableteams.game.LibECS.interfaces.IEntity;

public class LifeDisplayEntity implements IEntity {
    private int _id;
    private String _type;
    public LifeDisplayEntity(int id){
        _id = id;
        _type = "LifeDisplayEntity";
    }

    @Override
    public int getId() {return _id;}

    @Override
    public String getType() {return _type;}
}
