package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LifeCounterComponent;
import com.droptableteams.game.components.LocationComponent;

public class RespawnSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;
    private EntityManager _em;

    public RespawnSystem(int id) {
        _id = id;
        _type = "RespawnSystem";
        _cm = ComponentManager.getInstance();
        _em = EntityManager.getInstance();
    }



    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return "RespawnSystem";
    }

    @Override
    public void update() {
        LifeCounterComponent lifeComp = (LifeCounterComponent) _cm.getComponent(_id, "LifeCounterComponent");
        if(lifeComp.getIsDead()) {
            float x = Gdx.graphics.getWidth() / 2f;
            float y = Gdx.graphics.getHeight() / 4f;
            LocationComponent comp = (LocationComponent) _cm.getComponent(_id, "LocationComponent");
            comp.setX(x);
            comp.setY(y);
            lifeComp.beginNewLife();
        }
    }
}
