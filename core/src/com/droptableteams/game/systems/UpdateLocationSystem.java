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
        if(x+dx*dt < 0 || x+dx*dt >= Gdx.graphics.getWidth()){
            if(x+dx*dt >= Gdx.graphics.getWidth()){
                lc.setX(Gdx.graphics.getWidth());
            }else if(x+dx*dt < 0){
                lc.setX(0);
            }
        }else{
            lc.setX(x+dx*dt);
        }
        if(y+dy*dt < 0 || y+dy*dt >= Gdx.graphics.getHeight()){
            if(y+dy*dt > Gdx.graphics.getHeight()){
                lc.setY(Gdx.graphics.getHeight());
            }else if(y+dy*dt < 0){
                lc.setY(0);
            }
        }else{
            lc.setY(y+dy*dt);
        }
    }
}
