package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.LocationComponent;
import com.droptableteams.game.components.VelocityComponent;

public class UpdateLocationSystem implements ISystem {
    private int _id;
    private String _type;
    ComponentManager _cm;

    public UpdateLocationSystem(int id) {
        _id = id;
        _type = "UpdateLocationSystem";
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
        VelocityComponent vc = (VelocityComponent)_cm.getComponent(_id, "VelocityComponent");

        float dt = Gdx.graphics.getDeltaTime();
        float dx = vc.getDx();
        float dy = vc.getDy();
        float x = lc.getX();
        float y = lc.getY();
        if(x < 0){
            x=0;
        }
        if(y < 0){
            y = 0;
        }
        if(x > Gdx.graphics.getWidth()){
            x = Gdx.graphics.getWidth();
        }
        if(y > Gdx.graphics.getHeight()){
            y = Gdx.graphics.getHeight();
        }
        lc.setX(x+dx*dt);
        lc.setY(y+dy*dt);
    }
}
