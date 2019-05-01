package com.droptableteams.game.systems;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.CollisionsComponent;
import com.droptableteams.game.components.HitboxComponent;
import com.droptableteams.game.components.LifeCounterComponent;
import com.droptableteams.game.components.OwnerComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class PowerUpCollisionSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;
    private EntityManager _em;

    public PowerUpCollisionSystem(int id){
        _id = id;
        _type = "PowerUpCollisionSystem";
        _cm = ComponentManager.getInstance();
        _em = EntityManager.getInstance();
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    // Copied from bullet collision system. Needs to be restructured in order to
    // work with power ups
    @Override
    public void update() {
        //OwnerComponent oc = (OwnerComponent)_cm.getComponent(_id, "OwnerComponent");
        HitboxComponent thisHbc = (HitboxComponent)_cm.getComponent(_id, "HitboxComponent");
        Rectangle intersection = new Rectangle();


            HitboxComponent thatHbc = (HitboxComponent)_cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "HitboxComponent");
            CollisionsComponent cc = (CollisionsComponent)_cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "CollisionsComponent");
            if(Intersector.intersectRectangles(thisHbc.getHitbox(), thatHbc.getHitbox(), intersection)) {
                cc.addCollision(_id);
                ((LifeCounterComponent)_cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "LifeCounterComponent")).incrementLife();

                ECSEngine.getInstance(SystemUpdateOrder.get()).flagEntityForRemoval(_id);
            }


    }
}
