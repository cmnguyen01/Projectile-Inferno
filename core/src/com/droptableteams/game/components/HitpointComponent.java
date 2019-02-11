package com.droptableteams.game.components;

public class HitpointComponent {
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
}
