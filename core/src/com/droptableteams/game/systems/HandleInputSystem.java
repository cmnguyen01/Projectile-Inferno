package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.VelocityComponent;

public class HandleInputSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public HandleInputSystem(int id) {
        _id = id;
        _type = "HandleInputSystem";
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
        VelocityComponent vc = (VelocityComponent)_cm.getComponent(_id, "VelocityComponent");
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean dn = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if(left && right) {
            left = false;
            right = false;
        }
        if(up && dn) {
            up = false;
            dn = false;
        }

        if(!left && !right) {
            vc.setDx(0);
            if(up) {
                vc.setDy(vc.getBaseSpeed());
            }
            else if(dn) {
                vc.setDy(vc.getBaseSpeed()*-1);
            }
            else {
                vc.setDy(0);
            }
        }
        else if(!up && !dn) {
            vc.setDy(0);
            if(right) {
                vc.setDx(vc.getBaseSpeed());
            }
            else if(left) {
                vc.setDx(vc.getBaseSpeed()*-1);
            }
            else {
                vc.setDx(0);
            }
        }
        else if(up && right) {
            float axisSpeed = vc.getBaseSpeed()/(float)Math.sqrt(2.0f);
            vc.setDx(axisSpeed);
            vc.setDy(axisSpeed);
        }
        else if(up && left) {
            float axisSpeed = vc.getBaseSpeed()/(float)Math.sqrt(2.0f);
            vc.setDx(axisSpeed*-1);
            vc.setDy(axisSpeed);
        }
        else if(dn && right) {
            float axisSpeed = vc.getBaseSpeed()/(float)Math.sqrt(2.0f);
            vc.setDx(axisSpeed);
            vc.setDy(axisSpeed*-1);
        }
        else if(dn && left) {
            float axisSpeed = vc.getBaseSpeed()/(float)Math.sqrt(2.0f);
            vc.setDx(axisSpeed*-1);
            vc.setDy(axisSpeed*-1);
        }
    }
}
