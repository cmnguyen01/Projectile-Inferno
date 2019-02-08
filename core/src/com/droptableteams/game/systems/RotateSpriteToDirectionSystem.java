package com.droptableteams.game.systems;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.MoveDirectionComponent;
import com.droptableteams.game.components.SpriteComponent;

public class RotateSpriteToDirectionSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public RotateSpriteToDirectionSystem(int id) {
        _id = id;
        _cm = ComponentManager.getInstance();
        _type = "RotateSpriteToDirectionSystem";
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
        MoveDirectionComponent mdc = (MoveDirectionComponent) _cm.getComponent(_id, "MoveDirectionComponent");
        SpriteComponent sc = (SpriteComponent) _cm.getComponent(_id, "SpriteComponent");

        float degrees = (float)(mdc.getRadians()*180/ Math.PI )-90f; // TODO: replace 90f with defaultSpriteOrientation (in sprite component)
        sc.getSprite().setRotation(degrees);
        //sc.getSprite().rotate(degrees);
    }
}
