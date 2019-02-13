package com.droptableteams.game.components;

import com.droptableteams.game.LibECS.interfaces.IComponent;

public class HitpointComponent implements IComponent {
    private int _id;
    private String _type;
    private int _hp;


    public HitpointComponent(int id, int hp) {
        _id = id;
        _hp = hp;
        _type = "HitpointComponent";
    }

    public int getHp() {
        return _hp;
    }

    public void setHp(int hp) {
        _hp = hp;
    }

    public void subtractHp(int amount) {
        _hp -= amount;
    }

    public void addHp(int amount) {
        _hp += amount;
    }

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public String getType() {
        return _type;
    }
}
