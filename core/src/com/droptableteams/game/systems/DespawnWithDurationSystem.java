package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.DurationComponent;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class DespawnWithDurationSystem implements ISystem {
    private int _id;
    private String _type;
    ComponentManager _cm;

    public DespawnWithDurationSystem(int id) {
        _id = id;
        _type = "DespawnWithDurationSystem";
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
        DurationComponent dc =  (DurationComponent)_cm.getComponent(_id, "DurationComponent");
        if(dc.durationMet) {
            ECSEngine.getInstance(SystemUpdateOrder.get()).flagEntityForRemoval(_id);
        }
    }
}
