package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.SizeComponent;
import com.droptableteams.game.components.SpriteComponent;

public class UpdateSpriteSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public UpdateSpriteSystem(int id) {
        _id = id;
        _type = "UpdateSpriteSystem";
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
        SpriteComponent sp = (SpriteComponent)_cm.getComponent(_id, "SpriteComponent");
        LocationComponent loc = (LocationComponent)_cm.getComponent(_id, "LocationComponent");
        SizeComponent sz = (SizeComponent)_cm.getComponent(_id, "SizeComponent");

        sp.getSprite().setCenter(loc.getX(), loc.getY());
        sp.getSprite().setSize(sz.getWidth(), sz.getHeight());
    }
}
