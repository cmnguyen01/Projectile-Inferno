package com.droptableteams.game.listeners;

import com.droptableteams.game.LibECS.ComponentManager;
import com.droptableteams.game.LibECS.interfaces.IEventListener;
import com.droptableteams.game.components.HitpointComponent;
import com.droptableteams.game.util.types.BulletType;
import com.droptableteams.game.util.types.BulletTypeFactory;

import java.util.HashMap;

public class BulletCollisionEventListener implements IEventListener {
    private int _id;
    private String _type;
    private String _triggerType;

    public BulletCollisionEventListener(int id) {
        _id = id;
        _type = "BulletCollision";
        _triggerType = "BulletCollisionEvent";
    }

    @Override
    public Integer getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    @Override
    public String getTriggerType() {
        return _triggerType;
    }

    @Override
    public boolean canHandle(Integer id, String type) {
        return (id == _id && _triggerType == _type);
    }

    @Override
    public void handleEvent(HashMap<String, Object> args) {
        ComponentManager cm = ComponentManager.getInstance();
        HitpointComponent hpc = (HitpointComponent)cm.getComponent(_id, "HitpointComponent");
        if(args.containsKey("bulletType")) {
            BulletType bt = BulletTypeFactory.make((String)args.get("bulletType"));
            hpc.subtractHp(bt.damage);
        }
    }
}
