package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class HasBeenInboundsComponent implements IComponent {
    private int _id;
    private String _type;
    private boolean _hasBeenInBounds;

    public HasBeenInboundsComponent(int id, boolean hasBeenInbounds) {
        _id = id;
        _hasBeenInBounds = hasBeenInbounds;
        _type = "HasBeenInboundsComponent";
    }
    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }


    public boolean getHasBeenInBounds() {
        return _hasBeenInBounds;
    }

    public void setHasBeenInBounds(boolean hasBeenInBounds) {
        _hasBeenInBounds = hasBeenInBounds;
    }
}
