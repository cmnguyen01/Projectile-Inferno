package com.droptableteams.game.components;

import com.badlogic.gdx.utils.Array;
import com.droptableteams.game.LibECS.interfaces.IComponent;

public class CollisionsComponent implements IComponent {
    private int _id;
    private String _type;
    private Array<Integer> _collisions;

    public CollisionsComponent(int id) {
        _id = id;
        _type = "CollisionsComponent";
        _collisions = new Array<Integer>();
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }


    public Array<Integer> getCollisions() {
        return _collisions;
    }

    public void addCollision(int collidedWithId) {
        _collisions.add(collidedWithId);
    }

    public void clearCollisions() {
        _collisions.clear();
    }
}
