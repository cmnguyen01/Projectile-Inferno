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
import com.sun.javafx.scene.traversal.Direction;

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
        GameCheatsComponent gcc = (GameCheatsComponent)
                _cm.getComponent(SpecialEntityIds.getGameEntityId(), "GameCheatsComponent");
        boolean speedButton = Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT);
        boolean fireModeButton = Gdx.input.isKeyJustPressed(Input.Keys.F);
        boolean ultimateButton = Gdx.input.isKeyJustPressed(Input.Keys.Q);
        boolean teeButton = Gdx.input.isKeyJustPressed(Input.Keys.T);

        setDirection();
        if(ultimateButton) {
            toggleUltimate();
        }
        if(teeButton) {
            toggleTeeMode();
        }
        if(speedButton){
            gcc.toggleSpeedMultiplier();
        }
        if(fireModeButton) {
            cycleFireMode();
        }
    }

    private void toggleUltimate() {
        FirePatternComponent fpc = (FirePatternComponent)_cm.getComponent(_id, "FirePatternComponent");
        FireControlComponent fcc = (FireControlComponent)_cm.getComponent(_id, "FireControlComponent");
        if(fpc.getNumberOfBullets() < 24) {
            fpc.setNumberOfBullets(24);
            fpc.setDeltaTheta((float)Math.PI/6);
            fcc.setRateOfFire(fcc.getRateOfFire()/2);
        }
        else {
            fpc.setNumberOfBullets(1);
            fcc.setRateOfFire(fcc.getRateOfFire()*2);
            fpc.setBaseDirection(Directions.UP);
            fpc.setDeltaTheta(0);
        }
    }

    private void toggleTeeMode() {
        FirePatternComponent fpc = (FirePatternComponent)_cm.getComponent(_id, "FirePatternComponent");
        FireControlComponent fcc = (FireControlComponent)_cm.getComponent(_id, "FireControlComponent");
        if(fpc.getDividingAngle() != (float)Math.PI/2) {
            fpc.setDividingAngle((float)Math.PI/2); // hardcoded :(
        }
        else {
            fpc.setDividingAngle((float)Math.PI/12);
        }
    }

    private void cycleFireMode() {
        FirePatternComponent fpc = (FirePatternComponent)_cm.getComponent(_id, "FirePatternComponent");
        FireControlComponent fcc = (FireControlComponent)_cm.getComponent(_id, "FireControlComponent");
        if(fpc.getNumberOfBullets() == 1) {
            fpc.setNumberOfBullets(3);
        }
        else if(fpc.getNumberOfBullets() == 3) {
            fpc.setNumberOfBullets(5);
        }
        else if(fpc.getNumberOfBullets() == 5) {
            fpc.setNumberOfBullets(24);
            fpc.setDeltaTheta((float)Math.PI/6);
            fcc.setRateOfFire(fcc.getRateOfFire()/2);
        }
        else {
            fpc.setNumberOfBullets(1);
            fcc.setRateOfFire(fcc.getRateOfFire()*2);
            fpc.setBaseDirection(Directions.UP);
            fpc.setDeltaTheta(0);
        }
    }

    private byte setDirectionBitMask() {
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        byte input = 0;
        if(up && !down) {
            input |= DirectionBitMask.UP;
        }
        if(down && !up) {
            input |= DirectionBitMask.DOWN;
        }
        if(left && !right) {
            input |= DirectionBitMask.LEFT;
        }
        if(right && !left) {
            input |= DirectionBitMask.RIGHT;
        }
        return input;
    }

    private void setDirection() {
        MoveDirectionComponent mdc = (MoveDirectionComponent)_cm.getComponent(_id, "MoveDirectionComponent");
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
