package com.droptableteams.game.systems;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;

import java.util.HashMap;
import java.util.Map;

public class DrawSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public DrawSystem(int id) {
        _id = id;
        _type = "DrawSystem";
        _cm = ComponentManager.getInstance();
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public void update() {
    }

    public void draw(SpriteBatch batch) {
        ((SpriteComponent)_cm.getComponent(_id, "SpriteComponent")).getSprite().draw(batch);
    }
}
