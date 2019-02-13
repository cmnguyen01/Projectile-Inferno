package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.game.GameCheatsComponent;
import com.droptableteams.game.components.VelocityComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;

public class SpeedModifierSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public SpeedModifierSystem(int id) {
        _id = id;
        _cm = ComponentManager.getInstance();
        _type = "SpeedModifierSystem";
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
        GameCheatsComponent gcc = (GameCheatsComponent) _cm.getComponent(SpecialEntityIds.GAME_ENTITY, "GameCheatsComponent");
        VelocityComponent vc = (VelocityComponent)_cm.getComponent(_id,"VelocityComponent");
        vc.setModifiedSpeed(vc.getBaseSpeed() * gcc.getSpeedMultiplier());
    }
}
