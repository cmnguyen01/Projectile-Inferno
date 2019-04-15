package com.droptableteams.game.systems.game;

import com.badlogic.gdx.assets.AssetManager;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.IComponent;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.builders.LifeDisplayBuilder;
import com.droptableteams.game.components.LifeCounterComponent;
import com.droptableteams.game.components.game.AssetManagerComponent;
import com.droptableteams.game.entities.LifeDisplayEntity;
import com.droptableteams.game.entities.PlayerEntity;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class LifeUpdateSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;
    private EntityManager _em;

    public LifeUpdateSystem(int id) {
        _id = id;
        _type = "LifeUpdateSystem";
        _cm = ComponentManager.getInstance();
        _em = EntityManager.getInstance();
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void update() {
        AssetManager am = ((AssetManagerComponent) _cm.getComponent(_id, "AssetManagerComponent")).getAssetManager();
        LifeCounterComponent counter =(LifeCounterComponent) _cm.getComponents("LifeCounterComponent").get(SpecialEntityIds.PLAYER_ENTITY);
        ECSEngine engine = ECSEngine.getInstance(SystemUpdateOrder.get());
        int currentEntityCount = _cm.getComponents("LifeDisplayEntity").size();
        while( currentEntityCount > counter.getLifeCount()){
            int currentLife = FindHighestLifeID();
            engine.flagEntityForRemoval(currentLife);
        }
        while(currentEntityCount < counter.getLifeCount()) {
            engine.addEntity(LifeDisplayBuilder.getInstance(am));
        }
    }

    private int FindHighestLifeID() {
        int max = 0;
        for(IComponent x : _cm.getComponents("LifeDisplayEntity").values()){
            if(x.getId() > max){
                max = x.getId();
            }
        }
        return max;
    }
}
