package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.AssetManagerComponent;
import com.droptableteams.game.components.MoveDirectionComponent;
import com.droptableteams.game.components.VelocityComponent;
import com.droptableteams.game.factories.PlayerBulletEntityFactory;

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
        MoveDirectionComponent mdc = (MoveDirectionComponent)_cm.getComponent(_id, "MoveDirectionComponent");
        AssetManagerComponent amc = (AssetManagerComponent)_cm.getComponent(-1, "AssetManagerComponent");
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean dn = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean speedButton = Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT);
        boolean fireButton = Gdx.input.isKeyJustPressed(Input.Keys.SPACE);

        if(speedButton){
            vc.toggleSpeedMultiplier();
        }
        if(fireButton) {
             PlayerBulletEntityFactory.create(amc.getAssetManager());
        }

        if(left && right) {
            left = false;
            right = false;
        }
        if(up && dn) {
            up = false;
            dn = false;
        }

        if(!left && !right) {
            if(up) {
                mdc.setRadians((float)(Math.PI/2));
            }
            else if(dn) {
                mdc.setRadians((float)(3*Math.PI/2));
            }
            else {
                mdc.setRadians(null);
            }
        }
        else if(!up && !dn) {
            if(right) {
                mdc.setRadians(0f);
            }
            else if(left) {
                mdc.setRadians((float)Math.PI);
            }
            else {
                mdc.setRadians(null);
            }
        }
        else if(up && right) {
            mdc.setRadians((float)(Math.PI/4));
        }
        else if(up && left) {
            mdc.setRadians((float)(3*Math.PI/4));
        }
        else if(dn && right) {
            mdc.setRadians((float)(7*Math.PI/4));
        }
        else if(dn && left) {
            mdc.setRadians((float)(5*Math.PI/4));
        }
    }
}
