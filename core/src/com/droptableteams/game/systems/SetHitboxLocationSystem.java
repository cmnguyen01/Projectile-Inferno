package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.HitboxComponent;
import com.droptableteams.game.components.LocationComponent;

public class SetHitboxLocationSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public SetHitboxLocationSystem(int id) {
        _id = id;
        _type = "SetHitboxLocationSystem";
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
        LocationComponent lc = (LocationComponent)_cm.getComponent(_id, "LocationComponent");
        HitboxComponent hc = (HitboxComponent)_cm.getComponent(_id, "HitboxComponent");
        hc.getHitbox().setCenter(lc.getX(), lc.getY());
    }
}
