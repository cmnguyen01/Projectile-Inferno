package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.FireControlComponent;
import com.droptableteams.game.components.FirePatternComponent;
import com.droptableteams.game.components.GameCheatsComponent;
import com.droptableteams.game.components.MoveDirectionComponent;
import com.droptableteams.game.util.constants.DirectionBitMask;
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
        boolean speedButton = Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT);
        boolean fireModeButton = Gdx.input.isKeyJustPressed(Input.Keys.F);

        setDirection(mdc);
        if(speedButton){
            gcc.toggleSpeedMultiplier();
        }
        if(fireModeButton) {
            cycleFireMode(fpc);
        }
    }

    private void cycleFireMode(FirePatternComponent fpc) {
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

    private byte setDirectionBitMask() {
        byte input = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            input |= DirectionBitMask.UP;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            input |= DirectionBitMask.DOWN;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            input |= DirectionBitMask.LEFT;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            input |= DirectionBitMask.RIGHT;
        }
        return input;
    }

    private void setDirection(MoveDirectionComponent mdc) {
        switch (setDirectionBitMask()) {
            case DirectionBitMask.LEFT:
                mdc.setRadians(Directions.LEFT);
                break;
            case DirectionBitMask.UP_LEFT:
                mdc.setRadians(Directions.UP_LEFT);
                break;
            case DirectionBitMask.UP:
                mdc.setRadians(Directions.UP);
                break;
            case DirectionBitMask.UP_RIGHT:
                mdc.setRadians(Directions.UP_RIGHT);
                break;
            case DirectionBitMask.RIGHT:
                mdc.setRadians(Directions.RIGHT);
                break;
            case DirectionBitMask.DOWN_RIGHT:
                mdc.setRadians(Directions.DOWN_RIGHT);
                break;
            case DirectionBitMask.DOWN:
                mdc.setRadians(Directions.DOWN);
                break;
            case DirectionBitMask.DOWN_LEFT:
                mdc.setRadians(Directions.DOWN_LEFT);
                break;
            default:
                mdc.setRadians(null);
        }
    }
}
