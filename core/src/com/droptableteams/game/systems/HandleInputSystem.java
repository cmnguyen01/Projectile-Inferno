package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.FireControlComponent;
import com.droptableteams.game.components.FirePatternComponent;
import com.droptableteams.game.components.GameCheatsComponent;
import com.droptableteams.game.components.MoveDirectionComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.Directions;

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
        MoveDirectionComponent mdc = (MoveDirectionComponent)_cm.getComponent(_id, "MoveDirectionComponent");
        FireControlComponent fcc = (FireControlComponent)_cm.getComponent(_id, "FireControlComponent");
        FirePatternComponent fpc = (FirePatternComponent)_cm.getComponent(_id, "FirePatternComponent");
        GameCheatsComponent gcc = (GameCheatsComponent)
                _cm.getComponent(SpecialEntityIds.getGameEntityId(), "GameCheatsComponent");
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean dn = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean speedButton = Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT);
        boolean fireButton = Gdx.input.isKeyPressed(Input.Keys.SPACE);
        boolean fireModeButton = Gdx.input.isKeyJustPressed(Input.Keys.F);

        if(speedButton){
            gcc.toggleSpeedMultiplier();
        }
        if(fireButton) {
             fcc.setFiring(true);
        }
        else {
            fcc.setFiring(false);
        }
        if(fireModeButton) {
            if(fpc.getNumberOfBullets() == 1) {
                fpc.setNumberOfBullets(3);
            }
            else if(fpc.getNumberOfBullets() == 3) {
                fpc.setNumberOfBullets(5);
            }
            else {
                fpc.setNumberOfBullets(1);
            }
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
                mdc.setRadians(Directions.UP);
            }
            else if(dn) {
                mdc.setRadians(Directions.DOWN);
            }
            else {
                mdc.setRadians(null);
            }
        }
        else if(!up && !dn) {
            if(right) {
                mdc.setRadians(Directions.RIGHT);
            }
            else if(left) {
                mdc.setRadians(Directions.LEFT);
            }
            else {
                mdc.setRadians(null);
            }
        }
        else if(up && right) {
            mdc.setRadians(Directions.UP_RIGHT);
        }
        else if(up && left) {
            mdc.setRadians(Directions.UP_LEFT);
        }
        else if(dn && right) {
            mdc.setRadians(Directions.DOWN_RIGHT);
        }
        else if(dn && left) {
            mdc.setRadians(Directions.DOWN_LEFT);
        }
    }
}
