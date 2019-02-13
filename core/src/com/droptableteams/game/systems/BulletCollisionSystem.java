package com.droptableteams.game.systems;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.EntityManager;
import com.droptableteams.game.LibECS.interfaces.IEntity;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.CollisionsComponent;
import com.droptableteams.game.components.HitboxComponent;
import com.droptableteams.game.components.OwnerComponent;
import com.droptableteams.game.util.constants.SpecialEntityIds;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

import java.security.acl.Owner;
import java.util.Map;
import java.util.Set;

/**
 * TODO: find way to make collision system generic?
 * TODO: decouple damage from collision...
 */
public class BulletCollisionSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;
    private EntityManager _em;

    public BulletCollisionSystem(int id) {
        _id = id;
        _type = "BulletCollisionSystem";
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

    @Override
    public void update() {
        OwnerComponent oc = (OwnerComponent)_cm.getComponent(_id, "OwnerComponent");
        HitboxComponent thisHbc = (HitboxComponent)_cm.getComponent(_id, "HitboxComponent");
        Rectangle intersection = new Rectangle();

        if(oc.getOwnerId() != SpecialEntityIds.PLAYER_ENTITY) {
            HitboxComponent thatHbc = (HitboxComponent)_cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "HitboxComponent");
            CollisionsComponent cc = (CollisionsComponent)_cm.getComponent(SpecialEntityIds.PLAYER_ENTITY, "CollisionsComponent");
            if(Intersector.intersectRectangles(thisHbc.getHitbox(), thatHbc.getHitbox(), intersection)) {
                cc.addCollision(_id);
                ECSEngine.getInstance(SystemUpdateOrder.get()).flagEntityForRemoval(_id);
            }
        }
        else {
            Set<Map.Entry<Integer, IEntity>> entries = _em.getEntities("EnemyEntity").entrySet();
            for(Map.Entry<Integer, IEntity> e : entries) {
                int enemyId = e.getKey();

                HitboxComponent thatHbc = (HitboxComponent)_cm.getComponent(enemyId, "HitboxComponent");
                CollisionsComponent cc = (CollisionsComponent)_cm.getComponent(enemyId, "CollisionsComponent");
                if(Intersector.intersectRectangles(thisHbc.getHitbox(), thatHbc.getHitbox(), intersection)) {
                    cc.addCollision(_id);
                    ECSEngine.getInstance(SystemUpdateOrder.get()).flagEntityForRemoval(_id);
                }
            }
        }
    }
}
