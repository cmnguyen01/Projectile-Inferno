package com.droptableteams.game.events;

import com.droptableteams.game.LibECS.interfaces.IEvent;

import java.util.HashMap;

public class BulletCollisionEvent implements IEvent {
    private int _id;
    private String _type;
    private HashMap<String, Object> _args;
    public BulletCollisionEvent(int collidedWithId, String bulletType) {
        _id = collidedWithId;
        _type = "BulletCollisionEvent";
        _args = new HashMap<String, Object>();
        _args.put("bulletType", bulletType);
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
    public HashMap<String, Object> getArgs() {
        return _args;
    }
}
