package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.FirePatternComponent;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;

public class TargetPlayerSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public TargetPlayerSystem(int id) {
        _id = id;
        _type = "TargetPlayerSystem";
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
        LocationComponent lc = (LocationComponent)ComponentManager.getInstance().getComponent(_id, "LocationComponent");
        LocationComponent plc = (LocationComponent)ComponentManager.getInstance().getComponent(SpecialEntityIds.PLAYER_ENTITY, "LocationComponent");
        FirePatternComponent fpc = (FirePatternComponent)_cm.getComponent(_id, "FirePatternComponent");

        float dy = plc.getY() - lc.getY();
        float dx = plc.getX() - lc.getX();
        float theta = (float)Math.atan2(dy,dx);
        fpc.setBaseDirection(theta);
    }
}
