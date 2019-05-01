package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.DurationComponent;
import com.droptableteams.game.components.game.GameTimeComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class DurationSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public DurationSystem(int id) {
        _id = id;
        _type = "DurationSystem";
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
        DurationComponent dc = (DurationComponent)_cm.getComponent(_id, "DurationComponent");

        switch (dc.durationType) {
            case TIME:
                handleTime(dc);
                break;
            case ANGLE:
                handleAngle(dc);
                break;
            case RADIUS:
                handleRadius(dc);
                break;
            default:
                handleTime(dc);
        }
    }

    private void handleTime(DurationComponent dc) {
        GameTimeComponent gtc = (GameTimeComponent)_cm.getComponent(SpecialEntityIds.GAME_ENTITY, "GameTimeComponent");
        long duration = (long)(dc.duration * 1000);
        if(gtc.getTimeInMillis() - dc.startTime >= duration && duration != 0f) {
            dc.durationMet = true;
        }
    }

    private void handleAngle(DurationComponent dc) {
        if(dc.elapsedTheta >= dc.duration &&  dc.duration != 0f) {
            dc.durationMet = true;
        }
    }

    private void handleRadius(DurationComponent dc) {
        if(dc.elapsedRadius >= dc.duration && dc.duration != 0f) {
            dc.durationMet = true;
        }
    }
}
