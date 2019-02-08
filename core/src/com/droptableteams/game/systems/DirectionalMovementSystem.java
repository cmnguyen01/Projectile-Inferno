package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.MoveDirectionComponent;
import com.droptableteams.game.components.VelocityComponent;

public class DirectionalMovementSystem implements ISystem {
    private int _id;
    private String _type;
    ComponentManager _cm;

    public DirectionalMovementSystem(int id) {
        _id = id;
        _type = "DirectionalMovementSystem";
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
        VelocityComponent vc = (VelocityComponent)_cm.getComponent(_id, "VelocityComponent");
        MoveDirectionComponent mdc = (MoveDirectionComponent) _cm.getComponent(_id, "MoveDirectionComponent");
        float newDx = 0;
        float newDy = 0;
        Float angle = mdc.getRadians();
        if(null != angle) {
            float hyp = vc.getBaseSpeed();
            newDx = (float)Math.cos(angle)*hyp;
            newDy = (float)Math.sin(angle)*hyp;
        }
        vc.setDx(newDx);
        vc.setDy(newDy);
    }
}
