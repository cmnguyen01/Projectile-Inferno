package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class MoveDirectionComponent implements IComponent {
    private int _id;
    private String _type;
    private Float _radians;

    public MoveDirectionComponent(int id, Float radians) {
        _id = id;
        _radians = radians;
        _type = "MoveDirectionComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public Float getRadians() {
        return _radians;
    }

    /**
     * Set the direction of travel in radians.
     * @param radians the direction of travel. Set to null if not moving.
     */
    public void setRadians(Float radians) {
        _radians = radians;
    }
}
