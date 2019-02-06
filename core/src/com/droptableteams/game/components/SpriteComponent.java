package com.droptableteams.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.droptableteams.game.LibECS.interfaces.IComponent;

public class SpriteComponent implements IComponent {

    private int _id;
    private String _type;

    private Texture _sprite;

    public SpriteComponent(int id, Texture sprite) {
        _id = id;
        _sprite = sprite;
        _type = "SpriteComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public Texture getSprite() {
        return _sprite;
    }
}
