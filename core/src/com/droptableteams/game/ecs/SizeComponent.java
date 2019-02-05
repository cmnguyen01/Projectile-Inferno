package com.droptableteams.game.ecs;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class SizeComponent implements IComponent {
    private int _id;
    private String _type;
    private float _width;
    private float _height;

    public SizeComponent(int id, float width, float height) {
        _id = id;
        _width = width;
        _height = height;
        _type = "SizeComponent";
    }
    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public float getWidth() {
        return _width;
    }

    public float getHeight() {
        return _height;
    }
}
