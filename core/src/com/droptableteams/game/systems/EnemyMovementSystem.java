package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.VelocityComponent;

public class EnemyMovementSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public EnemyMovementSystem(int id){
        _id = id;
        _type = "EnemyMovementSystem";
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
        vc.setDx(256f);
    }
}
