package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.AssetManagerComponent;
import com.droptableteams.game.components.FireControlComponent;
import com.droptableteams.game.components.SpriteComponent;
import com.droptableteams.game.factories.PlayerBulletEntityFactory;

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
        FireControlComponent fcc = (FireControlComponent)_cm.getComponent(_id, "FireControlComponent");
        AssetManagerComponent amc = (AssetManagerComponent)_cm.getComponent(-1, "AssetManagerComponent");
        if(fcc.isFiring()) {
            long time = System.nanoTime();
            long deltaTime = time - fcc.getLastFired();
            if((float)(deltaTime/Math.pow(10,9)) > fcc.getRateOfFire()) {
                PlayerBulletEntityFactory.create(amc.getAssetManager());
                fcc.setLastFired(time);
            }
        }
    }
}
