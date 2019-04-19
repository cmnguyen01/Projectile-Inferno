package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
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
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void update() {
        float x = Gdx.graphics.getWidth()/2f;
        float y = Gdx.graphics.getHeight()/4f;
        //LocationComponent comp =  _cm.getComponent(_id, "LocationComponent");
    }
}
