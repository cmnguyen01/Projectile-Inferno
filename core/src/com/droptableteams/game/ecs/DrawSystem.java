package com.droptableteams.game.ecs;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.OrderedSystemTypes;

public class DrawSystem implements ISystem {
    private int _id;
    private String _type;
    LocationComponent _location;
    SpriteComponent _sprite;

    public DrawSystem(int id) {
        _id = id;
        _type = "DrawSystem";
        ComponentManager cm = ComponentManager.getInstance();
        _location = (LocationComponent) cm.getComponent(id, "LocationComponent");
        _sprite = (SpriteComponent) cm.getComponent(id, "SpriteComponent");
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

    public void draw(Batch b) {
        b.begin();
        b.draw(_sprite.getSprite(), _location.getX(), _location.getY());
        b.end();
    }
}
