package com.droptableteams.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;

public class SpriteComponent implements IComponent {

    private int _id;
    private String _type;

    private Sprite _sprite;
    private boolean _visible;

    public SpriteComponent(int id, Sprite sprite) {
        _id = id;
        _sprite = sprite;
        _type = "SpriteComponent";
        _visible = true;
    }

    public SpriteComponent(int id, Sprite sprite, boolean visible) {
        _id = id;
        _sprite = sprite;
        _type = "SpriteComponent";
        _visible = visible;
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

    public boolean isVisible() {
        return _visible;
    }

    public void setVisible(boolean visible) {
        _visible = visible;
    }
}
