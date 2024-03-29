package com.droptableteams.game.systems;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.ECSEngine;
import com.droptableteams.game.LibECS.interfaces.ISystem;
import com.droptableteams.game.components.CollisionsComponent;
import com.droptableteams.game.components.DamageComponent;
import com.droptableteams.game.components.HitpointComponent;
import com.droptableteams.game.util.constants.SystemUpdateOrder;

public class CollisionDamageSystem implements ISystem {
    private int _id;
    private String _type;
    private ComponentManager _cm;

    public CollisionDamageSystem(int id) {
        _id = id;
        _type = "CollisionDamageSystem";
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
        CollisionsComponent cc = (CollisionsComponent)_cm.getComponent(_id, "CollisionsComponent");
        HitpointComponent hc = (HitpointComponent)_cm.getComponent(_id, "HitpointComponent");
        ECSEngine engine = ECSEngine.getInstance(SystemUpdateOrder.get());

        for(int thatId : cc.getCollisions()) {
            DamageComponent thatDc = (DamageComponent)_cm.getComponent(thatId, "DamageComponent");
            if(null != thatDc) {
                hc.subtractHp(thatDc.getDamage());
                if(hc.getHp() <= 0) {
                    engine.flagEntityForRemoval(_id); // TODO: fix crash on player death.
                    break;
                }
            }
        }
        cc.clearCollisions();
    }
}
