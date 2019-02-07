package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;

public class StopAtBoundarySystem implements ISystem {
    private int _id;
    private String _type;
    ComponentManager _cm;

    public StopAtBoundarySystem(int id) {
        _id = id;
        _type = "StopAtBoundarySystem";
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
        float leftBound = 0;
        float rightBound = Gdx.graphics.getWidth();
        float bottomBound = 0;
        float topBound = Gdx.graphics.getHeight();

        if(lc.getX() < leftBound) {
            lc.setX(leftBound);
        }
        else if(lc.getX() > rightBound) {
            lc.setX(rightBound);
        }
        if(lc.getY() < bottomBound) {
            lc.setY(bottomBound);
        }
        else if(lc.getY() > topBound) {
            lc.setY(topBound);
        }
    }
}
