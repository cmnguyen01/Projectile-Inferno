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
        float multiplier = vc.getSpeedMultiplier();
        float newX = x+dx*dt*multiplier;
        float newY = y+dy*dt*multiplier;
        if(newX < 0 || newX >= Gdx.graphics.getWidth()){
            if(newX >= Gdx.graphics.getWidth()){
                lc.setX(Gdx.graphics.getWidth());
            }else if(x+dx*dt < 0){
                lc.setX(0);
            }
        }else{
            lc.setX(newX);
        }
        if(newY < 0 || newY >= Gdx.graphics.getHeight()){
            if(newY > Gdx.graphics.getHeight()){
                lc.setY(Gdx.graphics.getHeight());
            }else if(newY < 0){
                lc.setY(0);
            }
        }else{
            lc.setY(newY);
        }
    }
}
