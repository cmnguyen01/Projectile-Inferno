package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.DurationComponent;
import com.droptableteams.game.components.RelativePositionComponent;
import com.droptableteams.game.components.SpiralComponent;
import com.droptableteams.game.components.game.GameCheatsComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;

public class SpiralAroundEntitySytem implements ISystem {
    int _id;
    String _type;
    ComponentManager _cm;

    public SpiralAroundEntitySytem(int id) {
        _id = id;
        _type = "SpiralAroundEntitySystem";
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
        SpiralComponent sc = (SpiralComponent) _cm.getComponent(_id, "SpiralComponent");
        RelativePositionComponent rpc = (RelativePositionComponent)_cm.getComponent(_id, "RelativePositionComponent");
        GameCheatsComponent gcc = (GameCheatsComponent) _cm.getComponent(SpecialEntityIds.GAME_ENTITY, "GameCheatsComponent");
        DurationComponent dc = (DurationComponent) _cm.getComponent(SpecialEntityIds.GAME_ENTITY, "DurationComponent");

        float currentAngle = rpc.getAngle();
        float currentRadius = rpc.getRadius();
        float deltaTheta = sc.getDeltaTheta();
        float deltaRadius = sc.getDeltaRadius();

        float timeDeltaAngle = deltaTheta * Gdx.graphics.getDeltaTime() * gcc.getSpeedMultiplier();
        float timeDeltaRadius = deltaRadius * Gdx.graphics.getDeltaTime() * gcc.getSpeedMultiplier();

        if(null != dc) {
            dc.elapsedRadius += timeDeltaRadius;
            dc.elapsedTheta += timeDeltaAngle;
        }

        rpc.setAngle(currentAngle + timeDeltaAngle);
        rpc.setRadius(currentRadius + timeDeltaRadius);
    }
}
