package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.*;
import com.droptableteams.game.entities.types.BulletType;
import com.droptableteams.game.entities.types.BulletTypeFactory;
import com.droptableteams.game.util.BulletData;
import com.droptableteams.game.factories.BulletEntityFactory;
import com.droptableteams.game.util.constants.SpecialEntityIds;

public class FireControlSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public FireControlSystem(int id) {
        _id = id;
        _type = "FireControlSystem";
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
        LocationComponent lc = (LocationComponent)ComponentManager.getInstance().getComponent(_id, "LocationComponent");
        FireControlComponent fcc = (FireControlComponent)_cm.getComponent(_id, "FireControlComponent");
        FirePatternComponent fpc = (FirePatternComponent)_cm.getComponent(_id, "FirePatternComponent");
        AssetManagerComponent amc = (AssetManagerComponent)_cm.getComponent(SpecialEntityIds.GAME_ENTITY, "AssetManagerComponent");
        GameCheatsComponent gcc = (GameCheatsComponent) _cm.getComponent(SpecialEntityIds.GAME_ENTITY, "GameCheatsComponent");
        BulletType bt = BulletTypeFactory.make(fpc.getBulletType());

        float newDirection = (fpc.getDeltaTheta()*Gdx.graphics.getDeltaTime()*gcc.getSpeedMultiplier())+fpc.getBaseDirection();
        fpc.setBaseDirection(newDirection);
        BulletData bd = new BulletData(fpc.getBaseDirection(),
                bt.getSpeed(), 16,16, lc.getX(), lc.getY(), bt.getTexture());
        if(fcc.isFiring()) {
            long time = System.nanoTime();
            long deltaTime = time - fcc.getLastFired();
            if((float)(deltaTime/Math.pow(10,9)*gcc.getSpeedMultiplier()) > fcc.getRateOfFire()) {
                BulletEntityFactory.create(amc.getAssetManager(), bd);
                fcc.setLastFired(time);
            }
        }
    }
}
