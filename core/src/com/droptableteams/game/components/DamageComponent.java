package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class DamageComponent implements IComponent {
    private int _id;
    private String _type;
    private int _damage;

    public DamageComponent(int id, int damage) {
        _id = id;
        _damage = damage;
        _type = "DamageComponent";
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }

    public int getDamage() {
        return _damage;
    }

    public void setDamage(int damage) {
        _damage = damage;
    }
}
