package com.droptableteams.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.interfaces.IComponent;

public class SpriteComponent implements IComponent {

    private int _id;
    private String _type;

    private Sprite _sprite;

    public SpriteComponent(int id, Sprite sprite) {
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

    public Sprite getSprite() {
        return _sprite;
    }
}
