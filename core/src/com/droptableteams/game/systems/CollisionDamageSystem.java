package com.droptableteams.game.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Json;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.builders.PowerUpEntityBuilder;
import com.droptableteams.game.components.*;
import com.droptableteams.game.components.game.AssetManagerComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;
import com.droptableteams.game.util.data.PowerUpData;

public class CollisionDamageSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;
    private EntityManager _em;
    private Sound _sound;
    private AssetManager _am;

    public CollisionDamageSystem(int id) {
        _id = id;
        _type = "CollisionDamageSystem";
        _cm = ComponentManager.getInstance();
        _em = EntityManager.getInstance();
        _sound = Gdx.audio.newSound(Gdx.files.internal("audio/damage_sound_effect.mp3"));
        _am = ((AssetManagerComponent)_cm.getComponent(SpecialEntityIds.GAME_ENTITY, "AssetManagerComponent")).getAssetManager();

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
        CollisionsComponent cc = (CollisionsComponent)_cm.getComponent(_id, "CollisionsComponent");
        HitpointComponent hc = (HitpointComponent)_cm.getComponent(_id, "HitpointComponent");
        ECSEngine engine = ECSEngine.getInstance(SystemUpdateOrder.get());

        for(int thatId : cc.getCollisions()) {

            DamageComponent thatDc = (DamageComponent)_cm.getComponent(thatId, "DamageComponent");
            if(null != thatDc) {
                hc.subtractHp(thatDc.getDamage());

                // playing the taking damage sound effect
                if(_id == SpecialEntityIds.PLAYER_ENTITY) {
                    _sound.play(1.0f);
                }

                if (hc.getHp() <= 0) {
                    if (_id == SpecialEntityIds.PLAYER_ENTITY) {
                        ((LifeCounterComponent) _cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "LifeCounterComponent")).decrementLife();
                    } else {
                        //int playerID = _em.getEntityIds("PlayerEntity")[0];
                        // Check if _id is an enemy id and if the enemy has a powerupcomponent

                        PowerUpComponent powerUp = (PowerUpComponent)_cm.getComponent(_id, "PowerUpComponent");
                        if(powerUp != null && powerUp._hasPowerUp){
                            Json json = new Json();

                            PowerUpData pd = json.fromJson(PowerUpData.class, Gdx.files.internal(powerUp._powerUpType));
                            LocationComponent lc = (LocationComponent)_cm.getComponent(_id, "LocationComponent");
                            pd.x = lc.getX();
                            pd.y = lc.getY();

                            PowerUpEntityBuilder pueb = PowerUpEntityBuilder.getInstance(_am);
                            pueb.setBuildData(pd);
                            engine.addEntity(pueb);
                            pueb.finishBuild();
                        }
                        engine.flagEntityForRemoval(_id);

                    }
                    break;
                }
            }
        }
        cc.clearCollisions();
    }
}
