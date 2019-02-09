package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.badlogic.gdx.math.Rectangle;

public class HitboxComponent implements IComponent {
    private int _id;
    private String _type;
    private Rectangle _hitbox;

    public HitboxComponent(int id, Rectangle hitbox) {
        _id = id;
        _hitbox = hitbox;
        _type = "HitboxComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public Rectangle getHitbox() {
        return _hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        _hitbox = hitbox;
    }
}
