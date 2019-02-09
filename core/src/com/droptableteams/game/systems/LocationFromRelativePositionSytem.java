package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.RelativePositionComponent;

public class LocationFromRelativePositionSytem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public LocationFromRelativePositionSytem(int id) {
        _id = id;
        _type = "LocationFromRelativePositionSystem";
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
        RelativePositionComponent rpc = (RelativePositionComponent)_cm.getComponent(_id, "RelativePositionComponent");
        LocationComponent thisLc = (LocationComponent)_cm.getComponent(_id, "LocationComponent");
        LocationComponent thatLc = (LocationComponent)_cm.getComponent(rpc.getRelativeEntityId(), "LocationComponent");
        float angle = rpc.getDAngle();
        float hyp = rpc.getRadius();
        float adj = (float)Math.cos(angle)*hyp;
        float opp = (float)Math.sin(angle)*hyp;
        thisLc.setX(thatLc.getX()+adj);
        thisLc.setY(thatLc.getY()+opp);
    }
}
