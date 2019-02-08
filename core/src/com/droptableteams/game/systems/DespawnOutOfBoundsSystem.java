package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.HasBeenInboundsComponent;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

/**
 * TODO: Should be updated to to despawn when fully invisible, instead of after center-point passes boundary.
 */
public class DespawnOutOfBoundsSystem implements ISystem {
    private int _id;
    private String _type;
    ComponentManager _cm;

    public DespawnOutOfBoundsSystem(int id) {
        _id = id;
        _type = "DespawnOutOfBoundsSystem";
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
        HasBeenInboundsComponent ibc = (HasBeenInboundsComponent)_cm.getComponent(_id, "HasBeenInboundsComponent");
        boolean hasBeenInbounds = ibc.getHasBeenInBounds();
        float leftBound = 0;
        float rightBound = Gdx.graphics.getWidth();
        float bottomBound = 0;
        float topBound = Gdx.graphics.getHeight();
        float x = lc.getX();
        float y = lc.getY();

        if(!hasBeenInbounds) {
            if((leftBound < x && rightBound > x) && (bottomBound < y && topBound > y)) {
                ibc.setHasBeenInBounds(true);
            }
        }
        else {
            if((leftBound > x || rightBound < x) || (bottomBound > y || topBound < y)) {
                ECSEngine.getInstance(SystemUpdateOrder.get()).flagEntityForRemoval(_id);
            }
        }


    }
}
