package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class OwnerComponent implements IComponent {
    private int _id;
    private String _type;
    private int _ownerId;


    public OwnerComponent(int id, int ownerId) {
        _id = id;
        _ownerId = ownerId;
        _type = "OwnerComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public int getOwnerId() {
        return _ownerId;
    }

    public void setOwnerId(int ownerId) {
        _ownerId = ownerId;
    }
}
